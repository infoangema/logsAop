package angema.base.loginAop.app.productos.detalles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DetalleException extends RuntimeException {

    public DetalleException(String message){
        super(message);
    }
}
