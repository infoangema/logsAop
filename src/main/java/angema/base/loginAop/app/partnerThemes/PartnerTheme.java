package angema.base.loginAop.app.partnerThemes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PartnerTheme {
    private Integer id;
    private String cuitSocio;
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
