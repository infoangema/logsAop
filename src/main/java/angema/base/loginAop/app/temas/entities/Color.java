package angema.base.loginAop.app.temas.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity(name="COLORES")
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String cuitSocio;
    public String primarioRgba;
    public String primarioRgbaLight;
    public String secundarioRgba;
    public String secundarioRgbaLight;
    public String terciarioRgba;
    public String terciarioRgbaLight;
}
