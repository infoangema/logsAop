package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthSpringUserDetailsService implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        AuthEntity user = authRepository.findByUserName(nombreUsuario).get();
        return AuthSpringUserDetail.build(user);
    }
}
