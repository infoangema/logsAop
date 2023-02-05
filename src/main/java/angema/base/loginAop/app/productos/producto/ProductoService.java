package angema.base.loginAop.app.productos.producto;

import angema.base.loginAop.app.productos.detalles.DetalleRepository;
import angema.base.loginAop.app.temas.carrusel.Carrusel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    public void addProducto(List<Producto> productoList) {
        try {
            productoRepository.saveAll(productoList);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public List<Producto> getProducto(String cuitSocio) {
        try {
            List<Producto> productoList = productoRepository.findByCuitSocio(cuitSocio);
            return productoList;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public void updateProducto(List<Producto> productoList) {
        try {
            for(Producto producto : productoList) {
                if(producto.id == null) {
                    throw new ProductoException("Campo id es obligatorio");
                }
            }
            productoRepository.saveAll(productoList);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public Producto getProductoFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException{
        Producto updateDto = new Producto();
        Class<?> updateDtoClass = updateDto.getClass();
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            try {
                Field field = updateDtoClass.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                if (field.getType().getName().equals("java.lang.Integer")) {
                    field.set(updateDto, Integer.parseInt(entry.getValue().toString().trim()));
                } else {
                    field.set(updateDto, entry.getValue());
                }
            } catch (NoSuchFieldException e) {
                return null;
            } catch (IllegalAccessException e) {
                throw new ProductoException(e.getMessage());
            }
        }
        Producto producto = productoRepository.findById(updateDto.getId()).get();
        Class<?> coberturaClass = producto.getClass();
        for (Field field : updateDtoClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(updateDto);
            if (value != null) {
                Field coberturaField = coberturaClass.getDeclaredField(field.getName());
                coberturaField.setAccessible(true);
                coberturaField.set(producto, value);
            }
        }
        return producto;
    }

    public void deleteProducto(Integer id) {
        Producto producto = productoRepository.findById(id).get();
        productoRepository.delete(producto);
    }
}
