package angema.base.loginAop.app.productos.producto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity(name = "PRODUCTOS")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idProducto" , "cuitSocio"})})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
    @SequenceGenerator(name = "producto_id_seq", sequenceName = "producto_id_seq")
    public Integer id;

    @NotNull
    public String idProducto;

    @NotNull
    public String cuitSocio;

    @Size(min = 4, max = 43, message = "El titulo debe contener entre 4 y 43 caracteres.")
    @NotBlank(message = "El titulo no puede estar nulo o vacio.")
    public String titulo;

    public String slogan;

    public String urlImagen;

    public String urlImagenPrecio;
}
