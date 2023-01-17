package angema.base.loginAop.app.temas.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity(name="BARRA_NAVEGACION")
public class Navbar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String cuitSocio;
    public String colorPrimarioRgba;
    public String colorPrimarioRgbaLight;
    public String colorSecundarioRgba;
    public String colorSecundarioRgbaLight;
    public String urlLogo;
}
