package angema.base.loginAop.app.productos.coberturas;

import angema.base.loginAop.app.productos.detalles.Detalle;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
@TestPropertySource(locations = "classpath:application-unitest.properties")
class CoberturaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;




    @Test
    void readCoberturas() throws Exception {
        String cuitSocio = "30687310434";
        String idProducto = "1077";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/productos/coberturas/obtener-coberturas/cuit-socio/"+cuitSocio+"/id-producto/"+idProducto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void testCreateCobertura() throws Exception {
        List<Cobertura> coberturaList = new ArrayList<>();
        Cobertura cobertura = new Cobertura();
        cobertura.setIdProducto("cobertura1");
        cobertura.setUrlIcono("http://200.114.219.199/service/landing/productos/obtener-imagen/id-producto/1077/cuit/30687310434/numero-imagen/5?tipo=png");
        cobertura.setCuitSocio("123456789");
        cobertura.setDescripcion("Asistencias de urgencias, sin costo adicional, de: plomería, cerrajería, cristalería, electricidad y gas.");
        cobertura.setPrioridad(4);
        coberturaList.add(cobertura);

        mockMvc.perform(MockMvcRequestBuilders.post("/productos/coberturas/guardar-cobertura")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(coberturaList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void updateCoberturasTest() throws Exception {
        List<Cobertura> coberturaList = new ArrayList<>();
        Cobertura cobertura = new Cobertura();
        cobertura.setId(12);
        cobertura.setIdProducto("cobertura1");
        cobertura.setUrlIcono("http://200.114.219.199/service/landing/productos/obtener-imagen/id-producto/1077/cuit/30687310434/numero-imagen/5?tipo=png");
        cobertura.setCuitSocio("123456789");
        cobertura.setDescripcion("Asistencias de urgencias, sin costo adicional, de: plomería, cerrajería, cristalería, electricidad y gas.");
        cobertura.setPrioridad(4);
        coberturaList.add(cobertura);

        mockMvc.perform(MockMvcRequestBuilders.put("/productos/coberturas/modificar-coberturas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(coberturaList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateCoberturaByParams() throws Exception {
        int id = 6;
        String descripcion = "para prueba";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/detalles/detalle/modificar-detalle?id=" + id + "&descripcion="+ descripcion))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }


    @Test
    public void deleteCobertura()throws Exception{
        int idCobertura = 1;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/productos/coberturas/eliminar-cobertura/id-cobertura/" + idCobertura))
                .andExpect(status().isOk())
                .andReturn();
    }


}
