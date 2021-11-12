package com.icom.products.product.repository;

import com.icom.products.product.entity.ProductDetailEntity;
import com.icom.products.product.entity.ProductEntity;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {

  @Query("SELECT ip.name, ic.name as category_name, ipp.price, ipd.color " +
      "from i_product as ip " +
      "left join i_product_description as ipd on ip.id = ipd.product_id " +
      "left join i_product_price as ipp on ip.id = ipp.product_id " +
      "left join i_category as ic on ic.id = ip.category_id "
  )
  List<ProductDetailEntity> searchProducts(@Param("productIds") List<String> productIds);
}
