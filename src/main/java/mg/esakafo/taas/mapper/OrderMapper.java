package mg.esakafo.taas.mapper;

import org.springframework.stereotype.Component;

import mg.esakafo.taas.mapper.Rest.RestOrder;
import mg.esakafo.taas.model.Order;

@Component
public class OrderMapper {
    public RestOrder toRest(Order order){
        return RestOrder.builder()
        .id(order.getId())
        .ref(order.getRef())
        .category(order.getCategory())
        .dish(order.getDish().getName())
        .quantity(order.getQuantity())
        .clientName(order.getClientName())
        .contact(order.getContact())
        .address(order.getAddress())
        .orderDate(order.getOrderDate())
        .status(order.getStatus().toString())
        .build();
    }
}