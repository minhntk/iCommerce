package com.icom.orders.order.controller;

import com.icom.orders.order.controller.dto.response.ProductDetailDTO;
import com.icom.orders.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products/")
@RequiredArgsConstructor
public class ProductController {

  final ProductService productService;

  @GetMapping
  public ProductDetailDTO getProduct() {
    return productService.getProduct();
  }

  @GetMapping("/rate-limit")
  public String rateLimit() {
    return productService.testRateLimit();
  }
}
