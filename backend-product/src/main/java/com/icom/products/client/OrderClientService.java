package com.icom.products.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="icom-order-service")
public interface OrderClientService {
}
