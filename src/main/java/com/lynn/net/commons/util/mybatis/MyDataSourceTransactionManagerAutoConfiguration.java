package com.lynn.net.commons.util.mybatis;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Slf4j
public class MyDataSourceTransactionManagerAutoConfiguration extends  DataSourceTransactionManagerAutoConfiguration {
	 @Bean(name = "transactionManager")
	    public DataSourceTransactionManager transactionManagers() {
	        log.info("-------------------- transactionManager init ---------------------");
	        return new DataSourceTransactionManager((DataSource)SpringContextHolder.getBean("routingDataSourceProxy"));
	    }
}
