package angema.base.loginAop.app.temas.barraNavegacion;

import angema.base.loginAop.app.productos.busquedas.Busqueda;
import angema.base.loginAop.app.temas.Carrusel;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-local.properties")
public class BarraNavegacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createBarraNavegacion() throws Exception {
        List<BarraNavegacion> barraNavegacionList = new ArrayList<>();
        BarraNavegacion barraNavegacion = new BarraNavegacion();
        barraNavegacion.setCuitSocio("30687310434");
        barraNavegacion.setColorPrimarioRgba("rgba(101, 100, 99, 1)");
        barraNavegacion.setColorPrimarioRgbaLight("rgba(101, 100, 99, 0.8)");
        barraNavegacion.setColorSecundarioRgba("rgba(0, 204, 153, 1)");
        barraNavegacion.setColorSecundarioRgbaLight("rgba(0, 204, 153, 0.8)");
        barraNavegacion.setUrlLogo("http://200.114.219.199/service/landing/temas/obtener-logo/cuit/30687310434");
        barraNavegacionList.add(barraNavegacion);
        mockMvc.perform(MockMvcRequestBuilders.post("/temas/barra-navegacion/guardar-barra-navegacion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(barraNavegacionList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void readBarraNavegacion() throws Exception {
        String cuitSocio = "30687310434";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/barra-navegacion/obtener-barra-navegacion/cuit-socio/"+cuitSocio+"/barra-navegacion"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();
    }


    @Test
    void updateBarraNavegacions() throws Exception {
        List<BarraNavegacion> BarraNavegacionList = new ArrayList<>();
        BarraNavegacion barra1 = new BarraNavegacion();
        barra1.setId(12);
        barra1.setCuitSocio("30687310434");
        barra1.setColorPrimarioRgba("rgba(101, 100, 99, 1)");
        barra1.setColorPrimarioRgbaLight("rgba(101, 100, 99, 0.8)");
        barra1.setColorSecundarioRgba("rgba(0, 204, 153, 1)");
        barra1.setColorSecundarioRgbaLight("rgba(0, 204, 153, 1)");
        barra1.setUrlLogo("http://localhost:8080/landing/temas/obtener-logo/cuit-socio/30687310434/logo");

        BarraNavegacionList.add(barra1);

        mockMvc.perform(MockMvcRequestBuilders.put("/temas/barra-navegacion/modificar-barra-navegacion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BarraNavegacionList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateBarraNavegacionByParams()  throws Exception{
        int id = 10;

        String colorPrimarioRgba = "rgba(101, 100, 99, 1)";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/temas/barra-navegacion/modificar-barra-navegacion?id="+id+"&colorPrimarioRgba="+colorPrimarioRgba))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void deleteBarraNavegacion() throws Exception{
        // Set up the expected product ID to delete
        int id = 1;

        // Make a DELETE request to delete the product with the given ID
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/temas/barra-navegacion/eliminar-barra-navegacion/id-barra-navegacion/" + id))
                .andExpect(status().isOk())
                .andReturn();
    }
}
