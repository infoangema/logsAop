package angema.base.loginAop.app.productos.busquedas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusquedaException extends RuntimeException {

    public BusquedaException(String message){
        super(message);
    }
}
