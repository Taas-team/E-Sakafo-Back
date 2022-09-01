package mg.esakafo.taas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mg.esakafo.taas.dto.CreateOrderDto;
import mg.esakafo.taas.dto.UpdateOrderDto;
import mg.esakafo.taas.mapper.OrderMapper;
import mg.esakafo.taas.mapper.Rest.RestOrder;
import mg.esakafo.taas.service.OrderService;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    
    @GetMapping
    public List<RestOrder> getPreOrders(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer pageSize
    ){
        return orderService.getPreOrders(page, pageSize).stream().map(orderMapper::toRest).toList();
    }

    @GetMapping(path = "{ordersId}")
    public RestOrder getOrderById(@PathVariable("ordersId") Long ordersId){
        return orderMapper.toRest(orderService.getOrderById(ordersId));
    }

    @PostMapping
    public RestOrder createOrder(
        @RequestBody CreateOrderDto createOrderDto
    ){
        return orderMapper.toRest(orderService.createOrder(createOrderDto));
    }

    @PutMapping(path = "{ordersId}")
    public RestOrder updateOrderDetails(
        @PathVariable("ordersId") Long ordersId,
        @RequestBody UpdateOrderDto updateOrderDto
    ){
        return orderMapper.toRest(orderService.updateOrderDetails(ordersId, updateOrderDto));
    }
}
