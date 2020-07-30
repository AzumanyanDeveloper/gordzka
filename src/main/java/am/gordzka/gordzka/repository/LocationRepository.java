package am.gordzka.gordzka.repository;

import am.gordzka.gordzka.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<Location> findAll();
}
