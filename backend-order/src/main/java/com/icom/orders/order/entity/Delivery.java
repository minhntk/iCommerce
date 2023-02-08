package com.icom.orders.order.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="delivery_from")
  private String deliveryFrom;

  @Column(name="delivery_to")
  private String deliveryTo;

  @OneToOne(optional = false)
  @MapsId
  @JoinColumn(name = "order_item_id")
  private OrderItem orderItem;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;

  @Column(name="store_id")
  private Long storeId;

  @Column(name="plan_delivery_at")
  private LocalDateTime planDeliveryAt;

  @Column(name="delivery_at")
  private LocalDateTime deliveryAt;

  @OneToOne
  @MapsId
  @JoinColumn(name = "delivery_by")
  private Shipper deliveryBy;
}
