package by.milosh.exception.handler;

import by.milosh.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle any Internal Server Error
     */
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(null, null, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleCustomException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new RestErrorResponse("Resource not found"), new HttpHeaders(), NOT_FOUND);
    }
}
