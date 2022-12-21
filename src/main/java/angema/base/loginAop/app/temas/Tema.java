package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.entities.Color;
import angema.base.loginAop.app.temas.entities.Carrusel;
import angema.base.loginAop.app.temas.entities.NavbarTema;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Entity(name = "TEMAS")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String cuitSocio;
    String nombre;
    String urlLogo;
    String urlImagenFondo;
    String urlTipografia;

    @Transient
    Color color;

    @Transient
    NavbarTema navbarTema;

    @Transient
    List<Carrusel> imagenesCarrusel;

}