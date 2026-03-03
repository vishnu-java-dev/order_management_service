package com.vishnu.ordermanagement.controller;

import com.vishnu.ordermanagement.dto.OrderRequestDTO;
import com.vishnu.ordermanagement.dto.OrderResponseDTO;
import com.vishnu.ordermanagement.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO request){
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public OrderResponseDTO getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping
    public Page<OrderResponseDTO> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return orderService.getAllOrders(page,size);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
