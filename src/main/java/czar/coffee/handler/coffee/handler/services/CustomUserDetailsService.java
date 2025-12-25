package czar.coffee.handler.coffee.handler.services;

import czar.coffee.handler.coffee.handler.adapters.UserDetailsAdapter;
import czar.coffee.handler.coffee.handler.entities.User;
import czar.coffee.handler.coffee.handler.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = usersRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));

    return  new UserDetailsAdapter(user);
    }

}
