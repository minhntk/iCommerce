package com.icom.products.product.controller;

import com.icom.products.product.dto.request.ProductSearchCriteriaDTO;
import com.icom.products.product.dto.response.ProductDetailDTO;
import com.icom.products.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stores")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/search")
  public @ResponseBody
  List<ProductDetailDTO> searchProduct(
      @RequestBody ProductSearchCriteriaDTO productSearchCriteriaDTO) {
    return productService.searchProducts(productSearchCriteriaDTO);
  }



}
