package com.gallery.gallery.exception;

import com.gallery.gallery.response.Response;
import com.gallery.gallery.utils.ImageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ImageNotFoundException.class)
    public final ResponseEntity<Response> handleImageNotFoundException(Exception exception, WebRequest request) throws Exception {
        Response errorMessage = new Response(exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
