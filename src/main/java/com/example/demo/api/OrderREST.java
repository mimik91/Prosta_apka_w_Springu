package com.example.demo.api;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderREST {
        private final OrderService orderService;

        public OrderREST(OrderService orderService) {
                this.orderService = orderService;
        }

        @GetMapping("/api/orders")
        List<Order> all() {
                return orderService.readAll();
        }

        @PostMapping("/api/orders")
        Order newEntity(@RequestBody Order newEntity) {
                return orderService.create(newEntity);
        }

        @GetMapping("/api/orders/{id}")
        Order one(@PathVariable Long id) {
                return orderService.read(id);
        }

        @PutMapping("/api/orders/{id}")
        Order replaceEntity(@RequestBody Order newEntity, @PathVariable Long id) {
                return orderService.update(newEntity, id);
        }

        @DeleteMapping("/api/orders/{id}")
        void deleteEntity(@PathVariable Long id) {
                orderService.delete(id);
        }
}
