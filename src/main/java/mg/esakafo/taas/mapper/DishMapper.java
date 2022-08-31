package mg.esakafo.taas.mapper;

import org.springframework.stereotype.Component;

import mg.esakafo.taas.mapper.Rest.RestDish;
import mg.esakafo.taas.model.Dish;

@Component
public class DishMapper {
    public RestDish toRest(Dish dish){
        return RestDish.builder()
        .id(dish.getId())
        .name(dish.getName())
        .price(dish.getPrice())
        .category(dish.getCategory().getLabel())
        .orderNumber(dish.getOrderNumber())
        .quantity(dish.getQuantity())
        .build();
    }
}