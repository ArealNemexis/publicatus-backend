package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends GenericException{

    public InvalidCredentialsException(){
        super("Usuário ou senha incorreta", HttpStatus.UNAUTHORIZED);
    }
}
