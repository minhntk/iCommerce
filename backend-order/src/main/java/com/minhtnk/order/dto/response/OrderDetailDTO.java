package com.minhtnk.order.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class OrderDetailDTO {

  private Long orderId;
  private List<OderDetailItemDTO> oderDetailItemDTOList;
}
