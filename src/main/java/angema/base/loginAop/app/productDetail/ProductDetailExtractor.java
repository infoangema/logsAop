package angema.base.loginAop.app.productDetail;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailExtractor implements RowMapper<ProductDetail> {

    public ProductDetail mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductDetail ProductDetail = new ProductDetail();
        ProductDetail.setId(Integer.valueOf(rs.getInt("id")));
        ProductDetail.setIdProducto(String.valueOf(rs.getString("id_producto")));
        ProductDetail.setCuitSocio(String.valueOf(rs.getString("cuit_socio")));
        ProductDetail.setDescripcion(String.valueOf(rs.getString("descripcion")));
        ProductDetail.setTitulo(String.valueOf(rs.getString("titulo")));
        ProductDetail.setPrecioBase(String.valueOf(rs.getString("precio_base")));
        return ProductDetail;


    }
}