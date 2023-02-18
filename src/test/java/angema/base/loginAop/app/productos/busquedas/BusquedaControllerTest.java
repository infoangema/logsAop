package angema.base.loginAop.app.productos.busquedas;

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
class BusquedaControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void readBusquedas()  throws Exception {
        String cuitSocio = "30687310434";
        String idProducto = "1077";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/busquedas/obtener-busquedas-producto/cuit-socio/"+cuitSocio+"/id-producto/"+idProducto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void testcreateBusquedas() throws Exception {
        List<Busqueda> busquedaList = new ArrayList<>();
        Busqueda busqueda = new Busqueda();
        busqueda.setIdProducto("busqueda1");
        busqueda.setCuitSocio("123456789");
        busqueda.setDescripcion("prueba11");
        busquedaList.add(busqueda);

        mockMvc.perform(MockMvcRequestBuilders.post("/productos/busquedas/guardar-busquedas-producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(busquedaList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateBusquedasTest() throws Exception {
        List<Busqueda> busquedaList = new ArrayList<>();
        Busqueda busqueda = new Busqueda();
        busqueda.setId(12);
        busqueda.setIdProducto("busqueda1");
        busqueda.setCuitSocio("123456789");
        busqueda.setDescripcion("prueba11");
        busquedaList.add(busqueda);

        mockMvc.perform(MockMvcRequestBuilders.put("/productos/coberturas/modificar-coberturas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(busquedaList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void updateBusquedasByParams() throws Exception {
        int id = 6;
        String descripcion = "para prueba";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/productos/busquedas/modificar-busqueda?id=" + id + "&descripcion="+ descripcion))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void buscarParametros() throws Exception {
        String descripcion1 = "perdida";
        String descripcion2 = "todo";
        String descripcion3 = "bien";
        String descripcion4 = "proteccion";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/busquedas/buscar-parametros?params="+descripcion1+","+descripcion2+","+descripcion3+","+descripcion4))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }


    @Test
    public void deleteBusqueda()throws Exception{
        int id = 1;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/productos/busquedas/eliminar-busqueda/id-busqueda/" + id))
                .andExpect(status().isOk())
                .andReturn();
    }
}