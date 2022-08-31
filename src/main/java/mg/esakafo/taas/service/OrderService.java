package mg.esakafo.taas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mg.esakafo.taas.dto.CreateOrderDto;
import mg.esakafo.taas.dto.UpdateOrderDto;
import mg.esakafo.taas.model.Dish;
import mg.esakafo.taas.model.Order;
import mg.esakafo.taas.model.statusOrder.StatusOrder;
import mg.esakafo.taas.repository.DishRepository;
import mg.esakafo.taas.repository.OrderRepository;
import mg.esakafo.taas.service.date.FormatDate;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long ordersId) {
        Order order = orderRepository.findById(ordersId).orElseThrow(
            () -> new IllegalStateException("Can not find Order by Id")
        );
        return order;
    }

    public Order createOrder(CreateOrderDto createOrderDto) {
        Long number = orderRepository.count();
        Dish dish = dishRepository.findById(createOrderDto.getDish()).get();
        Order order = new Order();

        order.setRef(String.format("REF-%03d", (number + 1)));
        order.setQuantity(createOrderDto.getQuantity());
        order.setAddress(createOrderDto.getAddress());
        order.setClientName(createOrderDto.getClientName());
        order.setContact(createOrderDto.getContact());
        order.setCategory(dish.getCategory().getLabel());
        order.setDish(dish);
        order.setStatus(StatusOrder.IN_PROGRESS);
        order.setOrderDate(FormatDate.date());

        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrderDetails(Long ordersId, UpdateOrderDto updateOrderDto) {
        Order order = orderRepository.findById(ordersId).orElseThrow(
            () -> new IllegalStateException("Can not find Order by Id")
        );

        if(updateOrderDto.getClientName() != null && updateOrderDto.getClientName().length() > 0 && !order.getClientName().equals(updateOrderDto.getClientName())){
            order.setClientName(updateOrderDto.getClientName());
        }

        if(updateOrderDto.getContact() != null && updateOrderDto.getContact().length() > 0 && !order.getContact().equals(updateOrderDto.getContact())){
            order.setContact(updateOrderDto.getContact());
        }

        if(updateOrderDto.getAddress() != null && updateOrderDto.getAddress().length() > 0 && !order.getAddress().equals(updateOrderDto.getAddress())){
            order.setAddress(updateOrderDto.getAddress());
        }

        if(updateOrderDto.getQuantity() != null && !order.getQuantity().equals(updateOrderDto.getQuantity())){
            order.setQuantity(updateOrderDto.getQuantity());
        }

        if(updateOrderDto.getDish() != null && !order.getDish().getId().equals(updateOrderDto.getDish())){
            Dish dish = dishRepository.findById(updateOrderDto.getDish()).orElseThrow(
                () -> new IllegalStateException("Can not find Dish by Id")
            );
            order.setDish(dish);
        }

        if(updateOrderDto.getStatus() != null){
            order.setStatus(updateOrderDto.getStatus());
        }

        return order;
    }
}

