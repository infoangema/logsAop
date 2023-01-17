package angema.base.loginAop.app.productos.coberturas;

import angema.base.loginAop.app.productos.detalles.DetalleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CoberturaService {

    @Autowired
    CoberturaRepository coberturaRepository;


    public List<Cobertura> getCoberturas(String cuitSocio, String productoId) {
        try {
            List<Cobertura> coberturas = coberturaRepository.findByCuitSocioAndIdProductoOrderByPrioridad(cuitSocio, productoId);
            return coberturas;
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }


    public void addCoberturas(List<Cobertura> coberturas) {
        try {
            coberturaRepository.saveAll(coberturas);
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }

    public void updateCoberturas(List<Cobertura> coberturas) {
        try {
            for(Cobertura cobertura : coberturas) {
                if(cobertura.id == null) {
                    throw new DetalleException("Campo id es obligatorio");
                }
            }
            coberturaRepository.saveAll(coberturas);
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }

    public Cobertura getCoberturaFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException {
        Cobertura updateDto = new Cobertura();
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
                throw new CoberturaException(e.getMessage());
            }
        }
        Cobertura cobertura = coberturaRepository.findById(updateDto.getId()).get();
        Class<?> coberturaClass = cobertura.getClass();
        for (Field field : updateDtoClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(updateDto);
            if (value != null) {
                Field coberturaField = coberturaClass.getDeclaredField(field.getName());
                coberturaField.setAccessible(true);
                coberturaField.set(cobertura, value);
            }
        }
        return cobertura;
    }

    public void deleteCobertura(Integer id) {
        Cobertura cobertura = coberturaRepository.findById(id).get();
        coberturaRepository.delete(cobertura);
    }
}
