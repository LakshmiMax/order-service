package com.app.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.order.dto.OrderMapper;
import com.app.order.dto.OrderRequestDTO;
import com.app.order.dto.OrderResponseDTO;
import com.app.order.model.Order;
import com.app.order.repository.OrderRepository;

@Service
public class OrderService {
	 @Autowired
	    private OrderRepository repository;

	    // Create Order
	 public List<OrderResponseDTO> createMultipleOrders(List<OrderRequestDTO> orderRequestDTOList) {
		 List<Order> orders = orderRequestDTOList.stream()
	                .map(OrderMapper::toOrderEntity)
	                .collect(Collectors.toList());
		 
		    return repository.saveAll(orders).stream()
	                .map(OrderMapper::toResponseDTO)
	                .collect(Collectors.toList());
	 }

	 
	 public List<OrderResponseDTO> getAllOrders() {
	        return repository.findAll()
	                .stream()
	                .map(OrderMapper::toResponseDTO)
	                .collect(Collectors.toList());
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

