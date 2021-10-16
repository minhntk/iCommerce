package com.minhntk.product.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("i_product")
public class ProductEntity {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;
  private String name;
  private String categoryId;
  @CreatedDate
  private Instant created;

}
