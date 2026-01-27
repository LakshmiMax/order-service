package com.app.order.dto;

import com.app.order.model.Order;

public class OrderMapper {

    public static OrderResponseDTO toResponseDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setProductName(order.getProductName());
        dto.setQuantity(order.getQuantity());
        dto.setPrice(order.getPrice());
        dto.setStatus(order.getStatus());
        dto.setCustomerName(order.getCustomerName());
        dto.setAccountId(order.getAccountId());
        return dto;
    }
    
    public static Order toOrderEntity(OrderRequestDTO order) {
    	Order orderEntity = new Order();
    	orderEntity.setProductName(order.getProductName());
    	orderEntity.setQuantity(order.getQuantity());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setCustomerName(order.getCustomerName());
        orderEntity.setAccountId(order.getAccountId());
        return orderEntity;
    }
}

