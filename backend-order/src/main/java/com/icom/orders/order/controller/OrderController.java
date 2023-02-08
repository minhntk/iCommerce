package com.icom.orders.order.controller;

import com.icom.orders.order.controller.dto.request.OrderDTO;
import com.icom.orders.order.controller.dto.response.OrderDetailDTO;
import com.icom.orders.order.service.OrderService;
import com.sun.istack.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders/")
@RequiredArgsConstructor
@Log4j2
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  public String addOrder(@RequestBody OrderDTO orderDTO) throws Exception {
    try {
      orderService.addOrder(orderDTO);
    } catch (Exception ex) {
      throw new Exception(ex);
    }
    return "success";
  }

  @GetMapping(path = "{orderId}")
  public OrderDetailDTO getOrder(@PathVariable String orderId) {
    return null;
  }

  @GetMapping(path = "/user/{userId}")
  public List<OrderDTO> getOrders(@PathVariable @NotNull String userId) {
    log.info("Get Orders of user {}", userId);
    return orderService.getListOrderOfUser(userId);
  }
}
