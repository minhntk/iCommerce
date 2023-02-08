package com.icom.orders.order.controller.dto.response;

import lombok.Data;

@Data
public class ProductDetailDTO {

  private String productName;
  private Float price;
  private String storeName;
}
