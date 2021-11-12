package com.icom.core.datasource;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

public interface DataSourceFactory<T extends DataSource> {
  T getDataSource(String datasourceType, DataSourceProperties properties);
}
