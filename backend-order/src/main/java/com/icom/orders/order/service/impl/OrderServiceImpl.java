package com.icom.orders.order.service.impl;

import com.icom.orders.order.controller.dto.request.OrderDTO;
import com.icom.orders.order.controller.dto.request.OrderItemDTO;
import com.icom.orders.order.entity.Order;
import com.icom.orders.order.entity.OrderItem;
import com.icom.orders.order.repository.OrderItemRepository;
import com.icom.orders.order.repository.OrderRepository;
import com.icom.orders.order.service.OrderService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private static final String NEW = "NEW";
  private static final String WAITING = "WAITING";
  //private final ProductServiceClient productServiceClient;
  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;

  @Transactional
  public String addOrder(OrderDTO orderDTO) {
    var order = Order.builder()
        .status(NEW)
        .userId(UUID.randomUUID().toString())
        .build();

    var savedOrder = orderRepository.save(order);
    var orderItems = buildOrderItems(orderDTO, savedOrder);
    orderItemRepository.saveAll(orderItems);
    return "success";
  }

  private Set<OrderItem> buildOrderItems(OrderDTO orderDTO, Order savedOrder) {
    var orderItemsDTO = orderDTO.getOrderItems();
    var orderItems = new HashSet<OrderItem>();
    orderItemsDTO.stream().forEach(item -> {
      var orderItem = OrderItem.builder()
          .quantity(item.getQuantity())
          .storeId(item.getStoreId())
          .productId(item.getProductId())
          .order(savedOrder)
          .status(WAITING)
          .build();
      orderItems.add(orderItem);
    });
    return orderItems;
  }

  public void updateOrder() {

  }

  @Transactional(readOnly = true)
  public List<OrderDTO> getListOrderOfUser(String userId) {
    log.info("Get List Orders");
    var orderEntity = orderRepository.findByUserId(userId);
    var orderDTOList = new ArrayList<OrderDTO>();

    if (orderEntity == null) {
      return null;
    }

    orderEntity.forEach(
        item -> {
          var orderItemsList = new ArrayList<OrderItemDTO>();
          var orderItems = item.getOrderItems();
          orderItems.stream().forEach(orderItem -> {
            var orderItemDTO = OrderItemDTO.builder()
                .quantity(orderItem.getQuantity())
                .storeId(orderItem.getStoreId())
                .build();
            orderItemsList.add(orderItemDTO);
          });

          var orderDTO = OrderDTO.builder()
              .orderBy(item.getUserId())
              .orderItems(orderItemsList)
              .build();
          orderDTOList.add(orderDTO);
        }
    );
    return orderDTOList;
  }

}
