package angema.base.loginAop.core.exceptions;

//import angema.base.loginAop.core.auth.AuthException;
import angema.base.loginAop.app.descargas.DescargaException;
import angema.base.loginAop.app.productos.busquedas.BusquedaException;
import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.app.redirect.RedirectException;
import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionException;
import angema.base.loginAop.app.temas.tema.TemaException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
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

    @Autowired
    private GlobalResponseService globalResponseService;

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

    @ExceptionHandler(BusquedaException.class)
    public ResponseEntity<?> busquedaException(BusquedaException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BarraNavegacionException.class)
    public ResponseEntity<?> busquedaException(BarraNavegacionException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DescargaException.class)
    public ResponseEntity<?> descargaException(DescargaException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RedirectException.class)
    public ResponseEntity<?> productoException(RedirectException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<?> productoException(ProductoException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TemaException.class)
    public ResponseEntity<?> temaException(TemaException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        GlobalResponse<?> response = globalResponseService.badRequestResponse(ex.getMessage(), request );
        if(ex.getMessage() != null && ex.getMessage().contains("Access is denied")){
            response.status = HttpStatus.FORBIDDEN;
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
