package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.CurrentUser;
import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byEmail = userRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CurrentUser(byEmail);
    }
}
