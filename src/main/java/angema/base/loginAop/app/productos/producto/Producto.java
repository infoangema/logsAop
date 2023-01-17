package angema.base.loginAop.app.productos.producto;

import angema.base.loginAop.app.productos.coberturas.Cobertura;
import com.sun.istack.NotNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public String precioBase;
    public String urlImagen1;
    public String urlImagen2;
    public String urlImagenPrecio;
    @Transient
    public List<Cobertura> coberturas = new ArrayList<>();
}
