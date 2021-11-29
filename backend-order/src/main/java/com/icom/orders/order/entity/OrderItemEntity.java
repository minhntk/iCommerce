package com.icom.orders.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("i_order_item")
public class OrderItemEntity {

  @Id
  private Long id;
  private String productId;
  private Long storeId;
  private Float quantity;
  private OrderItemStatus status;
}
