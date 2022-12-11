package com.icom.orders.order.dto.request;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

  private String orderBy;
  private String orderEmail;
  private String orderPhone;
  private List<OrderItemDTO> orderItemDTOList;
}
