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
@Entity(name="BOTONES")
public class Boton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String cuitSocio;
    String primarioRgba;
    String primarioRgbaLight;
    String secundarioRgba;
    String secundarioRgbaLight;
    String fondoRgba;
    String fondoRgbaLight;
}
