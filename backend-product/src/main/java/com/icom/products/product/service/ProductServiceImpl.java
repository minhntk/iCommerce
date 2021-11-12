package com.icom.products.product.service;

import com.icom.products.product.dto.request.ProductSearchCriteriaDTO;
import com.icom.products.product.dto.request.SavedProductDTO;
import com.icom.products.product.dto.response.ProductDetailDTO;
import com.icom.products.product.entity.ProductDetailEntity;
import com.icom.products.product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
  @Transactional
  public List<ProductDetailDTO> searchProducts(ProductSearchCriteriaDTO productSearchCriteriaDTO) {
    List<ProductDetailDTO> productDetailDTOS = new ArrayList<>();
    List<ProductDetailEntity> productDetailEntityList = productRepository
        .searchProducts(productSearchCriteriaDTO.getProductIds());
    if (productDetailEntityList != null) {
      productDetailDTOS = productDetailEntityList.stream()
          .map(entity -> conversionService.convert(entity, ProductDetailDTO.class))
          .collect(Collectors.toList());
    }

    return productDetailDTOS;
  }


}
