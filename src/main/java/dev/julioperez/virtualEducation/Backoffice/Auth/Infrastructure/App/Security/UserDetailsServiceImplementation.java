package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security;

import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImplementation (UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userOptional = userDao.findByUsername(username);
        User user = userOptional
                .orElseThrow(() -> new UsernameNotFoundException(("No user found with username :").concat(username)));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnable(),
                true,
                true,
                true,
                getAuthorities("USER"));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }

}