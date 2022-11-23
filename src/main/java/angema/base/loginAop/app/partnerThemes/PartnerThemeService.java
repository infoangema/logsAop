package angema.base.loginAop.app.partnerThemes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerThemeService {
    @Autowired
    private PartnerThemeDao partnerThemeDao;
    public List<PartnerTheme> getThemesByPartner(String cuit_socio) throws Exception {
        List<PartnerTheme>tematica=null;
        tematica=partnerThemeDao.getThemesByPartner(cuit_socio);
        return tematica;
    }

    public String getCuitSocioByPartnerName(String partnerName) throws Exception {
        String cuit_socio="";
        cuit_socio=partnerThemeDao.getCuitSocioByPartnerName(partnerName.toUpperCase());
        return cuit_socio;
    }

    public PartnerTheme getThemeAndColorAndCarouselBycuit(String cuit_socio) throws Exception {
        PartnerTheme tematica=null;

        tematica=partnerThemeDao.getThemeAndColorAndCarouselBycuit(cuit_socio);

        //Lista colores
        List<PartnerColor> colorList = partnerThemeDao.obtenerListaPartnerColor(tematica.getId());
        tematica.setColors(colorList.get(0));

        //Lista carrousel
        List<PartnerCarousel> carouselList = partnerThemeDao.obtenerListaPartnerCarousel(tematica.getId());
        tematica.setCarouselList(carouselList);
        //Object partnerTheme by cuit socio
        return tematica;
    }

//    private List<PartnerColor> getPartnerColor(int id) throws Exception {
//        List<PartnerColor> partnerColorList = partnerThemeDao.obtenerListaPartnerColor(id);
//        return partnerColorList;
//    }
//    private List<PartnerCarousel> getPartnerCarousel(int  id) throws Exception {
//        List<PartnerCarousel> partnerCarouselList = partnerThemeDao.obtenerListaPartnerCarousel(id);
//        return partnerCarouselList;
//    }

}
