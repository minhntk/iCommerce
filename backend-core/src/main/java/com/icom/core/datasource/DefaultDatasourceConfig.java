package com.icom.core.datasource;

import static java.util.stream.Collectors.joining;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Log4j2
@Configuration
@ConditionalOnClass({DataSource.class})
@EnableTransactionManagement
public class DefaultDatasourceConfig {

  protected DataSourceFactory<HikariDataSource> dataSourceFactory;

  @Autowired
  public DefaultDatasourceConfig(
      @Qualifier("hikariDataSourceFactory") DataSourceFactory<HikariDataSource> dataSourceFactory) {
    this.dataSourceFactory = dataSourceFactory;
  }

  @Bean
  @Primary
  @DependsOn({"dataSource"})
  protected PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  @Primary
  @DependsOn({"writerDataSource", "readerDataSource", "routingDataSource"})
  protected DataSource dataSource() {
    return new LazyConnectionDataSourceProxy(routingDataSource());
  }

  @Bean
  protected DataSource routingDataSource() {
    final Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put(DataSourceType.WRITER, writerDataSource());
    dataSourceMap.put(DataSourceType.READER, readerDataSource());

    TransactionRoutingDataSource routingDataSource = new TransactionRoutingDataSource();
    routingDataSource.setTargetDataSources(dataSourceMap);
    routingDataSource.setDefaultTargetDataSource(writerDataSource());

    log.info(
        "Initialized routing DataSource with following routing keys: {}",
        dataSourceMap.keySet().stream().map(Object::toString).collect(joining(",")));

    return routingDataSource;
  }

  @Bean
  @ConfigurationProperties("spring.datasource.reader")
  protected DataSourceProperties readDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.writer")
  protected DataSourceProperties writeDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(DataSourceType.WRITER)
  @ConfigurationProperties(prefix = "spring.writer-data-source.hikari")
  protected HikariDataSource writerDataSource() {
    return dataSourceFactory.getDataSource(DataSourceType.WRITER, writeDataSourceProperties());
  }

  @Bean(DataSourceType.READER)
  @ConfigurationProperties(prefix = "spring.reader-data-source.hikari")
  protected HikariDataSource readerDataSource() {
    return dataSourceFactory.getDataSource(DataSourceType.READER, readDataSourceProperties());
  }
}
