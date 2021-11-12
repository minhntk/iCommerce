package com.minhtnk.order.dto.request;

import lombok.Data;

@Data
public class OrderItemDTO {

  public String productId;
  public int quantity;
}
