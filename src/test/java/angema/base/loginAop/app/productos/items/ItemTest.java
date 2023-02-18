package angema.base.loginAop.app.productos.items;

import angema.base.loginAop.app.productos.coberturas.Cobertura;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
@TestPropertySource(locations = "classpath:application-local.properties")
class ItemTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getItemsByCuitSocioAndIdProducto() throws Exception {
        String cuitSocio = "30687310434";
        String idProducto = "177";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/items/obtener-items/cuit-socio/"+cuitSocio+"/id-producto/"+idProducto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
    @Test
    public void testCreateItems() throws Exception {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setIdProducto("item1");
        item.setCuitSocio("123456789");
        item.setDescripcion("Asistencias de urgencias, sin costo adicional, de: plomería, cerrajería, cristalería, electricidad y gas.");
        item.setPrioridad(4);
        itemList.add(item);

        mockMvc.perform(MockMvcRequestBuilders.post("/items/guardar-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateItemsTest() throws Exception {
        List<Item> itemList = new ArrayList<>();

        Item item = new Item();
        item.setId(12);
        item.setIdProducto("item1");
        item.setCuitSocio("123456789");
        item.setDescripcion("Asistencias de urgencias, sin costo adicional, de: plomería, cerrajería, cristalería, electricidad y gas.");
        item.setPrioridad(4);
        itemList.add(item);

        mockMvc.perform(MockMvcRequestBuilders.put("/items/modificar-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateItemByParams() throws Exception {
        int id = 6;
        String descripcion = "para prueba";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/items/modificar-item?id=" + id + "&descripcion="+ descripcion))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void deleteItem()throws Exception{
        int idItem = 1;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/items/eliminar-item/id-item/" + idItem))
                .andExpect(status().isOk())
                .andReturn();
    }

}