package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import org.junit.jupiter.api.Assertions;
import angema.base.loginAop.app.productos.producto.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-local.properties")
public class ProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;




    @Test
    void getBackGroundImageByCuit() throws Exception {
        String cuitSocio = "30687310434";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/obtener-logo/cuit-socio/"+cuitSocio+"/logo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
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
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void testDeleteProducto() throws Exception {
        // Set up the expected product ID to delete
        int idProducto = 1;

        // Make a DELETE request to delete the product with the given ID
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/productos/producto/eliminar-producto/id-producto/" + idProducto))
                .andExpect(status().isOk())
                .andReturn();
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
    public void updateCoberturasTest() throws Exception {
        List<Producto> productoList = new ArrayList<>();
        Producto producto1 = new Producto();
        producto1.setId(12);
        producto1.setIdProducto("producto14");
        producto1.setCuitSocio("30687310434");
        producto1.setTitulo("Producto 14");
        producto1.setSlogan("Slogan 1");
        producto1.setUrlImagen("http://www.imagen1.com");
        producto1.setUrlImagenPrecio("http://www.imagen-precio1.com");
        productoList.add(producto1);

        mockMvc.perform(MockMvcRequestBuilders.put("/productos/producto/modificar-productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productoList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



}
