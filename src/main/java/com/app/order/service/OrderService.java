package com.app.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.order.model.Order;
import com.app.order.repository.OrderRepository;

@Service
public class OrderService {
	 @Autowired
	    private OrderRepository repository;

	    // Create Order
	 public List<Order> createMultipleOrders(List<Order> orders) {
		    return repository.saveAll(orders);
		}

	    public List<Order> getAllOrders() {
	        return repository.findAll();
	    }
	    // Read Single Order
	    public Order getOrderById(Long id) {
	        return repository.findById(id).orElse(null);
	    }
	    
	    public Order updateOrder(Long id, Order orderDetails) {
	        Order order = repository.findById(id).orElse(null);
	        if (order != null) {
	            order.setProductName(orderDetails.getProductName());
	            order.setQuantity(orderDetails.getQuantity());
	            order.setPrice(orderDetails.getPrice());
	            order.setStatus(orderDetails.getStatus());
	            return repository.save(order);
	        }
	        return null;
	    }
	    public ResponseEntity<String> deleteOrder(Long id) {
	        repository.deleteById(id);
	        return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Order Deleted Successfully!");
	    }
	    
	   

}

