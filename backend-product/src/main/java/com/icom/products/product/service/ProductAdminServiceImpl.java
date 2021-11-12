package com.icom.products.product.service;

import com.icom.products.product.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
