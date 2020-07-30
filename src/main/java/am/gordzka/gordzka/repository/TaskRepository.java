package am.gordzka.gordzka.repository;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {


    List<Task>findAllByType(Type type);
    List<Task> findAll();

    List<Task> findByNameLikeAndLocationId(String name,int id);

   List<Task> findByNameLike(String name);

}
