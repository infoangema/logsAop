package angema.base.loginAop.app.productos.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Entity(name="DETALLES_PRODUCTO")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NotNull
    public String idProducto;
    @NotNull
    public String cuitSocio;
    public String titulo;
    public String descripcion;
    public String subTitulo;
    @Transient
    public List<ItemDetalle> items;
}
