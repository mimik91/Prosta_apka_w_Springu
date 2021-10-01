package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    public Order create(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    public Order read(Long id) {
        return orderRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    public Order update(Order updatedOrder, Long id) {
        return orderRepository.findById(id).
                map(entity -> {
                    entity.setDate(updatedOrder.getDate());
                    return orderRepository.save(entity);
                }).
                orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    public void delete(Long id){
        try {
            orderRepository.deleteById(id);
        } catch (Exception exception) {
            throw new EntityNotFoundException(Order.class, id);
        }
    }
}
