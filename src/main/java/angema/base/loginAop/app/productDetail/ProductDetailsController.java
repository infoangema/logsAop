package angema.base.loginAop.app.productDetail;

import angema.base.loginAop.app.partnerThemes.PartnerThemeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductDetailsController {
    private static Logger logger = Logger.getLogger(PartnerThemeController.class.getName());
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/details/{cuit_socio}/{id_producto}")
    public List<ProductDetail> getDetailProductByPartner(@PathVariable String cuit_socio,@PathVariable String id_producto) {
        List<ProductDetail>detalleProducto=null;
        try{
            detalleProducto=productDetailService.getDetailProductByPartner(cuit_socio,id_producto);
        }catch(Exception e){
            logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
        }
        return detalleProducto;
    }
}
