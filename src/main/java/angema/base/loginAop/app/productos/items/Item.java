package angema.base.loginAop.app.productos.items;

import com.sun.istack.NotNull;
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
@Entity(name="ITEMS_DETALLE_PRODUCTO")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NotNull
    public String idProducto;
    @NotNull
    public String cuitSocio;
    public String descripcion;
    public int prioridad;
}
