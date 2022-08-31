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
import mg.esakafo.taas.dto.CreateDishDto;
import mg.esakafo.taas.dto.UpdateDishDto;
import mg.esakafo.taas.model.Dish;
import mg.esakafo.taas.service.DishService;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping
    public List<Dish> getAllDishes(){
        return dishService.getAllDishes();
    }

    @GetMapping(path = "{dishId}")
    public Dish getDishById(@PathVariable("dishId") Long dishId){
        return dishService.getDishById(dishId);
    }

    @PostMapping
    public Dish createDish(
        @RequestBody CreateDishDto createDishDto
    ){
        return dishService.createDish(createDishDto);
    }

    @PutMapping(path = "{dishId}")
    public Dish updateDishDetails(
        @PathVariable("dishId") Long dishId,
        @RequestBody UpdateDishDto updateDishDto
    ){
        return dishService.updateDishDetails(dishId, updateDishDto);
    }
}
