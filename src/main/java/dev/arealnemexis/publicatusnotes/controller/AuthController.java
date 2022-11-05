package dev.arealnemexis.publicatusnotes.controller;

import com.sun.istack.NotNull;
import dev.arealnemexis.publicatusnotes.datasource.dtos.request.LoginDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.request.RegisterDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.AuthenticationResponseDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.DefaultResponseDto;
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


    @PostMapping("/login")
    public ResponseEntity<DefaultResponseDto<?>> login(@NotNull @RequestBody LoginDto requestBody) throws Exception {
        DefaultResponseDto<?> response;

        String jwt = userService.login(requestBody);
        AuthenticationResponseDto responseDto = new AuthenticationResponseDto(jwt);
        response = new DefaultResponseDto<AuthenticationResponseDto>("Login Sucesso", HttpStatus.OK.value(), responseDto);


        return ResponseEntity.ok(response);
    }
}
