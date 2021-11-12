package com.minhtnk.order.service;

import com.minhtnk.order.dto.request.OrderDTO;
import com.minhtnk.order.dto.response.OrderDetailDTO;
import com.minhtnk.order.entity.OrderEntity;
import com.minhtnk.order.entity.OrderItemEntity;
import com.minhtnk.order.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ConversionService conversionService;

  @Autowired
  public OrderServiceImpl(OrderRepository orderRepository, ConversionService conversionService) {
    this.orderRepository = orderRepository;
    this.conversionService = conversionService;
  }

  @Override
  public void addOrder(OrderDTO orderDTO) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setOrderEmail(orderDTO.getOrderEmail());
    orderEntity.setOrderPhone(orderDTO.getOrderPhone());
  }

  private OrderEntity convertToOrderEntity(OrderDTO orderDTO) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setOrderEmail(orderDTO.getOrderEmail());
    orderEntity.setOrderPhone(orderDTO.getOrderPhone());
    return orderEntity;
  }

  private OrderItemEntity convertToOrderItemEntity(OrderDetailDTO orderDetailDTO) {
    OrderItemEntity orderItemEntity = new OrderItemEntity();
    return orderItemEntity;
  }


  @Override
  public void updateOrder() {

  }

  @Override
  public List<OrderDetailDTO> getOrdersByEmail(String email) {
    List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
    return orderDetailDTOList;
  }

}
