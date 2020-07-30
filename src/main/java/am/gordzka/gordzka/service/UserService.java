package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public List<User> findAllUsers(){
        return userRepository.findAll();

    }
    public void saveUser(User user){
        userRepository.save(user);
    }

}
