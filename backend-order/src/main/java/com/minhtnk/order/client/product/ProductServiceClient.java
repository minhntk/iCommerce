package com.minhtnk.order.client.product;

import com.minhtnk.order.client.product.dto.ProductSearchDTO;
import com.minhtnk.order.dto.response.ProductDetailDTO;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductServiceClient {

  @PostMapping(path = "/v1/products/search")
  List<ProductDetailDTO> searchProducts(@RequestBody ProductSearchDTO productSearchDTO);
}
