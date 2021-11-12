package com.minhtnk.order.repository;

import com.minhtnk.order.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderEntity, String> {

}
