package org.example.com.demo.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.nio.file.AccessDeniedException;


/**
 * @author :Amr Abdeldayem
 */


@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);


    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        logger.error("Exception IllegalArgumentException, IllegalStateException");
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value
            = { EntityNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            PersistenceException ex, WebRequest request) {
        logger.error("Exception EntityNotFoundException");
        String bodyOfResponse = "Not Found Resource";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        logger.error("Exception AccessDeniedException");
        return new ResponseEntity<Object>(
        "Access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ CustomNotFoundException.class })
    public ResponseEntity<Object> handleCustomException(
            Exception ex, WebRequest request) {
        logger.error("Exception CustomNotFoundException -> {}",ex.getMessage());
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}