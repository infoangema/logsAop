package angema.base.loginAop.app.partnerStatics;

import org.apache.commons.io.IOUtils;

import org.springframework.http.MediaType;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/socio")
@RestController
public class PartnerStaticController {
    public static final String cuitCarre = "30687310434";
    // todo getLogoByCuitSocio



    @GetMapping(value="/logo/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/logo-"+cuit_socio+".png");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/carousel/{numero}/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getCarouselImage(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/carousel-1-30687310434.jpg");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value="/bg-image/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getBackGroundImage(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/bg-image-30687310434.jpg");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/font/cuit/{cuit_socio}/primary/type/font_primary.ttf",produces = "application/x-font-ttf")
    @ResponseBody
    public  byte[] getFontByCuit(@PathVariable String cuit_socio) throws IOException {
        InputStream in=null;
        if (cuit_socio.equals(cuitCarre))
            in = PartnerStaticController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/font_primary_"+cuit_socio+".ttf");
        else
            in = PartnerStaticController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/static/RobotoSlab-Regular.ttf");

        return IOUtils.toByteArray(in);


    }

//    @GetMapping(value="/font/cuit/{cuit_socio}/primary/type/{tipo}/font_primary.ttf",produces = "application/x-font-ttf")
//    @ResponseBody
//    public  byte[] getFontByCuitAndType(@PathVariable String cuit_socio,@PathVariable String tipo) throws IOException {
//        InputStream in=null;
//        if (cuit_socio.equals(cuitCarre))
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/font_primary_"+cuit_socio+".ttf");
//        else
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/static/RobotoSlab-Regular.ttf");
//
//        //  return IOUtils.toByteArray(in);
//
//        final HttpHeaders httpHeaders= new HttpHeaders();
//        httpHeaders.setContentType("application/x-font-"+tipo);
//        return new ResponseEntity<String>("{\"test\": \"Hello with ResponseEntity\"}", httpHeaders, HttpStatus.OK);
//    }

    @GetMapping(value="/catalogos/productos/{cuit_socio}")
    @ResponseBody
    public  String getProductos(@PathVariable String cuit_socio) throws IOException {

        return "[\n" +
                "  {\n" +
                "    \"id_producto\": 938,\n" +
                "    \"codigo_producto\": \"CAR082\",\n" +
                "    \"ramo\": 0,\n" +
                "    \"destino_alta\": \"G\",\n" +
                "    \"id_negocio\": 1,\n" +
                "    \"producto_descripcion\": \"Tecnología Protegida\",\n" +
                "    \"planes\": [\n" +
                "      {\n" +
                "        \"codigo_plan\": \"D\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-99\",\n" +
                "            \"precio\": \"891\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"4\",\n" +
                "                \"descipcion_riesgo\": \"Daño de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"58100\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"5\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"58100\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"B\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-99\",\n" +
                "            \"precio\": \"629\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"5\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"41700\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"4\",\n" +
                "                \"descipcion_riesgo\": \"Daño de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"41700\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"C\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-99\",\n" +
                "            \"precio\": \"766\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"4\",\n" +
                "                \"descipcion_riesgo\": \"Daño de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"50300\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"5\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"50300\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"E\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-99\",\n" +
                "            \"precio\": \"1069\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"4\",\n" +
                "                \"descipcion_riesgo\": \"Daño de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"69700\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"5\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Pequeños Electrónicos           \",\n" +
                "                \"suma_asegurada_riesgo\": \"69700\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"valida_titular\": 1,\n" +
                "    \"valida_beneficiario\": 0,\n" +
                "    \"valida_adicional\": 0,\n" +
                "    \"medios_pago\": [\n" +
                "      {\n" +
                "        \"id_medio_pago\": 120,\n" +
                "        \"descripcion_medio_pago\": \"PRISMA MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 6,\n" +
                "        \"descripcion_medio_pago\": \"VISA\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 3,\n" +
                "        \"descripcion_medio_pago\": \"DINERS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 5,\n" +
                "        \"descripcion_medio_pago\": \"MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 75,\n" +
                "        \"descripcion_medio_pago\": \"CARREFOUR ACEPTADOS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 1,\n" +
                "        \"descripcion_medio_pago\": \"AMERICAN EXPRESS\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_producto\": 1107,\n" +
                "    \"codigo_producto\": \"CAR048\",\n" +
                "    \"ramo\": 0,\n" +
                "    \"destino_alta\": \"G\",\n" +
                "    \"id_negocio\": 1,\n" +
                "    \"producto_descripcion\": \"Salud\",\n" +
                "    \"planes\": [\n" +
                "      {\n" +
                "        \"codigo_plan\": \"A\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-44\",\n" +
                "            \"precio\": \"668.64\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"305\",\n" +
                "                \"descipcion_riesgo\": \"Renta Diaria Hosp (Alt A)\",\n" +
                "                \"suma_asegurada_riesgo\": \"619920\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"301\",\n" +
                "                \"descipcion_riesgo\": \"Cancer\",\n" +
                "                \"suma_asegurada_riesgo\": \"326760\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"codigo_etario\": \"4\",\n" +
                "            \"descripcion_rango_etario\": \"55-64\",\n" +
                "            \"precio\": \"1644.72\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"305\",\n" +
                "                \"descipcion_riesgo\": \"Renta Diaria Hosp (Alt A)\",\n" +
                "                \"suma_asegurada_riesgo\": \"619920\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"301\",\n" +
                "                \"descipcion_riesgo\": \"Cancer\",\n" +
                "                \"suma_asegurada_riesgo\": \"326760\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"codigo_etario\": \"3\",\n" +
                "            \"descripcion_rango_etario\": \"45-54\",\n" +
                "            \"precio\": \"1159.2\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"305\",\n" +
                "                \"descipcion_riesgo\": \"Renta Diaria Hosp (Alt A)\",\n" +
                "                \"suma_asegurada_riesgo\": \"619920\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"301\",\n" +
                "                \"descipcion_riesgo\": \"Cancer\",\n" +
                "                \"suma_asegurada_riesgo\": \"326760\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"valida_titular\": 1,\n" +
                "    \"valida_beneficiario\": 0,\n" +
                "    \"valida_adicional\": 0,\n" +
                "    \"medios_pago\": [\n" +
                "      {\n" +
                "        \"id_medio_pago\": 6,\n" +
                "        \"descripcion_medio_pago\": \"VISA\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 120,\n" +
                "        \"descripcion_medio_pago\": \"PRISMA MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 5,\n" +
                "        \"descripcion_medio_pago\": \"MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 118,\n" +
                "        \"descripcion_medio_pago\": \"VISA ELECTRON\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 1,\n" +
                "        \"descripcion_medio_pago\": \"AMERICAN EXPRESS\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_producto\": 937,\n" +
                "    \"codigo_producto\": \"CAR081\",\n" +
                "    \"ramo\": 0,\n" +
                "    \"destino_alta\": \"G\",\n" +
                "    \"id_negocio\": 1,\n" +
                "    \"producto_descripcion\": \"Bolso Protegido\",\n" +
                "    \"planes\": [\n" +
                "      {\n" +
                "        \"codigo_plan\": \"F\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"941\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"246960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"99960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"E\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"755\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"196896\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"80040\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"valida_titular\": 1,\n" +
                "    \"valida_beneficiario\": 1,\n" +
                "    \"valida_adicional\": 0,\n" +
                "    \"medios_pago\": [\n" +
                "      {\n" +
                "        \"id_medio_pago\": 6,\n" +
                "        \"descripcion_medio_pago\": \"VISA\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 3,\n" +
                "        \"descripcion_medio_pago\": \"DINERS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 120,\n" +
                "        \"descripcion_medio_pago\": \"PRISMA MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 21,\n" +
                "        \"descripcion_medio_pago\": \"CREDENCIAL\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 75,\n" +
                "        \"descripcion_medio_pago\": \"CARREFOUR ACEPTADOS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 5,\n" +
                "        \"descripcion_medio_pago\": \"MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 1,\n" +
                "        \"descripcion_medio_pago\": \"AMERICAN EXPRESS\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_producto\": 937,\n" +
                "    \"codigo_producto\": \"CAR081\",\n" +
                "    \"ramo\": 0,\n" +
                "    \"destino_alta\": \"G\",\n" +
                "    \"id_negocio\": 1,\n" +
                "    \"producto_descripcion\": \"Bolso Protegido\",\n" +
                "    \"planes\": [\n" +
                "      {\n" +
                "        \"codigo_plan\": \"F\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"941\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"246960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"99960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"E\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"755\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"196896\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"80040\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"valida_titular\": 1,\n" +
                "    \"valida_beneficiario\": 1,\n" +
                "    \"valida_adicional\": 0,\n" +
                "    \"medios_pago\": [\n" +
                "      {\n" +
                "        \"id_medio_pago\": 6,\n" +
                "        \"descripcion_medio_pago\": \"VISA\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 3,\n" +
                "        \"descripcion_medio_pago\": \"DINERS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 120,\n" +
                "        \"descripcion_medio_pago\": \"PRISMA MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 21,\n" +
                "        \"descripcion_medio_pago\": \"CREDENCIAL\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 75,\n" +
                "        \"descripcion_medio_pago\": \"CARREFOUR ACEPTADOS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 5,\n" +
                "        \"descripcion_medio_pago\": \"MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 1,\n" +
                "        \"descripcion_medio_pago\": \"AMERICAN EXPRESS\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id_producto\": 937,\n" +
                "    \"codigo_producto\": \"CAR081\",\n" +
                "    \"ramo\": 0,\n" +
                "    \"destino_alta\": \"G\",\n" +
                "    \"id_negocio\": 1,\n" +
                "    \"producto_descripcion\": \"Bolso Protegido\",\n" +
                "    \"planes\": [\n" +
                "      {\n" +
                "        \"codigo_plan\": \"F\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"941\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"246960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"99960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"15960\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"39480\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codigo_plan\": \"E\",\n" +
                "        \"id_plan\": \"0\",\n" +
                "        \"rangos\": [\n" +
                "          {\n" +
                "            \"codigo_etario\": \"2\",\n" +
                "            \"descripcion_rango_etario\": \"18-79\",\n" +
                "            \"precio\": \"755\",\n" +
                "            \"riesgos\": [\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"907\",\n" +
                "                \"descipcion_riesgo\": \"Robo de llaves y cerradura\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"981\",\n" +
                "                \"descipcion_riesgo\": \"Robo en cajero automáticos por protección integral.\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"227\",\n" +
                "                \"descipcion_riesgo\": \"Muerte por Accidente Ind\",\n" +
                "                \"suma_asegurada_riesgo\": \"196896\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"905\",\n" +
                "                \"descipcion_riesgo\": \"Robo de los documentos\",\n" +
                "                \"suma_asegurada_riesgo\": \"12840\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"980\",\n" +
                "                \"descipcion_riesgo\": \"Cargo Fraudulento\",\n" +
                "                \"suma_asegurada_riesgo\": \"31680\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"codigo_riesgo\": \"904\",\n" +
                "                \"descipcion_riesgo\": \"Robo de Cartera, Mochila, Riñonera, Billetera y su\",\n" +
                "                \"suma_asegurada_riesgo\": \"80040\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"valida_titular\": 1,\n" +
                "    \"valida_beneficiario\": 1,\n" +
                "    \"valida_adicional\": 0,\n" +
                "    \"medios_pago\": [\n" +
                "      {\n" +
                "        \"id_medio_pago\": 6,\n" +
                "        \"descripcion_medio_pago\": \"VISA\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 3,\n" +
                "        \"descripcion_medio_pago\": \"DINERS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 120,\n" +
                "        \"descripcion_medio_pago\": \"PRISMA MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 21,\n" +
                "        \"descripcion_medio_pago\": \"CREDENCIAL\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 75,\n" +
                "        \"descripcion_medio_pago\": \"CARREFOUR ACEPTADOS\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 5,\n" +
                "        \"descripcion_medio_pago\": \"MASTERCARD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id_medio_pago\": 1,\n" +
                "        \"descripcion_medio_pago\": \"AMERICAN EXPRESS\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
    }
    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio

}
