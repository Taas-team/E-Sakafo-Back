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
import mg.esakafo.taas.mapper.DishMapper;
import mg.esakafo.taas.mapper.Rest.RestDish;
import mg.esakafo.taas.service.DishService;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper;

    @GetMapping
    public List<RestDish> getAllDishes(){
        return dishService.getAllDishes().stream().map(dishMapper::toRest).toList();
    }

    @GetMapping(path = "{dishId}")
    public RestDish getDishById(@PathVariable("dishId") Long dishId){
        return dishMapper.toRest(dishService.getDishById(dishId));
    }

    @PostMapping
    public RestDish createDish(
        @RequestBody CreateDishDto createDishDto
    ){
        return dishMapper.toRest(dishService.createDish(createDishDto));
    }

    @PutMapping(path = "{dishId}")
    public RestDish updateDishDetails(
        @PathVariable("dishId") Long dishId,
        @RequestBody UpdateDishDto updateDishDto
    ){
        return dishMapper.toRest(dishService.updateDishDetails(dishId, updateDishDto));
    }
}
