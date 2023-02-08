package com.icom.orders.order.controller.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class DeliveryDTO {

  private String shipperId;

}
