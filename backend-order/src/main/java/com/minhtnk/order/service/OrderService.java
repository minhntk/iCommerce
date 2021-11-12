package com.minhtnk.order.service;

import com.minhtnk.order.dto.request.OrderDTO;
import com.minhtnk.order.dto.response.OrderDetailDTO;
import java.util.List;

public interface OrderService {

  void addOrder(OrderDTO orderDTO);

  void updateOrder();

  List<OrderDetailDTO> getOrdersByEmail(String email);
}
