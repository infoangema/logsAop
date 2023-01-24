package angema.base.loginAop.app.productos.busquedas;

import angema.base.loginAop.app.productos.detalles.DetalleException;
import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BusquedaService {

    @Autowired
    BusquedaRepository busquedaRepository;


    public List<Busqueda> getBusquedas(String cuitSocio, String productoId) {
        try {
            List<Busqueda> busquedas = busquedaRepository.findByCuitSocioAndIdProducto(cuitSocio, productoId);
            return busquedas;
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }


    public void addBusquedas(List<Busqueda> busquedas) {
        try {
            busquedaRepository.saveAll(busquedas);
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }

    public void updateBusquedas(List<Busqueda> busquedas) {
        try {
            for (Busqueda busqueda : busquedas) {
                if (busqueda.id == null) {
                    throw new DetalleException("Campo id es obligatorio");
                }
            }
            busquedaRepository.saveAll(busquedas);
        } catch (Exception e) {
            throw new DetalleException(e.getMessage());
        }
    }

    public Busqueda getBusquedaFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException {
        Busqueda updateDto = new Busqueda();
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
                throw new BusquedaException(e.getMessage());
            }
        }
        Busqueda busqueda = busquedaRepository.findById(updateDto.getId()).get();
        Class<?> busquedaClass = busqueda.getClass();
        for (Field field : updateDtoClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(updateDto);
            if (value != null) {
                Field busquedaField = busquedaClass.getDeclaredField(field.getName());
                busquedaField.setAccessible(true);
                busquedaField.set(busqueda, value);
            }
        }
        return busqueda;
    }

    public void deleteBusqueda(Integer id) {
        Optional<Busqueda> busquedaOpt = busquedaRepository.findById(id);
        if (!busquedaOpt.isPresent()) {
            throw new BusquedaException("elemento no encontrado");
        }
        busquedaRepository.delete(busquedaOpt.get());
    }
}
