package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyRegistredException extends GenericException{

    public UserAlreadyRegistredException(){
        super("Email já cadastrado", HttpStatus.CONFLICT);
    }
}
