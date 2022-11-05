package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class NotFoundNote extends GenericException{

        public NotFoundNote() {
            super("Nota não encontrada", HttpStatus.NOT_FOUND);
        }
}
