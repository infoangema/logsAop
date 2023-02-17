package angema.base.loginAop.productos;

import angema.base.loginAop.app.productos.producto.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-unitest.properties")
public class ProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProductsByCuit() throws Exception {
        String cuitSocio = "30687310434";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-productos-por-cuit/" + cuitSocio + "/productos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        // Assert the response as needed
    }

    @Test
    public void testGetProductoByIdAndCuitSocio() throws Exception {
        String cuitSocio = "30687310434";
        String productoId = "1077";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-producto/id/" + productoId + "/cuit-socio/" + cuitSocio + "/producto-" + productoId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        // Assert the response as needed
    }


    @Test
    public void createProductoTest() throws Exception {
        List<Producto> productoList = new ArrayList<>();
        Producto producto1 = new Producto();
        producto1.setIdProducto("producto1");
        producto1.setCuitSocio("30687310434");
        producto1.setTitulo("Producto 1");
        producto1.setSlogan("Slogan 1");
        producto1.setUrlImagen("http://www.imagen1.com");
        producto1.setUrlImagenPrecio("http://www.imagen-precio1.com");
        productoList.add(producto1);

        mockMvc.perform(MockMvcRequestBuilders.post("/productos/producto/guardar-productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productoList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void readProductoTest() throws Exception {
        String cuitSocio = "30687310434";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-productos/cuit-socio/" + cuitSocio + "/productos"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        // Assert the response as needed
    }
}
