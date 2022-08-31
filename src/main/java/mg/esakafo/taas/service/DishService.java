package mg.esakafo.taas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mg.esakafo.taas.dto.CreateDishDto;
import mg.esakafo.taas.dto.UpdateDishDto;
import mg.esakafo.taas.model.Category;
import mg.esakafo.taas.model.Dish;
import mg.esakafo.taas.repository.CategoryRepository;
import mg.esakafo.taas.repository.DishRepository;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish getDishById(Long dishId) {
        return dishRepository.findById(dishId).get();
    }

    public Dish createDish(CreateDishDto createDishDto) {
        Category category = categoryRepository.findById(createDishDto.getCategory()).get();
        Dish dish = new Dish();

        dish.setName(createDishDto.getName());
        dish.setPrice(createDishDto.getPrice());
        dish.setCategory(category);
        dish.setOrderNumber(0L);
        dish.setQuantity(createDishDto.getQuantity());

        return dishRepository.save(dish);
    }

    @Transactional
    public Dish updateDishDetails(Long dishId, UpdateDishDto updateDishDto) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(
            () -> new IllegalStateException("Can not find Dish by Id")
        );

        if(updateDishDto.getName() != null && updateDishDto.getName().length() > 0 && !dish.getName().equals(updateDishDto.getName())){
            dish.setName(updateDishDto.getName());
        }

        if(updateDishDto.getPrice() != null && !dish.getPrice().equals(updateDishDto.getPrice())){
            dish.setPrice(updateDishDto.getPrice());
        }

        if(updateDishDto.getOrderNumber() != null && !dish.getOrderNumber().equals(updateDishDto.getOrderNumber())){
            dish.setOrderNumber(updateDishDto.getOrderNumber());
        }

        if(updateDishDto.getQuantity() != null && !dish.getQuantity().equals(updateDishDto.getQuantity())){
            dish.setName(updateDishDto.getName());
        }

        if(updateDishDto.getCategory() != null && !dish.getCategory().getId().equals(updateDishDto.getCategory())){
            Category category = categoryRepository.findById(updateDishDto.getCategory()).orElseThrow(
                () -> new IllegalStateException("Can not find Category by Id")
            );
            dish.setCategory(category);
        }

        return dish;
    }
}
