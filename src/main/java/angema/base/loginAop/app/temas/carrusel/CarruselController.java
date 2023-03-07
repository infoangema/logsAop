package angema.base.loginAop.app.temas.carrusel;

import angema.base.loginAop.app.temas.enums.ViewportSize;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
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

import static angema.base.loginAop.app.temas.carrusel.CarruselMsg.*;

@RestController
@RequestMapping("${CARRUSEL_PATH}")
public class CarruselController {

    @Autowired
    private CarruselService carruselService;

    @Autowired
    private GlobalResponseService globalResponseService;

    // todo: Pasar imagenes de carrusel a bdd.
    @Operation(
            summary = CARRUSEL_FIND_IMG_BY_CUIT_SUMMARY,
            description = CARRUSEL_FIND_IMG_BY_CUIT_DESCRIPTION
    )
    @GetMapping(value = "/${CARRUSEL_URI_FIND_IMG_BY_CUIT}/cuit/{cuitSocio}/numero-imagen/{numero}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] findImageByCuit(@PathVariable String cuitSocio, @PathVariable String numero, @RequestParam(required = false) String size) throws IOException {
        ViewportSize viewportSize = carruselService.getMatchingViewportSize(size);
        String sizeInPixels = viewportSize.getSize();
        InputStream in = CarruselController.class.getResourceAsStream("/static/" + cuitSocio + "/images/carrusel/img_" + numero + "_size_" + sizeInPixels + ".jpg");
        assert in != null;
        return IOUtils.toByteArray(in);
    }

    @Operation(
            summary = CARRUSEL_CREATE_SUMMARY,
            description = CARRUSEL_CREATE_DESCRIPTION
    )
    @PostMapping("${CARRUSEL_URI_CREATE}")
    public GlobalResponse create(@RequestBody List<Carrusel> carruselList, WebRequest request) {
        try {
            carruselService.addCarrusel(carruselList);
            return globalResponseService.responseOk(CODE_200_CREATE, request);
        } catch (CarruselException e) {
            throw new CarruselException(CODE_400_CREATE + e.getMessage());
        }
    }

    // todo: Pasar imagenes de carrusel a bdd.
    @Operation(
            summary = CARRUSEL_READ_SUMMARY,
            description = CARRUSEL_READ_DESCRIPTION
    )
    @GetMapping("${CARRUSEL_URI_READ}/cuit-socio/{cuitSocio}/imagenes-carrusel")
    public GlobalResponse read(@PathVariable String cuitSocio, WebRequest request) {
        try {
            List<Carrusel> carrusel = carruselService.getCarrusel(cuitSocio);
            if (carrusel == null || carrusel.size() == 0) {
                return  globalResponseService.responseWithHttpStatus(carrusel, HttpStatus.NO_CONTENT, request);
            }
            return  globalResponseService.responseOk(carrusel, request);
        } catch (CarruselException e) {
            throw new CarruselException("Error al intentar obtener carrusel cuit -> " + cuitSocio + ": " + e.getMessage());
        }
    }

    @Operation(
            summary = "@RequestBody List<Carrusel>, @Return List<Carrusel>\"" + CODE_200_UPDATE + "\"",
            description = "CRUD UPDATE. Actualiza imagen carrusel."
    )
    @PutMapping("/${CARRUSEL_URI_UPDATE}")
    public GlobalResponse update(@RequestBody List<Carrusel> carruselList, WebRequest request) {
        try {
            carruselService.updateCarrusel(carruselList);
            return globalResponseService.responseOk(CODE_200_UPDATE, request);
        } catch (CarruselException e) {
            throw new CarruselException(CODE_400_UPDATE + e.getMessage());
        }
    }
    // todo prueba
    @Operation(
            summary = "@RequestParam Map<String, Object> params, @Return List<Carrusel>\"" + CODE_200_UPDATE + "\"",
            description = "CRUD UPDATE by params. Actualiza imagen carrusel por query param."
    )
    @PatchMapping("/${CARRUSEL_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Carrusel carrusel = carruselService.getCarruselFromUpdateParams(params);
            if (carrusel == null) {
                throw new CarruselException("Uno o mas parametros de los enviados no son validos.");
            }
            List<Carrusel> carruselList = new ArrayList<>();
            carruselList.add(carrusel);
            carruselService.updateCarrusel(carruselList);
            return globalResponseService.responseOk(CODE_200_UPDATE, request);
        } catch (Exception e) {
            throw new CarruselException(CODE_400_UPDATE + e.getMessage());
        }
    }
    @Operation(
            summary = "@PathVariable Integer idCarrusel, @Return String: \"" + CODE_200_DELETE + "\"",
            description = "CRUD DELETE. Borra imagen de carrusel por id."
    )
    @DeleteMapping("/${CARRUSEL_URI_DELETE}/id-carrusel/{idCarrusel}")
    public GlobalResponse delete(@PathVariable Integer idCarrusel, WebRequest request) {
        try {
            carruselService.deleteCarrusel(idCarrusel);
            return globalResponseService.responseOk(CODE_200_DELETE, request);
        } catch (Exception e) {
            throw new CarruselException(CODE_400_DELETE + e.getMessage());
        }
    }

}
