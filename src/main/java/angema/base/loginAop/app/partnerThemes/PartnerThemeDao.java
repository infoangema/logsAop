package angema.base.loginAop.app.partnerThemes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PartnerThemeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PartnerTheme> getThemesByPartner(String cuit_socio) throws Exception{
       List<PartnerTheme> tematica=null;
        tematica= jdbcTemplate.query("SELECT * FROM partner_themes where cuit_socio=?", new Object[] { cuit_socio }, new PartnerThemeExtractor());
        return tematica;
    }

    public String getCuitSocioByPartnerName(String partnerName) throws Exception{
        String cuit_socio="";
        cuit_socio= jdbcTemplate.queryForObject("SELECT cuit_socio FROM partner_themes where nombre=?", new Object[] { partnerName },String.class);
        return cuit_socio;
    }


}
