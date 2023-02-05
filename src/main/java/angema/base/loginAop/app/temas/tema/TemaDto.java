package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.boton.BotonDto;
import angema.base.loginAop.app.temas.color.ColorDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemaDto {
    public Integer id;

    public String cuitSocio;
    public String nombre;
    public String urlLogo;
    public String urlImagenFondo;
    public String urlTipografia;
    public ColorDto color;
    public BotonDto boton;
}

