package com.minhtnk.order.entity;

public enum OrderItemStatus {
  AVAILABLE(1),
  OUT_OF_STOCK(2),
  DENY(3);

  public final int value;

  OrderItemStatus(int value) {
    this.value = value;
  }

  public static OrderItemStatus fromValue(int statusValue) {
    for (OrderItemStatus status : OrderItemStatus.values()) {
      if (status.value == statusValue) {
        return status;
      }
    }
    throw new IllegalArgumentException("No Status with value " + statusValue + " exists");
  }
}
