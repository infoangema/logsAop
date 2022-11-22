package angema.base.loginAop.app.partnerThemes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "partner_color")
public class PartnerColor {
    @Id
    private int id;
    private String rgbaPrimary;
    private String rgbaPrimaryDark;
    private String rgbaPrimaryLight;
    private String hexaPrimary;
    private String rgbaSecondary;
    private String rgbaSecondaryDark;
    private String rgbaSecondaryLight;
    private String hexaSecondary;
    private String rgbaTertiary;
    private String rgbaTertiaryDark;
    private String rgbaTertiaryLight;
    private String hexaTertiary;
    private int partnerThemesId;
}
