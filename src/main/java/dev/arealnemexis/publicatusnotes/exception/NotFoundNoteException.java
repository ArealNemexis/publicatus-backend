package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class NotFoundNoteException extends GenericException{

        public NotFoundNoteException() {
            super("Nota não encontrada", HttpStatus.NOT_FOUND);
        }
}
