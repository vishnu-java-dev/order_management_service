package com.vishnu.ordermanagement.service;

import com.vishnu.ordermanagement.dto.OrderRequestDTO;
import com.vishnu.ordermanagement.dto.OrderResponseDTO;
import org.springframework.data.domain.Page;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO request);

    OrderResponseDTO getOrderById(Long id);

    Page<OrderResponseDTO> getAllOrders(int page, int size);

    void deleteOrder(Long id);
}
