package dev.arealnemexis.publicatusnotes.controller;

import dev.arealnemexis.publicatusnotes.model.dtos.response.DefaultResponseDto;
import dev.arealnemexis.publicatusnotes.service.JwtTokenService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @GetMapping("/test")
    public ResponseEntity<DefaultResponseDto<?>> getNotes(@RequestHeader("Authorization") String token) {
        DefaultResponseDto<?> responsePayload;
        HttpStatus httpStatus;
        try {
            String id = jwtTokenService.validateToken(token);

            System.out.println(id);
            httpStatus = HttpStatus.OK;
            responsePayload = new DefaultResponseDto(id, httpStatus.value());
        } catch (ExpiredJwtException e) {
            httpStatus = HttpStatus.UNAUTHORIZED;
            responsePayload = new DefaultResponseDto("Token expirado", httpStatus.value());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            responsePayload = new DefaultResponseDto("Ocorreu um erro interno", httpStatus.value());
        }
        ResponseEntity<DefaultResponseDto<?>> response;

        response = new ResponseEntity<DefaultResponseDto<?>>(responsePayload, httpStatus);
        return response;
    }
}
