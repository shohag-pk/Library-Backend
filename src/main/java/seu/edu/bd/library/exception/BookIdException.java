package seu.edu.bd.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookIdException extends RuntimeException {

    public BookIdException(String message) {
        super(message);
    }
}
