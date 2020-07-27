package am.gordzka.gordzka.repozitory;

import am.gordzka.gordzka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepozitory extends JpaRepository<User,Integer> {
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
