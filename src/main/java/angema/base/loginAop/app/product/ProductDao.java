package angema.base.loginAop.app.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getDetailProductByPartner(String cuit_socio, String id_producto) throws Exception{
        List<Product> detalleProducto=null;
        detalleProducto= jdbcTemplate.query("SELECT * from product_detail where cuit_socio=? AND id_producto=?", new Object[] { cuit_socio,id_producto }, new ProductExtractor());
        return detalleProducto;
    }
}
