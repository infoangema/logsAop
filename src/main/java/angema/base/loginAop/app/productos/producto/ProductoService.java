package angema.base.loginAop.app.productos.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static angema.base.loginAop.core.exceptions.ExceptionService.getErrorMessage;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto buscarProductoPorId_y_CuitSocio(String cuitSocio, String productoId) {
        try {
            Producto prd =  productoRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
            return prd;
        } catch (Exception e) {
            throw new ProductoException("Error al intentar obtner detalles del producto -> " + productoId + ": " + e.getMessage());
        }
    }

    public void addProducto(List<Producto> productoList) {
        try {
            productoRepository.saveAll(productoList);
        } catch (ConstraintViolationException e) {
            throw new ProductoException("Error al intentar guardar producto: " + getErrorMessage(e));
        } catch (DataIntegrityViolationException e) {
            throw new ProductoException("Error al intentar guardar producto: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            throw new ProductoException("Error al intentar guardar producto: " + e.getMessage());
        }
    }

    public List<Producto> getProducto(String cuitSocio) {
        try {
            return productoRepository.findByCuitSocio(cuitSocio);
        } catch (Exception e) {
            throw new ProductoException("Error al intentar obtener producto cuit -> " + cuitSocio + ": " + e.getMessage());
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
        } catch (ConstraintViolationException e) {
            throw new ProductoException("Error al intentar actualizar producto: " + getErrorMessage(e));
        } catch (DataIntegrityViolationException e) {
            throw new ProductoException("Error al intentar actualizar producto: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            if(((TransactionSystemException) e).getOriginalException().getCause() instanceof ConstraintViolationException) {
                RollbackException ex = (RollbackException) e.getCause();
                ConstraintViolationException ex2 = (ConstraintViolationException) ex.getCause();
                throw new ProductoException("Error al intentar actualizar producto: " + getErrorMessage(ex2));
            }
            throw new ProductoException("Error al intentar actualizar producto: " + e.getMessage());
        }
    }

    public Producto getProductoFromUpdateParams(Map<String, Object> fields) {
        try {
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
        } catch (Exception e) {
            throw new ProductoException("Error al intentar modificar producto: " + e.getMessage());
        }
    }

    public void deleteProducto(Integer id) {
        try {
            Producto producto = productoRepository.findById(id).get();
            productoRepository.delete(producto);
        } catch (Exception e) {
            throw new ProductoException("Error al intentar eliminar producto: " + e.getMessage());
        }
    }
}
