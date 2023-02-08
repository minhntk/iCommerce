package com.icom.products.product.service.impl;

import com.icom.products.product.repository.ProductRepository;
import com.icom.products.product.service.ProductAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductAdminServiceImpl implements ProductAdminService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductAdminServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional
  public void addProducts() {

  }
}
