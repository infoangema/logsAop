package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacion;
import angema.base.loginAop.app.temas.boton.Boton;
import angema.base.loginAop.app.temas.carrusel.Carrusel;
import angema.base.loginAop.app.temas.color.Color;
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
    BarraNavegacion barraNavegacion = new BarraNavegacion();

    @Transient
    Boton boton = new Boton();

    @Transient
    List<Carrusel> imagenesCarrusel = new ArrayList<>();

}