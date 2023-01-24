package angema.base.loginAop.app.temas.carrusel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CARRUSEL")
public class Carrusel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String cuitSocio;
    public String nombre;
    public String url;
    public boolean estado;
    public String createdAt;
    public String updatedAt;
    @Column(unique = true)
    public Integer prioridad;
}
