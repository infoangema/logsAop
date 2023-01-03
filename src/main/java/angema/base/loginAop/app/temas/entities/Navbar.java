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
@Entity(name="BARRA_NAVEGACION")
public class Navbar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String cuitSocio;
    String colorPrimarioRgba;
    String colorPrimarioRgbaLight;
    String colorSecundarioRgba;
    String colorSecundarioRgbaLight;
    String urlLogo;
}
