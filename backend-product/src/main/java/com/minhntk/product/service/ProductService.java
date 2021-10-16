package com.minhntk.product.service;

import com.minhntk.product.dto.request.SavedProductDTO;

public interface ProductService {
  void addProduct(SavedProductDTO productDTO);
  void findAllProduct();
}
