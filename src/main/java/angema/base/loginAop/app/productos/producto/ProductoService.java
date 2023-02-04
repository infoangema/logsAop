package angema.base.loginAop.app.productos.producto;

import angema.base.loginAop.app.productos.detalles.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DetalleRepository detalleRepository;

    public Producto buscarProductoPorId_y_CuitSocio(String cuitSocio, String productoId) {
        try {
            Producto prd =  productoRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
            return prd;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

}
