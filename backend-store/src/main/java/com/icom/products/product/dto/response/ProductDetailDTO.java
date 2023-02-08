package com.icom.products.product.dto.response;

import lombok.Data;

@Data
public class ProductDetailDTO {

  private String id;
  private String name;
  private String categoryName;
  private Double price;
  private String color;
}
