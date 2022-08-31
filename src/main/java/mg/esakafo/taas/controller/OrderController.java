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
import mg.esakafo.taas.dto.CreateOrderDto;
import mg.esakafo.taas.dto.UpdateOrderDto;
import mg.esakafo.taas.model.Order;
import mg.esakafo.taas.service.OrderService;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(path = "{ordersId}")
    public Order getOrderById(@PathVariable("ordersId") Long ordersId){
        return orderService.getOrderById(ordersId);
    }

    @PostMapping
    public Order createOrder(
        @RequestBody CreateOrderDto createOrderDto
    ){
        return orderService.createOrder(createOrderDto);
    }

    @PutMapping(path = "{ordersId}")
    public Order updateOrderDetails(
        @PathVariable("ordersId") Long ordersId,
        @RequestBody UpdateOrderDto updateOrderDto
    ){
        return orderService.updateOrderDetails(ordersId, updateOrderDto);
    }
}
