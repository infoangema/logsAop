package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.entities.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@Entity(name = "TEMAS")
public class Tema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true, name = "cuit_socio")
    public String cuitSocio;
    @Column(unique = true)
    public String nombre;
    public String urlLogo;
    public String urlImagenFondo;
    public String urlTipografia;

    @Transient
    Color color = new Color();

    @Transient
    Navbar navbar = new Navbar();

    @Transient
    Boton boton = new Boton();

    @Transient
    List<Carrusel> imagenesCarrusel = new ArrayList<>();

}