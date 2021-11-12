package com.minhtnk.order.controller;

import com.minhtnk.order.dto.request.OrderDTO;
import com.minhtnk.order.dto.response.OrderDetailDTO;
import com.minhtnk.order.service.OrderService;
import com.sun.istack.NotNull;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public String addOrder(@RequestBody OrderDTO orderDTO) throws Exception {
    try {
      orderService.addOrder(orderDTO);
    } catch (Exception ex) {
      throw new Exception(ex);
    }
    return "success";
  }

  @GetMapping(path = "/user/{email}")
  public List<OrderDetailDTO> getOrders(@PathVariable @NotNull String email) {
    return orderService.getOrdersByEmail(email);
  }
}
