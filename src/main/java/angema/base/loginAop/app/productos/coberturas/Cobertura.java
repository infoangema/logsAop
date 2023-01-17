package angema.base.loginAop.app.productos.coberturas;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity(name="COBERTURAS")
public class Cobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NotNull
    public String idProducto;
    @NotNull
    public String cuitSocio;
    public String descripcion;
    public String urlIcono;
    @Column(unique = true)
    public int prioridad;
}
