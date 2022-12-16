package angema.base.loginAop.app.productos;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Entity(name = "DETALLE_PRODUCTO")
public class ProductoEntity {
    @Id
    public Integer id;
    public String idProducto;
    public String cuitSocio;
    public String titulo;
    public String slogan;
    public String precioBase;
    public String urlImagen;
}
