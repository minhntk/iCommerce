package com.icom.products.product.repository;

import com.icom.products.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
