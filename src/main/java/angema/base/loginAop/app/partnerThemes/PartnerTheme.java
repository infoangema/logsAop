package angema.base.loginAop.app.partnerThemes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "partner_themes")
public class PartnerTheme {
    @Id
    private int id;
    private String cuitSocio;
    private String nombre;
    private String logoUrl;
    private String bgImageUrl;
    private boolean popUpShow;
    private String popUpTitle;
    private String popUpBody;
    private String popUpFooter;
    private String popUpImageUrl;
@Transient
    private List<PartnerCarousel> carouselList;
    @Transient
    private PartnerColor colors;



}
