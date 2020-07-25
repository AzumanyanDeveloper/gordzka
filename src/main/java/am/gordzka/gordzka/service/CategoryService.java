package am.gordzka.gordzka.service;

import am.gordzka.gordzka.model.Category;
import am.gordzka.gordzka.repozitory.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;



    public List<Category> getTopCategory(){
        return  categoryRepository.findAllByOrderByCountDesc().subList(0,8);

    }
}
