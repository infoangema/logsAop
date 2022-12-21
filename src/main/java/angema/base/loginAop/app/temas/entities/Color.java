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
@Entity(name="COLOR")
public class Color {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    Integer id;
    String cuitSocio;
    String primario;
    String primarioRgba;
    String primarioRgbaLight;
    String secundario;
    String secundarioRgba;
    String secundarioRgbaLight;
    String terciario;
    String terciarioRgba;
    String terciarioRgbaLight;
}
