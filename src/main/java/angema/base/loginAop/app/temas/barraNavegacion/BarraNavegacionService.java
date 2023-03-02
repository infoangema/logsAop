package angema.base.loginAop.app.temas.barraNavegacion;

import angema.base.loginAop.core.exceptions.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionErrorMsj.*;
import static angema.base.loginAop.core.utils.ErrorUtils.getErrorMessage;

@Service
public class BarraNavegacionService {
    @Autowired
    private BarraNavegacionRepository barraNavegacionRepository;


    public void addBarraNavegacions(List<BarraNavegacion> barrasNavegacion) {
        try {
            barraNavegacionRepository.saveAll(barrasNavegacion);
        } catch ( ConstraintViolationException e) {
            throw new BarraNavegacionException("Error al intentar guardar la lista de barran de navegacion: " + ExceptionService.getErrorMessage(e));
        } catch ( DataIntegrityViolationException e) {
            throw new BarraNavegacionException("Error al intentar guardar la lista de barran de navegacion: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_CREATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    public BarraNavegacion getBarraNavegacion(String cuitSocio) {
        try {
            BarraNavegacion barraNavegacion = barraNavegacionRepository.findByCuitSocio(cuitSocio);
            return barraNavegacion;
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_CREATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    public void updateBarraNavegacions(BarraNavegacion barraNavegacion) {
        try {
            barraNavegacionRepository.save(barraNavegacion);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    public BarraNavegacion updateBarraNAvegacionByParams(Map<String, Object> fields) {
        try {
            BarraNavegacion updateDto = new BarraNavegacion();
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
                    throw new BarraNavegacionException(e.getMessage());
                }
            }
            BarraNavegacion barraNavegacion = barraNavegacionRepository.findById(updateDto.getId()).get();
            Class<?> barraNavegacionClass = barraNavegacion.getClass();
            for (Field field : updateDtoClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(updateDto);
                if (value != null) {
                    Field barraNavegacionField = barraNavegacionClass.getDeclaredField(field.getName());
                    barraNavegacionField.setAccessible(true);
                    barraNavegacionField.set(barraNavegacion, value);
                }
            }
            return barraNavegacion;
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    public void deleteBarraNavegacion(Integer idBarraNavegacion) {
        try {
            BarraNavegacion barraNavegacion = barraNavegacionRepository.findById(idBarraNavegacion).get();
            barraNavegacionRepository.delete(barraNavegacion);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_DELETE, idBarraNavegacion.toString(), e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    public List<BarraNavegacion> getAllBarraNavegacion() {
        try {
            List<BarraNavegacion> barrasNavegacion = barraNavegacionRepository.findAll();
            return barrasNavegacion;
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_CREATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }
}
