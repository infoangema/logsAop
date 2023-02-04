package angema.base.loginAop.app.productos.producto;

import com.sun.istack.NotNull;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name = "PRODUCTOS")
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
    public String urlImagen;
    public String urlImagenPrecio;
}
