package com.vishnu.ordermanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponseDTO {

    private long id;
    private String customername;
    private Double amount;
    private String status;
    private LocalDateTime createAt;
}
