package com.icom.products.product.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "\"product\"")
public class Product {

  @Id
  private Long id;

  private String name;

  private Long categoryId;

  @CreatedDate
  private Instant created;

}
