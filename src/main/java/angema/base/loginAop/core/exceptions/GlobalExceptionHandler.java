package angema.base.loginAop.core.exceptions;

import angema.base.loginAop.core.auth.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> authException(AuthException ex, WebRequest request) {
        GlobalResponse response = new GlobalResponse();
        response.status = HttpStatus.UNAUTHORIZED;
        response.path = request.getDescription(false);
        response.timestamp = new Date();
        response.body = null;
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        response.error = errorDetails;
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        GlobalResponse response = new GlobalResponse();
        response.status = HttpStatus.NOT_FOUND;
        response.path = request.getDescription(false);
        response.timestamp = new Date();
        response.body = null;
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        response.error = errorDetails;
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        GlobalResponse response = new GlobalResponse();
        response.status = HttpStatus.INTERNAL_SERVER_ERROR;
        response.path = request.getDescription(false);
        response.timestamp = new Date();
        response.body = null;
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        response.error = errorDetails;
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
