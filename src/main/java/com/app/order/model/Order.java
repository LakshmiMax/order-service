package com.app.order.model;

import jakarta.validation.constraints.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data // Lombok: Automatically generates getters/setters
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String productName;

    @NotNull(message = "Quantity cannot be null")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    @Column(nullable = false)
    private Double price;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status;

    @NotNull(message = "Customer name is required")
    @Column(nullable = false)
    private String customerName;

    @NotNull(message = "Account ID is required")
    @Column(nullable = false)
    private Long accountId;
}
