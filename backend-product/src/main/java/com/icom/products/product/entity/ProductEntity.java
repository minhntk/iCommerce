package com.icom.products.product.entity;

import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("i_product")
@Data
public class ProductEntity {

  @Id
  private String id;
  private String name;
  private Long categoryId;
  @CreatedDate
  private Instant created;

}
