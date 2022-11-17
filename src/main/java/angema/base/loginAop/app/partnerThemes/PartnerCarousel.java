package angema.base.loginAop.app.partnerThemes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "partner_carousel")
public class PartnerCarousel {
    @Id
    private int id;
    private String nombre;
    private String url;
    private boolean estado;
    private String createdAt;
    private String updatedAt;
    private int partnerThemesId;
}
