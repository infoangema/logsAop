package angema.base.loginAop.app.product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "product_detail")
public class Product {
    @Id
    private Integer id;
    private String idProducto;
    private String cuitSocio;
    private String SeccionCeroTitulo;
    private String SeccionCeroPrecioBase;
    private String SeccionCeroDescripcion;
    private String SeccionUnoDescripcion;
    private String SeccionUnoDescripcionDos;
    //tabla product_item
    private String seccionUnoItems;
    private String seccionDosTitulo;
    private String seccionDosDescripcion;
    private String seccionDosSubtitulo;
    private String seccionDosItems;
    private String productImage;


}
