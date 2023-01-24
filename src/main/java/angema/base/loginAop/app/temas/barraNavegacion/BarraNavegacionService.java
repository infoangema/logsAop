package angema.base.loginAop.app.temas.barraNavegacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class BarraNavegacionService {
    @Autowired
    private BarraNavegacionRepository barraNavegacionRepository;


    public void addBarraNavegacions(BarraNavegacion barraNavegacion) {
        try {
            barraNavegacionRepository.save(barraNavegacion);
        } catch (Exception e) {
            throw new BarraNavegacionException(e.getMessage());
        }
    }

    public BarraNavegacion getBarraNavegacion(String cuitSocio) {
        try {
            BarraNavegacion barraNavegacion = barraNavegacionRepository.findByCuitSocio(cuitSocio);
            return barraNavegacion;
        } catch (Exception e) {
            throw new BarraNavegacionException(e.getMessage());
        }
    }

    public void updateBarraNavegacions(BarraNavegacion barraNavegacion) {
        try {
            barraNavegacionRepository.save(barraNavegacion);
        } catch (Exception e) {
            throw new BarraNavegacionException(e.getMessage());
        }
    }

    public BarraNavegacion updateBarraNAvegacionByParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException {
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
    }

    public void deleteBarraNavegacion(Integer idBarraNavegacion) {
            BarraNavegacion barraNavegacion = barraNavegacionRepository.findById(idBarraNavegacion).get();
            barraNavegacionRepository.delete(barraNavegacion);
    }
}
