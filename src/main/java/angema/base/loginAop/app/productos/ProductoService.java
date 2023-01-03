package angema.base.loginAop.app.productos;

import angema.base.loginAop.app.productos.entities.Detalle;
import angema.base.loginAop.app.productos.repository.CoberturaRepository;
import angema.base.loginAop.app.productos.repository.DetalleRepository;
import angema.base.loginAop.app.productos.repository.ItemDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CoberturaRepository coberturaRepository;
    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private ItemDetalleRepository itemDetalleRepository;

    public Producto buscarProductoPorId_y_CuitSocio(String cuitSocio, String productoId) {
        try {
            Producto prd =  productoRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
            prd.coberturas = coberturaRepository.findByCuitSocioAndIdProductoOrderByPrioridad(cuitSocio, productoId);
            return prd;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public Detalle buscarDetalleProductoPorId_y_CuitSocio(String cuitSocio, String productoId) {
        try {
            Detalle detalle =  detalleRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
            detalle.items = itemDetalleRepository.findByCuitSocioAndIdProductoOrderByPrioridad(cuitSocio, productoId);
            return detalle;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

}
