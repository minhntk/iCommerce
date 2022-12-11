package com.icom.orders.order.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailDTO {

  private Long orderId;
  private List<OderDetailItemDTO> oderDetailItemDTOList;
}
