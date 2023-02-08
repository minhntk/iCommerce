package com.icom.orders.order.controller.dto.request;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class OrderDTO {

  private String orderBy;
  private String orderEmail;
  private String orderPhone;
  private List<OrderItemDTO> orderItems;
}
