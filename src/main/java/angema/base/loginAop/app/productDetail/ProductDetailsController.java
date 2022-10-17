package angema.base.loginAop.app.productDetail;

import angema.base.loginAop.app.partnerThemes.PartnerThemeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductDetailsController {
    private static Logger logger = Logger.getLogger(PartnerThemeController.class.getName());
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/details/{cuit_socio}/{id_producto}")
    public List<ProductDetail> getDetailProductByPartner(@PathVariable String cuit_socio,@PathVariable String id_producto) {
        List<ProductDetail>detalleProducto=null;
        try{
            detalleProducto=productDetailService.getDetailProductByPartner(cuit_socio,id_producto);
            //todo completar items seccion uno
            //todo completar items seccion dos
        }catch(Exception e){
            logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
        }
        return detalleProducto;
    }
}

//// product detail
//{
//        "id": "321",
//        "id_producto": "3231",
//        "cuit_socio":  "30687310434",
//        "seccion_cero_titulo": "Salud",
//        "seccion_cero_descripcion": "Seguro de Salud que te brinda servicios de emergencias médicas y protección ante internaciones o enfermedades",
//        "seccion_cero_subtitulo": "Coberturas desde",
//        "seccion_cero_precio_base":  "600",
//
//        "seccion_uno_descripcion": "¡Aprovechá esta oportunidad!",
//        "seccion_uno_descripcion_dos": "Contratá tu cobertura hoy de forma 100% online, fácil y segura.",
//        // product_item
//        "seccion_uno_items": ["Indemnización ante diagnóstico de cáncer", "Servicio de emergencias y urgencias médicas", "Renta diaria en caso de internación por accidente o enfermedad"],
//        "seccion_dos_titulo":  "Un seguro que te brinda tranquilidad y protección",
//        "seccion_dos_descripcion":  "Este seguro te brinda un respaldo económico para afrontar los gastos imprevistos que se puedan originar por el diagnóstico de cáncer o por internaciones prolongadas.",
//        "seccion_dos_sub_titulo":  "¿QUÉ CUBRE ESTE PRODUCTO?"
//        // product_item
//        "seccion_dos_items":  ["Servicio de emergencias, urgencias y consultas médicas a domicilio", "Renta diaria en caso de internación por accidente o enfermedad - : La Compañía abonará al asegurado la suma de cinco mil setecientos cuarenta ($5.740) pesos por cada día de internación en un Establecimiento Asistencial, por un plazo máximo de 90 días.", "Indemnización ante el diagnóstico de cáncer para afrontar aquellos gastos imprevistos"]
//        }
//
//// producto_item
//// select descripcion from producto_item where id_producto= ? and cuit_socio= ? and seccion = "UNO";
//        id, id_producto, cuit_socio, seccion (UNO | DOS), descripcion
