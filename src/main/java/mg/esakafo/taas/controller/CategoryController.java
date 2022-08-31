package mg.esakafo.taas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mg.esakafo.taas.dto.CategoryDto;
import mg.esakafo.taas.model.Category;
import mg.esakafo.taas.service.CategoryService;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping
    public Category createCategory(
        @RequestBody CategoryDto categoryDto
    ){
        return categoryService.createDish(categoryDto);
    }

    @PutMapping(path = "{categoryId}")
    public Category updateCategoryDetails(
        @PathVariable("categoryId") Long categoryId,
        @RequestBody CategoryDto categoryDto
    ){
        return categoryService.updateDishDetails(categoryId, categoryDto);
    }
}
