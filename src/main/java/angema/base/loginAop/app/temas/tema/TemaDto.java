package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionDto;
import angema.base.loginAop.app.temas.boton.BotonDto;
import angema.base.loginAop.app.temas.color.ColorDto;
import angema.base.loginAop.app.temas.carrusel.ImagenCarruselDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemaDto {
    public String cuitSocio;
    public String nombre;
    public String urlLogo;
    public String urlImagenFondo;
    public String urlTipografia;
    public ColorDto color;
    public BarraNavegacionDto navbar;
    public BotonDto boton;
    public List<ImagenCarruselDto> imagenesCarrusel;
}

