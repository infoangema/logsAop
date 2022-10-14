package angema.base.loginAop.app.productDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class ProductDetailsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductDetail> getDetailProductByPartner(String cuit_socio,String id_producto) throws Exception{
        List<ProductDetail> detalleProducto=null;
        detalleProducto= jdbcTemplate.query("SELECT * FROM product_detail where cuit_socio=? AND id_producto=?", new Object[] { cuit_socio,id_producto }, new ProductDetailExtractor());
        return detalleProducto;
    }
}
