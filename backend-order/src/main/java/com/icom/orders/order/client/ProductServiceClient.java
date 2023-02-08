package com.icom.orders.order.client;

import com.icom.orders.order.client.product.dto.ProductSearchDTO;
import com.icom.orders.order.controller.dto.response.ProductDetailDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "product-service-client",
    url = "${feign.client.config.product-service.url}", path = "/v1/products/")
public interface ProductServiceClient {

  @GetMapping
  ProductDetailDTO getProduct();

  @PostMapping(path = "v1/products/search")
  List<ProductDetailDTO> searchProducts(@RequestBody ProductSearchDTO productSearchDTO);
}
