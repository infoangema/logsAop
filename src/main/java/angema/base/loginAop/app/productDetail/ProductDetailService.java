package angema.base.loginAop.app.productDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailsDao productDetailsDao;
    public List<ProductDetail> getDetailProductByPartner(String cuit_socio,String id_producto) throws Exception {
        List<ProductDetail>detalleProducto=null;
        detalleProducto=productDetailsDao.getDetailProductByPartner(cuit_socio,id_producto);
        return detalleProducto;
    }

    public List<ProductDetail> getDetailProductByPartnerSection1(String cuit_socio,String id_producto) throws Exception {
        List<ProductDetail>detalleProducto=null;
        detalleProducto=productDetailsDao.getDetailProductByPartner(cuit_socio,id_producto);
        return detalleProducto;
    }
}


