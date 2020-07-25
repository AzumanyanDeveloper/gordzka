package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.User;
import am.gordzka.gordzka.repozitory.UserRepozitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepozitory userRepozitory;


    public List<User> findAllUsers(){
        return userRepozitory.findAll();

    }

}
