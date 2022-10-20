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
        ProductDetail.setSeccionCeroDescripcion(String.valueOf(rs.getString("seccion_cero_descripcion")));
        ProductDetail.setSeccionUnoDescripcionDos(String.valueOf(rs.getString("seccion_uno_descripcion_dos")));
        ProductDetail.setSeccionUnoDescripcion(String.valueOf(rs.getString("seccion_uno_descripcion")));
        ProductDetail.setSeccionCeroTitulo(String.valueOf(rs.getString("seccion_cero_titulo")));
        ProductDetail.setSeccionCeroPrecioBase(String.valueOf(rs.getString("seccion_cero_precio_base")));
        ProductDetail.setSeccionUnoItems(String.valueOf(rs.getString("seccion_uno_items")));
        ProductDetail.setSeccionDosTitulo(String.valueOf(rs.getString("seccion_dos_titulo")));
        ProductDetail.setSeccionDosDescripcion(String.valueOf(rs.getString("seccion_dos_descripcion")));
        ProductDetail.setSeccionDosSubtitulo(String.valueOf(rs.getString("seccion_dos_subtitulo")));
        ProductDetail.setSeccionDosItems(String.valueOf(rs.getString("seccion_dos_items")));

        return ProductDetail;


    }
}