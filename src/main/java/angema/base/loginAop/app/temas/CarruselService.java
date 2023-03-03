package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.enums.ViewportSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CarruselService {

    @Autowired
    private CarruselRepository carruselRepository;

    public ViewportSize getMatchingViewportSize(String size) {
        if(size == null || size.equals("")) {
            size = "1000";
        }
        int sizeInPixels = Integer.parseInt(size);

        for (ViewportSize viewportSize : ViewportSize.values()) {
            int viewportSizeInPixels = Integer.parseInt(viewportSize.getSize());
            if (sizeInPixels <= viewportSizeInPixels) {
                return viewportSize;
            }
        }
        return ViewportSize.XXS;
    }

    public List<Carrusel> findAllImagesByCuitSocio(String cuitSocio) {
        return carruselRepository.findByCuitSocioAndActiveIsTrueOrderByPrioridad(cuitSocio);
    }

    public void addCarrusel(List<Carrusel> carruselList) {
        try {
            carruselRepository.saveAll(carruselList);
        } catch (Exception e) {
            throw new CarruselException(e.getMessage());
        }
    }

    public List<Carrusel> getCarrusel(String cuitSocio) {
        try {
            List<Carrusel> carruselList = carruselRepository.findByCuitSocioAndActiveIsTrueOrderByPrioridad(cuitSocio);
            return carruselList;
        } catch (Exception e) {
            throw new CarruselException(e.getMessage());
        }
    }

    public void updateCarrusel(List<Carrusel> carruselList) {
        try {
            for(Carrusel carrusel : carruselList) {
                if(carrusel.id == null) {
                    throw new CarruselException("Campo id es obligatorio");
                }
            }
            carruselRepository.saveAll(carruselList);
        } catch (Exception e) {
            throw new CarruselException(e.getMessage());
        }
    }

    public Carrusel getCarruselFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException{
        Carrusel updateDto = new Carrusel();
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
                throw new CarruselException(e.getMessage());
            }
        }
        Carrusel carrusel = carruselRepository.findById(updateDto.getId()).get();
        Class<?> coberturaClass = carrusel.getClass();
        for (Field field : updateDtoClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(updateDto);
            if (value != null) {
                Field coberturaField = coberturaClass.getDeclaredField(field.getName());
                coberturaField.setAccessible(true);
                coberturaField.set(carrusel, value);
            }
        }
        return carrusel;
    }

    public void deleteCarrusel(Integer id) {
        Carrusel carrusel = carruselRepository.findById(id).get();
        carruselRepository.delete(carrusel);
    }
}
