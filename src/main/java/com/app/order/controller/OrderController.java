package com.app.order.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.dto.OrderRequestDTO;
import com.app.order.dto.OrderResponseDTO;
import com.app.order.dto.OrderServiceResponse;
import com.app.order.model.Order;
import com.app.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
    private OrderService orderService;
	@Value("${app.sourceType}")
	private  String sourceType;
	
	@PostMapping("/saveAll")
	public OrderServiceResponse<List<OrderResponseDTO>> createMultipleOrders(@RequestBody List<OrderRequestDTO> orders) {
        logger.info("createMultipleOrders for customer: ");
      List<OrderResponseDTO> responseDTOList = orderService.createMultipleOrders(orders);

       
        OrderServiceResponse<List<OrderResponseDTO>> response =
                new OrderServiceResponse<>(201, "Orders created successfully",
                        responseDTOList);


        return response;
    }

	
	 // GET ALL
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {

        List<OrderResponseDTO> response = orderService.getAllOrders();

        if (response.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(response); // 200
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        logger.info("Request received to fetch order with ID: {}", id);

        return orderService.getOrderById(id);
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
            return orderService.deleteOrder(id);
 

    }
}
