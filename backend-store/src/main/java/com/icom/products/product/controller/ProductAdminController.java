package com.icom.products.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/")
public class ProductAdminController {

  @PostMapping("/products/")
  public void addProducts() {

  }
}
