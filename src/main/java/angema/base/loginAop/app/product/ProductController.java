package angema.base.loginAop.app.product;

import angema.base.loginAop.app.partnerThemes.PartnerThemeController;
import angema.base.loginAop.core.utils.FileSystemUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static Logger logger = Logger.getLogger(PartnerThemeController.class.getName());
    @Autowired
    private ProductService productService;

    @Autowired
    private FileSystemUtil fileSystemUtil;

    @GetMapping("/getDetailByProductId/{productId}/{cuitSocio}")
    public List<Product> getDetailProductByPartner(@PathVariable String cuitSocio, @PathVariable String productId) {
        List<Product>detalleProducto=null;
        try{
            detalleProducto= productService.getDetailProductByPartner(cuitSocio,productId);
        }catch(Exception e){
            logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
        }
        return detalleProducto;
    }

    @GetMapping(value="/getImageByProductId/{productId}/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getImageByProductId(@PathVariable String cuitSocio,@PathVariable String productId) throws IOException {
        InputStream in = ProductController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/img_"+productId+".jfif");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/getAllProductsByCuit/{cuitSocio}")
    @ResponseBody
    public String getAllProductsByCuit(@PathVariable String cuitSocio) throws IOException {
        String res = fileSystemUtil.getFile("/static/"+cuitSocio+"/productos/productos.json");
        return res;
    }

    //todo getPdfCoberturaByCuitAndProductId()
    //todo getPdfCondicionesByCuitAndProductId()
}
