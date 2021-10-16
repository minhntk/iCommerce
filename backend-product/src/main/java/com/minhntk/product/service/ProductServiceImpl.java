package com.minhntk.product.service;

import com.minhntk.product.dto.SavedProductDTO;
import com.minhntk.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public void addProduct(SavedProductDTO productDTO) {
  }

  @Override
  public void findAllProduct() {
    productRepository.findAll();
  }


}
