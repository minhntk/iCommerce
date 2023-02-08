package com.icom.products.product.service.impl;

import com.icom.products.product.dto.request.ProductSearchCriteriaDTO;
import com.icom.products.product.dto.request.SavedProductDTO;
import com.icom.products.product.dto.response.ProductDetailDTO;
import com.icom.products.product.repository.ProductRepository;
import com.icom.products.product.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ConversionService conversionService;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository,
      ConversionService conversionService) {
    this.productRepository = productRepository;
    this.conversionService = conversionService;
  }

  @Override
  public void addProduct(SavedProductDTO productDTO) {
  }

  @Override
  public void findAllProduct() {
    productRepository.findAll();
  }

  @Override
  public List<ProductDetailDTO> searchProducts(ProductSearchCriteriaDTO productSearchCriteriaDTO) {
    return null;
  }


}
