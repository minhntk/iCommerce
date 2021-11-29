package com.icom.orders.order.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("i_order")
public class OrderEntity {

  private OrderStatus status;
  private String orderBy;
  private String orderEmail;
  private String orderPhone;
}
