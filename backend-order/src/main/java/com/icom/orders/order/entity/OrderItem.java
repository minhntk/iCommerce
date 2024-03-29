package com.icom.orders.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem  extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="order_id", nullable=false)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Order order;

  @Column(name = "product_id")
  private String productId;

  @Column(name= "quantity")
  private Integer quantity;

  @Column(name="store_id")
  private Long storeId;

  @Column(name="status")
  private String status;

  @OneToOne(mappedBy = "orderItem")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Delivery delivery;
}
