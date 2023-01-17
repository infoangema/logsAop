package angema.base.loginAop.app.productos.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItemsByCuitSocioAndIdProducto(String cuitSocio, String productoId) {
        try {
            List<Item> items = itemRepository.findByCuitSocioAndIdProductoOrderByPrioridad(cuitSocio, productoId);
            return items;
        } catch (Exception e) {
            throw new ItemException(e.getMessage());
        }
    }

    public void addItems(List<Item> items) {
        try {
            itemRepository.saveAll(items);
        } catch (Exception e) {
            throw new ItemException(e.getMessage());
        }
    }

    public void updateItems(List<Item> items) {
        try {
            for (Item item : items) {
                if (item.id == null) {
                    throw new ItemException("Campo id es obligatorio");
                }
            }
            itemRepository.saveAll(items);
        } catch (Exception e) {
            throw new ItemException(e.getMessage());
        }
    }

    public Item getItemFromUpdateParams(Map<String, Object> fields) throws IllegalAccessException, NoSuchFieldException {
        Item updateDto = new Item();
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
                throw new ItemException(e.getMessage());
            }
        }
        Item detalle = itemRepository.findById(updateDto.getId()).get();
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

    public void deleteItem(Integer id) {
        Item detalle = itemRepository.findById(id).get();
        itemRepository.delete(detalle);
    }
}
