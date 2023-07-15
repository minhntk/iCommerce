package com.icom.orders.order.service.impl;

import com.icom.orders.order.entity.OrderItem;
import com.icom.orders.order.repository.OrderItemRepository;
import com.icom.orders.order.service.OrderItemService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  @Transactional
  public void addOrderItems(Set<OrderItem> items) {
    orderItemRepository.saveAll(items);
  }
}
