package angema.base.loginAop.app.temas.carrusel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CarruselException extends RuntimeException {

    public CarruselException(String message){
        super(message);
    }
}
