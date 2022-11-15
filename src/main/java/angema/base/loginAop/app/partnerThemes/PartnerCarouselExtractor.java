package angema.base.loginAop.app.partnerThemes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerCarouselExtractor implements RowMapper<PartnerCarousel> {

    public PartnerCarousel mapRow(ResultSet rs, int rowNum) throws SQLException {

        PartnerCarousel partnerCarousel = new PartnerCarousel();
        partnerCarousel.setId(Integer.valueOf(rs.getInt("id")));
        partnerCarousel.setNombreCarousel(String.valueOf(rs.getString("nombre_carousel")));
        partnerCarousel.setUrl(String.valueOf(rs.getString("url")));
        partnerCarousel.setEstado(Boolean.valueOf(rs.getBoolean("estado")));
        partnerCarousel.setCreatedAt(String.valueOf(rs.getString("created_at")));
        partnerCarousel.setUpdatedAt(String.valueOf(rs.getString("updated_at")));
        partnerCarousel.setPartnerThemesId(Integer.valueOf(rs.getInt("partner_themes_id")));

        return partnerCarousel;

    }
}