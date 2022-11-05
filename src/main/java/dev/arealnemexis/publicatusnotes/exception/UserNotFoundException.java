package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException {

    public UserNotFoundException() {
        super("Usuário não encontrado", HttpStatus.NOT_FOUND);
    }
}
