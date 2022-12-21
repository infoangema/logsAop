package angema.base.loginAop.app.temas.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity(name="NAVBAR_TEMA")
public class NavbarTema {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    Integer id;
    String cuitSocio;
    String colorPrimario;
    String colorPrimarioRgba;
    String colorPrimarioRgbaLight;
    String colorSecundario;
    String colorSecundarioRgba;
    String colorSecundarioRgbaLight;
    String urlLogo;
}
