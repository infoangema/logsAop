package angema.base.loginAop.app.temas.carrusel;

import angema.base.loginAop.app.temas.Carrusel;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-local.properties")
class CarruselControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getCarouselImageByCuit()  throws Exception {
        String cuitSocio = "30687310434";
        String numeroImagen="1";
        String tamaño="1000";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/carrusel/obtener-imagen-carrusel/cuit/"+cuitSocio+"/numero-imagen/"+numeroImagen+"?size="+tamaño))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }

    @Test
    void createCarrusel() throws Exception {
            List<Carrusel> carruselList = new ArrayList<>();
            Carrusel carrusel1 = new Carrusel();
            carrusel1.setCuitSocio("30687310434");
            carrusel1.setTipo("Slogan 1");
            carrusel1.setImagen("http://www.imagen1.com");
            carrusel1.setUrl("http://www.imagen-precio1.com");
            carrusel1.setPrioridad(5);
            carruselList.add(carrusel1);
            mockMvc.perform(MockMvcRequestBuilders.post("/temas/carrusel/guardar-carrusel")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(carruselList)))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void readCarrusel() throws Exception {
            String cuitSocio = "30687310434";
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/carrusel/obtener-carrusel/cuit-socio/"+cuitSocio+"/imagenes-carrusel"))
                    .andExpect(status().isOk())
                    .andReturn();
            String response = result.getResponse().getContentAsString();
            Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        }

    @Test
    void updateCoberturas()throws Exception{

        List<Carrusel> carruselList = new ArrayList<>();
        Carrusel carrusel1 = new Carrusel();
        carrusel1.setId(1);
        carrusel1.setCuitSocio("30687310434");
        carrusel1.setTipo("Slogan 1");
        carrusel1.setImagen("http://www.imagen1.com");
        carrusel1.setUrl("http://www.imagen-precio1.com");
        carrusel1.setPrioridad(6);
        carruselList.add(carrusel1);

        mockMvc.perform(MockMvcRequestBuilders.put("/temas/carrusel/modificar-carrusel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carruselList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateCarruselByParams() throws Exception {
        int id = 10;
        int prioridad =15;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/temas/carrusel/modificar-carrusel?id="+id+"&prioridad="+prioridad))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void deleteCarrusel() throws Exception {
            // Set up the expected product ID to delete
            int idCarrusel = 1;

            // Make a DELETE request to delete the product with the given ID
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                            .delete("/temas/carrusel/eliminar-carrusel/id-carrusel/" + idCarrusel))
                    .andExpect(status().isOk())
                    .andReturn();
    }
}