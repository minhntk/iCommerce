package com.icom.orders.order.repository;

import com.icom.orders.order.entity.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

  List<Order> findByUserId(Long userId);
}
