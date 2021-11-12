package com.icom.products.product.entity;

import lombok.Data;

@Data
public class ProductDetailEntity {

  private String id;
  private String name;
  private String categoryName;
  private Double price;
  private String color;
}
