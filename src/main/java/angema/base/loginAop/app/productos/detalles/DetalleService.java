package angema.base.loginAop.app.productos.detalles;

import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.app.productos.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Detalle getDetalleByCuitSocioAndIdProducto(String cuitSocio, String productoId) {
        try {
            Detalle detalle = detalleRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId).get();
            return detalle;
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public void addDetalles(List<Detalle> detalles) {
        try {
            for (Detalle detalle : detalles) {
                Optional<Detalle> detalleOptional = detalleRepository.findByCuitSocioAndIdProducto(detalle.cuitSocio, detalle.idProducto);
                if (detalleOptional.isPresent()) {
                    throw new ProductoException("Ya existe el detalle para el producto -> " + detalle.idProducto + " y cuit " + detalle.cuitSocio);
                }
            }
            detalleRepository.saveAll(detalles);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public void updateDetalles(List<Detalle> detalles) {
        try {
            for (Detalle detalle : detalles) {
                if (detalle.id == null) {
                    throw new ProductoException("Campo id es obligatorio");
                }
            }
            detalleRepository.saveAll(detalles);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    public Detalle getDetalleFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException {
        Detalle updateDto = new Detalle();
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
                throw new DetalleException(e.getMessage());
            }
        }
        Detalle detalle = detalleRepository.findById(updateDto.getId()).get();
        Class<?> detalleClass = detalle.getClass();
        for (Field field : updateDtoClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(updateDto);
            if (value != null) {
                Field detalleField = detalleClass.getDeclaredField(field.getName());
                detalleField.setAccessible(true);
                detalleField.set(detalle, value);
            }
        }
        return detalle;
    }

    public void deleteDetalle(Integer id) {
        Detalle detalle = detalleRepository.findById(id).get();
        detalleRepository.delete(detalle);
    }
}
