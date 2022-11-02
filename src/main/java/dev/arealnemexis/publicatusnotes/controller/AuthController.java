package dev.arealnemexis.publicatusnotes.controller;

import com.sun.istack.NotNull;
import dev.arealnemexis.publicatusnotes.model.dtos.UserDetailsDto;
import dev.arealnemexis.publicatusnotes.model.dtos.request.LoginDto;
import dev.arealnemexis.publicatusnotes.model.dtos.request.RegisterDto;
import dev.arealnemexis.publicatusnotes.model.dtos.response.AuthenticationResponseDto;
import dev.arealnemexis.publicatusnotes.model.dtos.response.DefaultResponseDto;
import dev.arealnemexis.publicatusnotes.service.JwtTokenService;
import dev.arealnemexis.publicatusnotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/signon")
    public ResponseEntity<?> signon(@NotNull @RequestBody RegisterDto requestBody) throws Exception {

        try {
            userService.createUser(requestBody);
        } catch (Exception e) {
            throw e;
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<DefaultResponseDto<?>> signin(@NotNull @RequestBody LoginDto requestBody) throws Exception {
        DefaultResponseDto<?> response;
        HttpStatus status;
        try {
            UserDetailsDto userDetailsDto = userService.authenticateUser(requestBody);
            String jwt = jwtTokenService.generateTokenFromUserDetails(userDetailsDto);
            AuthenticationResponseDto responseDto = new AuthenticationResponseDto(jwt);
            status = HttpStatus.OK;
            response = new DefaultResponseDto<AuthenticationResponseDto>("Login Sucesso", status.value(), responseDto);
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new DefaultResponseDto<>(e.getMessage(), status.value());
        }

        return new ResponseEntity(response, status);
    }
}
