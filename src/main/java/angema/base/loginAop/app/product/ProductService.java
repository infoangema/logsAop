package angema.base.loginAop.app.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;
    public List<Product> getDetailProductByPartner(String cuit_socio, String id_producto) throws Exception {
        List<Product>detalleProducto=null;
        detalleProducto= productDao.getDetailProductByPartner(cuit_socio,id_producto);
        return detalleProducto;
    }

    public List<Product> getDetailProductByPartnerSection1(String cuit_socio, String id_producto) throws Exception {
        List<Product>detalleProducto=null;
        detalleProducto= productDao.getDetailProductByPartner(cuit_socio,id_producto);
        return detalleProducto;
    }
}


