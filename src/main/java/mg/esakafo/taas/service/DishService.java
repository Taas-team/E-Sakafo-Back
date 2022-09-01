package mg.esakafo.taas.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private final Integer defaultPage = 1;
    private final Integer defaultPageSize = 8;

    public Page<Dish> getPreDishes(Integer page, Integer pageSize) {
        if(page != null && pageSize != null){
            return dishRepository.findAll(
                PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "orderNumber"))
            );
        }
        page = defaultPage;
        pageSize = defaultPageSize;

        return dishRepository.findAll(
            PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "orderNumber"))
        );
    }

    public Dish getDishById(Long dishId) {
        return dishRepository.findById(dishId).get();
    }

    public Dish createDish(CreateDishDto createDishDto) {
        Category category = categoryRepository.findByLabel(createDishDto.getCategory()).get();
        Dish dish = new Dish();

        dish.setName(createDishDto.getName());
        dish.setPrice(createDishDto.getPrice());
        dish.setCategory(category);
        dish.setOrderNumber(0L);
        dish.setQuantity(createDishDto.getQuantity());
        if(createDishDto.getUrl() != null && createDishDto.getUrl().length() > 0){
            dish.setUrl(createDishDto.getUrl());
        }

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

        if(updateDishDto.getCategory() != null && updateDishDto.getCategory().length() > 0 && !dish.getCategory().getLabel().equals(updateDishDto.getCategory())){
            Category category = categoryRepository.findByLabel(updateDishDto.getCategory()).orElseThrow(
                () -> new IllegalStateException("Can not find Category by Id")
            );
            dish.setCategory(category);
        }

        return dish;
    }
}
