package com.icom.orders.order.repository;

import com.icom.orders.order.dto.response.OrderDetailDTO;
import com.icom.orders.order.entity.OrderEntity;
import java.util.List;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, String> {

  @Query("SELECT st.name" +
      "FROM order_transaction as ot" +
      "INNER JOIN order_transaction_item as oti on ot.id = oti.id " +
      "INNER JOIN order_transaction_status as ots on ots.id = ot.id " +
      "ORDER BY ot.created desc")
  List<OrderDetailDTO> findByEmail();
}
