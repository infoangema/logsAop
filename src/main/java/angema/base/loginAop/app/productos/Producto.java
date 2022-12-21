package angema.base.loginAop.app.productos;

import com.sun.istack.NotNull;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name = "DETALLE_PRODUCTO")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idProducto" , "cuitSocio"})})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NotNull
    public String idProducto;
    @NotNull
    public String cuitSocio;
    public String titulo;
    public String slogan;
    public String precioBase;
    public String urlImagen1;
    public String urlImagen2;
}
