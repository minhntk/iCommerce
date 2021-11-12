package com.icom.core.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component("hikariDataSourceFactory")
public class HikariDataSourceFactoryImpl implements DataSourceFactory<HikariDataSource>  {

  @Override
  public HikariDataSource getDataSource(String datasourceType, DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
  }

}
