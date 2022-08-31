package mg.esakafo.taas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mg.esakafo.taas.dto.CategoryDto;
import mg.esakafo.taas.model.Category;
import mg.esakafo.taas.repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public Category createDish(CategoryDto categoryDto) {
        Category category = new Category();
        category.setLabel(categoryDto.getLabel());
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateDishDetails(Long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
            () -> new IllegalStateException("Can not find Category by Id")
        );

        if(categoryDto.getLabel() != null && categoryDto.getLabel().length() > 0 && !category.getLabel().equals(categoryDto.getLabel())){
            category.setLabel(categoryDto.getLabel());
        }

        return category;
    }
    
}
