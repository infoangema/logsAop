package angema.base.loginAop.app.productos.detalles;

import angema.base.loginAop.app.productos.coberturas.CoberturaException;
import angema.base.loginAop.app.productos.producto.Producto;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
@TestPropertySource(locations = "classpath:application-local.properties")
class DetalleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void getDetallesByCuitSocioAndIdProducto() throws Exception {
        String cuitSocio = "30687310434";
        String idProducto = "1077";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/detalles/detalle/obtener-detalle/cuit-socio/"+cuitSocio+"/id-producto/"+idProducto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }



    @Test
    public void testAddDetalles() throws Exception {
        List<Detalle> detalleList = new ArrayList<>();
        Detalle detalle1 = new Detalle();
        detalle1.setIdProducto("detalle1");
        detalle1.setTitulo("Tu hogar es lo más importante, ¡protegelo!");
        detalle1.setCuitSocio("123456789");
        detalle1.setDescripcion("Durante 2017, 3 de cada 10 hogares sufrió un siniestro. Este seguro protege con importantes sumas todo el contenido de tu casa para que estés tranquilo ante un siniestro. Tendrás el dinero y el respaldo necesario ante esta situación. Además contarás con asistencias por urgencias muy comunes en un hogar sin costo alguno.");
        detalle1.setSubTitulo("MÁS BENEFICIOS CON TU COBERTURA");
        detalleList.add(detalle1);

        mockMvc.perform(MockMvcRequestBuilders.post("/detalles/detalle/guardar-detalles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(detalleList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateDetallesTest() throws Exception {
        List<Detalle> detalleList = new ArrayList<>();
        Detalle detalle1 = new Detalle();
        detalle1.setId(1077);
        detalle1.setIdProducto("detalle1");
        detalle1.setTitulo("Tu hogar es lo más importante, ¡protegelo!");
        detalle1.setCuitSocio("123456789");
        detalle1.setDescripcion("Durante 2017, 3 de cada 10 hogares sufrió un siniestro. Este seguro protege con importantes sumas todo el contenido de tu casa para que estés tranquilo ante un siniestro. Tendrás el dinero y el respaldo necesario ante esta situación. Además contarás con asistencias por urgencias muy comunes en un hogar sin costo alguno.");
        detalle1.setSubTitulo("MÁS BENEFICIOS CON TU COBERTURA");
        detalleList.add(detalle1);

        mockMvc.perform(MockMvcRequestBuilders.put("/detalles/detalle/modificar-detalles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(detalleList)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void deleteCobertura()throws Exception{
        int idCobertura = 1;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/detalles/detalle/eliminar-detalle/id-cobertura/" + idCobertura))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    void updateCoberturaByParams() throws Exception {
        int id = 6;
        String idProducto = "1077";
        String cuitSocio = "30687310434";
        String descripcion = "para prueba";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/detalles/detalle/modificar-detalle?id=" + id + "&idProducto="+idProducto+ "&cuitSocio="+cuitSocio+ "&descripcion="+ descripcion))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }





}