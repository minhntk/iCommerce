package com.icom.orders.order.service;

import com.icom.orders.order.dto.request.OrderDTO;
import com.icom.orders.order.dto.response.OrderDetailDTO;
import java.util.List;

public interface OrderService {

  void addOrder(OrderDTO orderDTO);
  void updateOrder();
  OrderDetailDTO getOrder(String orderId);
  List<OrderDetailDTO> getOrdersByEmail(String email);
}
