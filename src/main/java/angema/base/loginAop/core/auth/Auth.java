package angema.base.loginAop.core.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;
    public String userName;
    public String name;
    public String lastName;
    public String email;
    public String password;

    @OneToMany(mappedBy = "auth", orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy("name ASC")
    @JsonManagedReference
    public List<AuthRoles> roles = new ArrayList<>();
}
