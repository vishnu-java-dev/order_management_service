//package com.vishnu.ordermanagement.service;
//
//import com.vishnu.ordermanagement.entity.Order;
//import com.vishnu.ordermanagement.repository.OrderRepository;
//import com.vishnu.ordermanagement.serivce.impl.OrderServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class OrderServiceTest {
//
//    @Mock
//    private OrderRepository orderRepository;
//
//    @InjectMocks
//    private OrderServiceImpl orderServiceImpl;
//
//    @Test
//    void testGetOrderById(){
//
//        Order order = new Order();
//        order.setId(1L);
//        order.setCustomerName("Vishnu");
//
//        when(orderRepository.findById(1L)).thenReturn(order);
//
//        var response = orderServiceImpl.getOrderById(1L);
//        assertEquals("Vishnu",response.getCustomername());
//        verify(orderRepository, times(1)).finnById(1L);
//    }
//}
