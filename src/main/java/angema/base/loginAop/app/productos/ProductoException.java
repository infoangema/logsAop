package angema.base.loginAop.app.productos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductoException extends RuntimeException {

    public ProductoException(String message){
        super(message);
    }
}
