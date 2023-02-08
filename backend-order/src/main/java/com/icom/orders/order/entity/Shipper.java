package com.icom.orders.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "shipper")
public class Shipper extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name="full_name")
  private String fullName;

  @Column(name="phone_number")
  private String phoneNumber;

  @Column(name="status")
  private String status;

  @OneToOne(mappedBy = "deliveryBy")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Delivery delivery;
}
