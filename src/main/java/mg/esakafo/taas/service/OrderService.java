package mg.esakafo.taas.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private final Integer defaultPage = 1;
    private final Integer defaultPageSize = 8;

    public Page<Order> getPreOrders(Integer page, Integer pageSize) {

        if(page != null && pageSize != null){
            return orderRepository.findAll(
                PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "orderDate"))
            );
        }
        page  = defaultPage;
        pageSize = defaultPageSize;
        return orderRepository.findAll(
            PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "orderDate"))
        );
    }

    public Order getOrderById(Long ordersId) {
        Order order = orderRepository.findById(ordersId).orElseThrow(
            () -> new IllegalStateException("Can not find Order by Id")
        );
        return order;
    }

    public Order createOrder(CreateOrderDto createOrderDto) {
        Long number = orderRepository.count();
        Dish dish = dishRepository.findByName(createOrderDto.getDish()).get();
        Order order = new Order();

        order.setRef(String.format("REF-%03d", (number + 1)));
        order.setQuantity(createOrderDto.getQuantity());
        order.setAddress(createOrderDto.getAddress());
        order.setClientName(createOrderDto.getClientName());
        order.setContact(createOrderDto.getContact());
        order.setCategory(dish.getCategory().getLabel());

        dish.setQuantity(dish.getQuantity() - 1);
        dish.setOrderNumber(dish.getOrderNumber() + 1);

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
            Dish dish = dishRepository.findByName(updateOrderDto.getDish()).orElseThrow(
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

