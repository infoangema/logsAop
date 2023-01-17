package angema.base.loginAop.app.temas.dtos;

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
    public NavbarDto navbar;
    public BotonDto boton;
    public List<ImagenCarruselDto> imagenesCarrusel;
}

