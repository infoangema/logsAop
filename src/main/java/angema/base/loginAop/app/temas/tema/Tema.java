package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.boton.Boton;
import angema.base.loginAop.app.temas.color.Color;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    Boton boton = new Boton();
}
