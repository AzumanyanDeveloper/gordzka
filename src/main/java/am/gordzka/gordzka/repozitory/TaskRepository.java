package am.gordzka.gordzka.repozitory;

import am.gordzka.gordzka.model.Task;
import am.gordzka.gordzka.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {


    List<Task>findAllByType(Type type);



}
