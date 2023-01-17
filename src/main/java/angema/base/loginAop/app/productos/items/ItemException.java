package angema.base.loginAop.app.productos.items;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ItemException extends RuntimeException {

    public ItemException(String message){
        super(message);
    }
}
