package com.icom.orders.order.service.impl;

import com.icom.orders.order.client.ProductServiceClient;
import com.icom.orders.order.controller.dto.response.ProductDetailDTO;
import com.icom.orders.order.service.ProductService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductServiceClient productServiceClient;

  @Override
  @Retry(name = "get-product-retry")
  public ProductDetailDTO getProduct() {
    log.info("Retry Get Product");
    return productServiceClient.getProduct();
  }

  @Override
  @RateLimiter(name = "product-rate-limit")
  public String testRateLimit() {
    log.info("Rate Limit");
    return "hello World";
  }
}
