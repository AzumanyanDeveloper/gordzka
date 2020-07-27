package am.gordzka.gordzka.repozitory;

import am.gordzka.gordzka.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepozitory extends JpaRepository<Location, Integer> {
    List<Location> findAll();
}
