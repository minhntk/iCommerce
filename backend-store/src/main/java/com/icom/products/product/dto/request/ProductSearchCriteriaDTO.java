package com.icom.products.product.dto.request;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSearchCriteriaDTO {

  List<String> productIds;
}
