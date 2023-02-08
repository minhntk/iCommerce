package com.icom.orders.order.service;


import com.icom.orders.order.controller.dto.response.ProductDetailDTO;

public interface ProductService {

  ProductDetailDTO getProduct();

  String testRateLimit();
}
