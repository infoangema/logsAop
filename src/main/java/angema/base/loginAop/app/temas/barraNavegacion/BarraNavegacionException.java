package angema.base.loginAop.app.temas.barraNavegacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class BarraNavegacionException extends RuntimeException {

    public BarraNavegacionException(String message){
        super(message);
    }
}
