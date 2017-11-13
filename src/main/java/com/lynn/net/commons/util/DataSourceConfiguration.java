package com.lynn.net.commons.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {
	@Value("${datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	
	@Bean(name="writeDataSource")
	@Primary
	@ConfigurationProperties(prefix="datasource.write")
	public DataSource writeDataSource() {
		return null;
	}
}
