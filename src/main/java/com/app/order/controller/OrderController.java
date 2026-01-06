package com.app.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.order.model.Order;
import com.app.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
    private OrderService service;

	@PostMapping("/saveAll")
	public List<Order> createMultipleOrders(@RequestBody List<Order> orders) {
        logger.info("createMultipleOrders for customer: ");

	    return service.createMultipleOrders(orders);
	}
    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        logger.info("Request received to fetch order with ID: {}", id);

        return service.getOrderById(id);
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        return service.updateOrder(id, order);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
            return service.deleteOrder(id);
 

    }
}
