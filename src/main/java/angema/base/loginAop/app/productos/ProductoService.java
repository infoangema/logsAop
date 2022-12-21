package angema.base.loginAop.app.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto obtenerDetalleProductoPorCuit(String cuitSocio, String productoId) {
        try {
            return productoRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }
}
