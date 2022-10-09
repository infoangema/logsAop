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
}
