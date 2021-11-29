package com.icom.orders.order.repository;

import com.icom.orders.order.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderEntity, String> {

}
