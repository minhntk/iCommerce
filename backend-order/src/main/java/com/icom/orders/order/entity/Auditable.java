package com.icom.orders.order.entity;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class Auditable {

  @Column(name = "created_date", nullable = false, updatable = false)
  @CreatedDate
  protected LocalDateTime createdDate;

  @Column(name = "updated_date")
  @LastModifiedDate
  protected LocalDateTime updated_date;
}