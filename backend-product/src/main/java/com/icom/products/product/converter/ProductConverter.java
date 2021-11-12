package com.icom.products.product.converter;

import com.icom.products.product.dto.response.ProductDetailDTO;
import com.icom.products.product.entity.ProductDetailEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<ProductDetailEntity, ProductDetailDTO> {

  @Override
  public ProductDetailDTO convert(ProductDetailEntity source) {
    ProductDetailDTO productDetailDTO = new ProductDetailDTO();
    BeanUtils.copyProperties(source, productDetailDTO);
    return productDetailDTO;
  }
}
