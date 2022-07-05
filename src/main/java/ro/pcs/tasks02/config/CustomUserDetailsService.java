package ro.pcs.tasks02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.pcs.tasks02.repositories.UserRepository;
import ro.pcs.tasks02.services.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ro.pcs.tasks02.models.User user = userService.getUserBylogin(userName);
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: "+ userName);
        }
        UserDetails userDetails = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
        return userDetails;
    }
}
