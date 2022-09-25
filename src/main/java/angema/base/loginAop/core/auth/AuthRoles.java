package angema.base.loginAop.core.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "auth_roles")
public class AuthRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    public String name;
    public String description;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    @JsonBackReference
    public Auth auth;

}
