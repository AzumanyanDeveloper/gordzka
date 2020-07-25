package am.gordzka.gordzka.repozitory;

import am.gordzka.gordzka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepozitory extends JpaRepository<User,Integer> {
    List<User> findAll();
}
