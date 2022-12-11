package com.icom.orders.order.client;

import com.icom.orders.order.client.product.dto.ProductSearchDTO;
import com.icom.orders.order.dto.response.ProductDetailDTO;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface ProductServiceClient {

  @GetMapping("v1/products/get")
  ProductDetailDTO getProduct(@PathVariable int productId);

  @PostMapping(path = "v1/products/search")
  List<ProductDetailDTO> searchProducts(@RequestBody ProductSearchDTO productSearchDTO);
}
