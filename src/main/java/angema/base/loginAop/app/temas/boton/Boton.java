package angema.base.loginAop.app.temas.boton;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity(name="BOTONES")
public class Boton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String cuitSocio;
    public String primarioRgba;
    public String primarioRgbaLight;
    public String secundarioRgba;
    public String secundarioRgbaLight;
    public String fondoRgba;
    public String fondoRgbaLight;
}
