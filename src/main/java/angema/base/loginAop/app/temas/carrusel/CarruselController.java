package angema.base.loginAop.app.temas.carrusel;

import angema.base.loginAop.app.temas.enums.ViewportSize;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/temas/carrusel")
public class CarruselController {

    @Autowired
    private CarruselService carruselService;

    @Autowired
    private GlobalResponseService globalResponseService;

    // todo: Pasar imagenes de carrusel a bdd.
    @GetMapping(value = "/obtener-imagen-carrusel/cuit/{cuitSocio}/numero-imagen/{numero}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getCarouselImageByCuit(@PathVariable String cuitSocio, @PathVariable String numero, @RequestParam(required = false) String size) throws IOException {
        ViewportSize viewportSize = carruselService.getMatchingViewportSize(size);
        String sizeInPixels = viewportSize.getSize();
        InputStream in = CarruselController.class.getResourceAsStream("/static/" + cuitSocio + "/images/carrusel/img_" + numero + "_size_" + sizeInPixels + ".jpg");
        assert in != null;
        return IOUtils.toByteArray(in);
    }

    @PostMapping("/guardar-carrusel")
    public GlobalResponse<?> createCarrusel(@RequestBody List<Carrusel> carruselList, WebRequest request) {
        try {
            carruselService.addCarrusel(carruselList);
            return globalResponseService.responseOk("Carrusel agregado correctamente", request);
        } catch (CarruselException e) {
            throw new CarruselException("Error al intentar guardar carrusel: " + e.getMessage());
        }
    }

    // todo: Pasar imagenes de carrusel a bdd.
    @GetMapping("/obtener-carrusel/cuit-socio/{cuitSocio}/imagenes-carrusel")
    public GlobalResponse<List<Carrusel>> readCarrusel(@PathVariable String cuitSocio, WebRequest request) {
        try {
            List<Carrusel> carrusel = carruselService.getCarrusel(cuitSocio);
            if (carrusel == null || carrusel.size() == 0) {
                return (GlobalResponse<List<Carrusel>>) globalResponseService.responseWithHttpStatus(carrusel, HttpStatus.NO_CONTENT, request);
            }
            return (GlobalResponse<List<Carrusel>>) globalResponseService.responseOk(carrusel, request);
        } catch (CarruselException e) {
            throw new CarruselException("Error al intentar obtener carrusel cuit -> " + cuitSocio + ": " + e.getMessage());
        }
    }


    @PutMapping("/modificar-carrusel")
    public GlobalResponse<?> updateCoberturas(@RequestBody List<Carrusel> carruselList, WebRequest request) {
        try {
            carruselService.updateCarrusel(carruselList);
            return globalResponseService.responseOk("Carrusel modificado correctamente", request);
        } catch (CarruselException e) {
            throw new CarruselException("Error al intentar modificar carrusel: " + e.getMessage());
        }
    }
    // todo prueba
    @PatchMapping("/modificar-carrusel")
    public GlobalResponse<?> updateCarruselByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Carrusel carrusel = carruselService.getCarruselFromUpdateParams(params);
            if (carrusel == null) {
                throw new CarruselException("Uno o mas parametros de los enviados no son validos.");
            }
            List<Carrusel> carruselList = new ArrayList<>();
            carruselList.add(carrusel);
            carruselService.updateCarrusel(carruselList);
            return globalResponseService.responseOk("Carrusel modificado correctamente", request);
        } catch (Exception e) {
            throw new CarruselException("Error al intentar modificar carrusel: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar-carrusel/id-carrusel/{idCarrusel}")
    public GlobalResponse<?> deleteCarrusel(@PathVariable Integer idCarrusel, WebRequest request) {
        try {
            carruselService.deleteCarrusel(idCarrusel);
            return globalResponseService.responseOk("Carrusel eliminado correctamente", request);
        } catch (Exception e) {
            throw new CarruselException("Error al intentar eliminar carrusel: " + e.getMessage());
        }
    }

}
