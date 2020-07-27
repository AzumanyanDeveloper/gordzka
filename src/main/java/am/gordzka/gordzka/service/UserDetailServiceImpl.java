package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.CurrentUser;
import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repozitory.UserRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepozitory userRepozitory;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepozitory.findByEmail(s);
        if (byEmail.isPresent()){
            throw new UsernameNotFoundException("User with" + s + "does not exist");
        }
        return new CurrentUser(byEmail.get());
    }
}
