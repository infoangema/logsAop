package angema.base.loginAop.app.partnerThemes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerColorExtractor implements RowMapper<PartnerColor> {

    public PartnerColor mapRow(ResultSet rs, int rowNum) throws SQLException {

        PartnerColor partnerColor= new PartnerColor();
        partnerColor.setId(Integer.valueOf(rs.getInt("id")));
        partnerColor.setRgbaPrimary(String.valueOf(rs.getString("rgba_primary")));
        partnerColor.setRgbaPrimaryDark(String.valueOf(rs.getString("rgba_primary_dark")));
        partnerColor.setRgbaPrimaryLight(String.valueOf(rs.getString("rgba_primary_light")));
        partnerColor.setHexaPrimary(String.valueOf(rs.getString("hexa_primary")));
        partnerColor.setRgbaSecondary(String.valueOf(rs.getString("rgba_secondary")));
        partnerColor.setRgbaSecondaryDark(String.valueOf(rs.getString("rgba_secondary_dark")));
        partnerColor.setRgbaSecondaryLight(String.valueOf(rs.getString("rgba_secondary_light")));
        partnerColor.setHexaSecondary(String.valueOf(rs.getString("hexa_secondary")));
        partnerColor.setPartnerThemesId(Integer.valueOf(rs.getInt("partner_themes_id")));

        return partnerColor;

    }
}
