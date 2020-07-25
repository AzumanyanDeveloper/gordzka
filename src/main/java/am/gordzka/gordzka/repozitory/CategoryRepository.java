package am.gordzka.gordzka.repozitory;

import am.gordzka.gordzka.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByOrderByCountDesc();
//    findAllByOrderByCount

}
