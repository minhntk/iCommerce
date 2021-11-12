package com.icom.products.product.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class ProductSearchCriteriaDTO {

  List<String> productIds;
}
