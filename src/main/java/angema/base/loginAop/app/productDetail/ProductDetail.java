package angema.base.loginAop.app.productDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetail {
    private Integer id;
    private String idProducto;
    private String cuitSocio;
    private String titulo;
    private String precioBase;
    private String descripcion;


}
