package com.icom.core.datasource;

import static com.icom.core.datasource.DataSourceType.READER;
import static com.icom.core.datasource.DataSourceType.WRITER;
import static java.lang.String.format;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class TransactionRoutingDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    final String dataSourceType =
        TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? READER : WRITER;

    log.info(format("Setting %s data source fo current transaction.", dataSourceType));

    return dataSourceType;
  }
}
