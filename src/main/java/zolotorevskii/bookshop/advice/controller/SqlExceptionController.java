package zolotorevskii.bookshop.advice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class SqlExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedErrorException(Exception ex) {
        log.error("Exception: {}", ex.toString());
        return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
    }
}
