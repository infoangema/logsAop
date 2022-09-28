package angema.base.loginAop.core.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "auth_roles")
public class AuthEntityRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    public String name;
    public String description;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    @JsonBackReference
    public AuthEntity authEntity;

}
