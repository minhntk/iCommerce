package com.icom.orders.order.service;

import com.icom.orders.order.dto.request.OrderDTO;
import com.icom.orders.order.entity.Order;
import com.icom.orders.order.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  //private final ProductServiceClient productServiceClient;

  @Transactional
  public void addOrder(OrderDTO orderDTO) {
    var order = Order.builder()
        .status("NEW")
        .userId(1L)
        .build();

    orderRepository.save(order);
  }

  public void updateOrder() {

  }

  public List<OrderDTO> getListOrderOfUser(Long userId) {
    log.info("Get List Orders");
    var orderEntity = orderRepository.findByUserId(userId);
    var orderDTOList = new ArrayList<OrderDTO>();

    if (orderEntity == null) {
      return null;
    }

    orderEntity.stream().forEach(
        item -> {
          var orderDTO = OrderDTO.builder().build();
          var orderItem = item.getOrderItems();
          log.info(orderItem);
          orderDTOList.add(orderDTO);
        }
    );
    return orderDTOList;
  }

}
