package com.icom.orders.order.service;

import com.icom.orders.order.entity.OrderItem;
import java.util.List;
import java.util.Set;

public interface OrderItemService {

  void addOrderItems(Set<OrderItem> items);
}
