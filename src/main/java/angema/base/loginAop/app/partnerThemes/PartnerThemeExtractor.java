package angema.base.loginAop.app.partnerThemes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerThemeExtractor  implements RowMapper<PartnerTheme> {

    public PartnerTheme mapRow(ResultSet rs, int rowNum) throws SQLException {

        PartnerTheme partnerTheme = new PartnerTheme();
        partnerTheme.setId(Integer.valueOf(rs.getInt("id")));
        partnerTheme.setNombre(String.valueOf(rs.getString("nombre")));
        partnerTheme.setCuitSocio(String.valueOf(rs.getString("cuit_socio")));
        partnerTheme.setLogoUrl(String.valueOf(rs.getString("logo_url")));
        partnerTheme.setBgImageUrl(String.valueOf(rs.getString("bg_image_url")));
        partnerTheme.setPopUpShow(Boolean.valueOf(rs.getBoolean("pop_up_title")));
        partnerTheme.setPopUpTitle(String.valueOf(rs.getString("pop_up_title")));
        partnerTheme.setPopUpBody(String.valueOf(rs.getString("pop_up_body")));
        partnerTheme.setPopUpFooter(String.valueOf(rs.getString("pop_up_footer")));
        partnerTheme.setPopUpImageUrl(String.valueOf(rs.getString("pop_up_image_url")));

        return partnerTheme;


    }
}

