package angema.base.loginAop.app.partnerThemes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerThemeExtractor  implements RowMapper<PartnerTheme> {

    public PartnerTheme mapRow(ResultSet rs, int rowNum) throws SQLException {

        PartnerTheme partnerTheme = new PartnerTheme();
        partnerTheme.setId(Integer.valueOf(rs.getInt("id")));
        partnerTheme.setCuitSocio(String.valueOf(rs.getString("cuit_socio")));
        partnerTheme.setColorPrimary(String.valueOf(rs.getString("color_primary")));
        partnerTheme.setColorSecundary(String.valueOf(rs.getString("color_secundary")));
        partnerTheme.setColorTertiary(String.valueOf(rs.getString("color_tertiary")));
        partnerTheme.setLogoUrl(String.valueOf(rs.getString("logo_url")));
        partnerTheme.setCarouselImage1(String.valueOf(rs.getString("carousel_image_1")));
        partnerTheme.setCarouselImage2(String.valueOf(rs.getString("carousel_image_2")));
        partnerTheme.setCarouselImage3(String.valueOf(rs.getString("carousel_image_3")));
        partnerTheme.setCarouselImage4(String.valueOf(rs.getString("carousel_image_4")));
        partnerTheme.setBgImageUrl(String.valueOf(rs.getString("bg_image_url")));
        partnerTheme.setPopUpShow(Boolean.valueOf(rs.getBoolean("pop_up_title")));
        partnerTheme.setPopUpTitle(String.valueOf(rs.getString("pop_up_title")));
        partnerTheme.setPopUpBody(String.valueOf(rs.getString("pop_up_body")));
        partnerTheme.setPopUpFooter(String.valueOf(rs.getString("pop_up_footer")));
        partnerTheme.setPopUpImageUrl(String.valueOf(rs.getString("pop_up_image_url")));

        return partnerTheme;


    }
}

