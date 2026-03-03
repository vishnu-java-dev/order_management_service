package com.vishnu.ordermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequestDTO {

    @NotBlank(message = "customer name is required")
    private String customerName;

    @NotNull(message = "amount is require")
    @Positive(message = "Amount must be greather than zero")
    private Double amount;
}
