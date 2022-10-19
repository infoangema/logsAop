package angema.base.loginAop.app.productDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetail {
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


}
