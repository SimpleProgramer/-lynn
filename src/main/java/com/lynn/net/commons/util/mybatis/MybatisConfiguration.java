package com.lynn.net.commons.util.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Configuration
@AutoConfigureAfter({ DataSourceConfiguration.class })
@Slf4j
public class MybatisConfiguration extends MybatisAutoConfiguration{
	
	public MybatisConfiguration(
			MybatisProperties properties,
			ObjectProvider<Interceptor[]> interceptorsProvider,
			ResourceLoader resourceLoader,
			ObjectProvider<DatabaseIdProvider> databaseIdProvider,
			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
		super(properties, interceptorsProvider, resourceLoader, databaseIdProvider,
				configurationCustomizersProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactorys() throws Exception {
		return super.sqlSessionFactory(routingDataSourceProxy());
	}
	@Bean
	public AbstractRoutingDataSource routingDataSourceProxy() {
		int size = 2;
		MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        DataSource writeDataSource = (DataSource) SpringContextHolder.getBean("writeDataSource");
        // 写
        targetDataSources.put(DataSourceType.write.getType(), SpringContextHolder.getBean("writeDataSource"));

        for (int i = 0; i < size; i++) {
            targetDataSources.put(i, SpringContextHolder.getBean("readDataSource" + (i + 1)));
        }
        proxy.setDefaultTargetDataSource(writeDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
	}

}
