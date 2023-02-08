package com.icom.orders.order.service;

import com.icom.orders.order.controller.dto.request.OrderDTO;
import java.util.List;

public interface OrderService {

  String addOrder(OrderDTO orderDTO);
  List<OrderDTO> getListOrderOfUser(String userId);
}
