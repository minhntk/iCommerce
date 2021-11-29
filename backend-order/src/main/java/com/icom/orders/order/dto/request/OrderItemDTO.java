package com.icom.orders.order.dto.request;

import lombok.Data;

@Data
public class OrderItemDTO {

  public String productId;
  public int quantity;
}
