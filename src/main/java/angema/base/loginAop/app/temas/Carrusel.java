package angema.base.loginAop.app.temas;

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
    public Integer id;
    public String cuitSocio;
    public String url;
    public String imagen;
    public String tipo;
    public boolean active = true;
    @Column(unique = true)
    public Integer prioridad;

}
