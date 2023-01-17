package angema.base.loginAop.app.productos.producto;

import angema.base.loginAop.app.productos.detalles.Detalle;
import angema.base.loginAop.app.productos.coberturas.CoberturaRepository;
import angema.base.loginAop.app.productos.detalles.DetalleRepository;
import angema.base.loginAop.app.productos.items.ItemRepository;
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
    private ItemRepository itemRepository;

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
            Detalle detalle = detalleRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId).get();
            detalle.items = itemRepository.findByCuitSocioAndIdProductoOrderByPrioridad(cuitSocio, productoId);
            return detalle;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

}
