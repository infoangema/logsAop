package angema.base.loginAop.app.partnerThemes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "partner_themes")
public class PartnerTheme {
    @Id
    private Integer id;
    private String cuitSocio;
    private String nombre;
    private String colorPrimary;
    private String colorSecundary;
    private String colorTertiary;
    private String logoUrl;
    private String carouselImage1;
    private String carouselImage2;
    private String carouselImage3;
    private String carouselImage4;
    private String bgImageUrl;
    private boolean popUpShow;
    private String popUpTitle;
    private String popUpBody;
    private String popUpFooter;
    private String popUpImageUrl;


}
