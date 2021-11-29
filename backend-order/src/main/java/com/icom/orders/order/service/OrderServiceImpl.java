package com.icom.orders.order.service;

import com.icom.orders.client.ProductServiceClient;
import com.icom.orders.client.product.dto.ProductSearchDTO;
import com.icom.orders.order.dto.request.OrderDTO;
import com.icom.orders.order.dto.response.OderDetailItemDTO;
import com.icom.orders.order.dto.response.OrderDetailDTO;
import com.icom.orders.order.dto.response.ProductDetailDTO;
import com.icom.orders.order.entity.OrderEntity;
import com.icom.orders.order.entity.OrderItemEntity;
import com.icom.orders.order.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ConversionService conversionService;
  private final ProductServiceClient productServiceClient;

  @Autowired
  public OrderServiceImpl(OrderRepository orderRepository,
                          ConversionService conversionService,
                          ProductServiceClient productServiceClient) {
    this.orderRepository = orderRepository;
    this.conversionService = conversionService;
    this.productServiceClient = productServiceClient;
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
  public OrderDetailDTO getOrder(String orderId) {
    //OrderEntity orderEntity = orderRepository.findByEmail();
    return null;
  }

  @Override
  public List<OrderDetailDTO> getOrdersByEmail(String email) {
    List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
    ProductSearchDTO productSearchDTO = new ProductSearchDTO();
    List<String> productIds = new ArrayList<>();
    productIds.add("1");
    productSearchDTO.setProductIds(productIds);
    List<ProductDetailDTO> productDetailDTOList = productServiceClient.searchProducts(productSearchDTO);

    OderDetailItemDTO orderDetailItemDTO = new OderDetailItemDTO();
    orderDetailItemDTO.setProductDetailDTO(productDetailDTOList.get(0));
    List <OderDetailItemDTO> oderDetailItemDTOList = new ArrayList<>();
    oderDetailItemDTOList.add(orderDetailItemDTO);

    OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
    orderDetailDTO.setOderDetailItemDTOList(oderDetailItemDTOList);

    orderDetailDTOList.add(orderDetailDTO);
    return orderDetailDTOList;
  }

}
