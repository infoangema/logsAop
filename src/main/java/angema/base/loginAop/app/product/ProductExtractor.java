package angema.base.loginAop.app.product;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductExtractor implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product Product = new Product();
        Product.setId(Integer.valueOf(rs.getInt("id")));
        Product.setIdProducto(String.valueOf(rs.getString("id_producto")));
        Product.setCuitSocio(String.valueOf(rs.getString("cuit_socio")));
        Product.setSeccionCeroDescripcion(String.valueOf(rs.getString("seccion_cero_descripcion")));
        Product.setSeccionUnoDescripcionDos(String.valueOf(rs.getString("seccion_uno_descripcion_dos")));
        Product.setSeccionUnoDescripcion(String.valueOf(rs.getString("seccion_uno_descripcion")));
        Product.setSeccionCeroTitulo(String.valueOf(rs.getString("seccion_cero_titulo")));
        Product.setSeccionCeroPrecioBase(String.valueOf(rs.getString("seccion_cero_precio_base")));
        Product.setSeccionUnoItems(String.valueOf(rs.getString("seccion_uno_items")));
        Product.setSeccionDosTitulo(String.valueOf(rs.getString("seccion_dos_titulo")));
        Product.setSeccionDosDescripcion(String.valueOf(rs.getString("seccion_dos_descripcion")));
        Product.setSeccionDosSubtitulo(String.valueOf(rs.getString("seccion_dos_subtitulo")));
        Product.setSeccionDosItems(String.valueOf(rs.getString("seccion_dos_items")));
        Product.setProductImage(String.valueOf(rs.getString("product_image")));
        return Product;


    }
}
