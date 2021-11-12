package com.icom.products.product.service;

import com.icom.products.product.dto.request.ProductSearchCriteriaDTO;
import com.icom.products.product.dto.request.SavedProductDTO;
import com.icom.products.product.dto.response.ProductDetailDTO;
import java.util.List;

public interface ProductService {

  void addProduct(SavedProductDTO productDTO);

  void findAllProduct();

  List<ProductDetailDTO> searchProducts(ProductSearchCriteriaDTO productSearchCriteriaDTO);
}
