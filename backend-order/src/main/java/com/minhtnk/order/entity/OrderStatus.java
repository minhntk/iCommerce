package com.minhtnk.order.entity;

public enum OrderStatus {
  IN_PROGRESS(1),
  SHIPPING(2),
  COMPLETED(3),
  DENY(4);

  public final int value;

  OrderStatus(int value) {
    this.value = value;
  }

  public static OrderStatus fromValue(int statusValue) {
    for (OrderStatus status : OrderStatus.values()) {
      if (status.value == statusValue) {
        return status;
      }
    }
    throw new IllegalArgumentException("No Status with value " + statusValue + " exists");
  }
}
