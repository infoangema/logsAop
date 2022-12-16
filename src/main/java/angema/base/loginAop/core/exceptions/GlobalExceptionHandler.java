package angema.base.loginAop.core.exceptions;

//import angema.base.loginAop.core.auth.AuthException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Order(-2)
public class GlobalExceptionHandler {

    @Autowired
    private DateUtil dateUtil;

//    @ExceptionHandler(AuthException.class)
//    public ResponseEntity<?> authException(AuthException ex, WebRequest request) {
//        GlobalResponse response = new GlobalResponse();
//        response.status = HttpStatus.UNAUTHORIZED;
//        response.path = request.getDescription(false);
//        response.timestamp = dateUtil.getDateString();
//        response.body = null;
//        response.error = ex.getMessage();
//        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        GlobalResponse response = new GlobalResponse();
        response.status = HttpStatus.NOT_FOUND;
        response.path = request.getDescription(false);
        response.timestamp = dateUtil.getDateString();
        response.body = null;
        response.error = ex.getMessage();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        GlobalResponse response = new GlobalResponse();
        response.status = HttpStatus.INTERNAL_SERVER_ERROR;
        response.path = request.getDescription(false);
        response.timestamp = dateUtil.getDateString();
        response.body = null;
        response.error = ex.getMessage();
        if(ex.getMessage() != null && ex.getMessage().contains("Access is denied")){
            response.status = HttpStatus.FORBIDDEN;
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
