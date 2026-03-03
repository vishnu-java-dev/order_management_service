package com.vishnu.ordermanagement.serivce.impl;

import com.vishnu.ordermanagement.dto.OrderRequestDTO;
import com.vishnu.ordermanagement.dto.OrderResponseDTO;
import com.vishnu.ordermanagement.entity.Order;
import com.vishnu.ordermanagement.exception.ResourceNotFoundException;
import com.vishnu.ordermanagement.repository.OrderRepository;
import com.vishnu.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setAmount(request.getAmount());
        order.setStatus("CREATED");
        order.setCreatedAt(LocalDateTime.now());

        Order saved = orderRepository.save(order);

        return mapToDTO(saved);
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found with Id: " + id));
        return mapToDTO(order);
    }

    @Override
    public Page<OrderResponseDTO> getAllOrders(int page, int size) {
        Pageable pagable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        return orderRepository.findAll(pagable).map(this::mapToDTO);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        orderRepository.delete(order);
    }

    private OrderResponseDTO mapToDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .customername(order.getCustomerName())
                .amount(order.getAmount())
                .status(order.getStatus())
                .createAt(order.getCreatedAt())
                .build();

    }
}