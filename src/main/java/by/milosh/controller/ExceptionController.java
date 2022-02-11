package by.milosh.controller;

import by.milosh.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @GetMapping(value = "/{exceptionName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkException(@PathVariable(name = "exceptionName") String exceptionName) throws HttpRequestMethodNotSupportedException {
        if (exceptionName.equals("HttpRequestMethodNotSupportedException")) {
            throw new HttpRequestMethodNotSupportedException("GET", "GET not supported");
        }
        if (exceptionName.equals("ResourceNotFoundException")) {
            throw new ResourceNotFoundException("ResourceNotFoundException message");
        }
        throw new RuntimeException("Runtime exception");
    }
}
