package angema.base.loginAop.app.productos.productos;

import org.json.JSONObject;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Assertions;

import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
@TestPropertySource(locations = "classpath:application-local.properties")
public class ProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllProductsByCuit() throws Exception {
        String cuitSocio = "30687310434";
        String idProducto = "1077";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-productos-por-cuit/" + cuitSocio + "/productos"))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        //  assertTrue(response.contains(idProducto), "Response should contain product ID: "+ idProducto);
        boolean rta = response.contains(idProducto);
        if (rta) {
            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        } else {
            Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());

        }
    }

    @Test
    public void testGetProductoByIdAndCuitSocio() throws Exception {
        String cuitSocio = "30687310434";
        String productoId = "1077";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-producto/id/" + productoId + "/cuit-socio/" + cuitSocio + "/producto-" + productoId))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void testReadProducto() throws Exception {
        String cuitSocio = "30687310434";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-productos/cuit-socio/" + cuitSocio + "/productos"))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }

    @Test
    void updateProductoByParams() throws Exception {
        int id = 10;
        String cuitSocio = "30687310434";
        String idProducto = "1108";
        String titulo = "salud en mujeres";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/productos/producto/modificar-producto?id=" + id + "&titulo=" + titulo))
                .andExpect(status().isOk())
                .andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("/productos/producto/obtener-producto/id/" + idProducto + "/cuit-socio/" + cuitSocio + "/producto-" + idProducto))
                .andExpect(status().isOk());
        //   .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value(titulo));

        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());


    }





    @Test
    public void createProducto() throws Exception {
        JSONObject usuario = new JSONObject();
        usuario.put("id_producto", "1077");
        usuario.put("cuit_socio", "30687310434");
        usuario.put("descripcion", "Asistencias de urgencias, sin costo adicional, de: plomería, cerrajería, cristalería, electricidad y gas.");
        usuario.put("url_icono", "http://200.114.219.199/service/landing/productos/obtener-imagen/id-producto/1077/cuit/30687310434/numero-imagen/5?tipo=png");
        usuario.put("prioridad", 4);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/productos/producto/guardar-productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuario.toString().getBytes()))
                .andExpect(status().isOk())
                .andReturn();
    }






}








