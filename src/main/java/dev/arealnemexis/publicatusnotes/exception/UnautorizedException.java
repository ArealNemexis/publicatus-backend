package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class UnautorizedException extends GenericException{

    public UnautorizedException() {
        super("Recurso não disponivel", HttpStatus.UNAUTHORIZED);
    }
}
