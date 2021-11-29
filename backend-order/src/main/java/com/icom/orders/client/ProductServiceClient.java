package com.icom.orders.client;

import com.icom.orders.client.product.dto.ProductSearchDTO;
import com.icom.orders.order.dto.response.ProductDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="icom-product-service")
public interface ProductServiceClient {

  @GetMapping("v1/products/get")
  ProductDetailDTO getProduct(@PathVariable int productId);

  @PostMapping(path = "v1/products/search")
  List<ProductDetailDTO> searchProducts(@RequestBody ProductSearchDTO productSearchDTO);
}
