package angema.base.loginAop.app.temas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CARRUSEL")
public class Carrusel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String cuitSocio;
    public String nombre;
    public String url;
    public boolean estado;
    public String createdAt;
    public String updatedAt;
}
