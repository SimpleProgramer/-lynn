package com.lynn.net.commons.util.mybatis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 加载数据库配置,1主2从
 * @author wz
 * */
@Configuration
public class DataSourceConfiguration {
	@Autowired
	private MybatisConfigureValue mcv;
	
	@Bean(name="writeDataSource")
	@Primary
	public DataSource writeDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		
		return DataSourceBuilder.create().type(mcv.getType()).build();
	}
	
	 /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource1")
    @ConfigurationProperties(prefix = "datasource.read1")
    public DataSource readDataSourceOne() {
        return DataSourceBuilder.create().type(mcv.getType()).build();
    }

    @Bean(name = "readDataSource2")
    @ConfigurationProperties(prefix = "datasource.read2")
    public DataSource readDataSourceTwo() {
        return DataSourceBuilder.create().type(mcv.getType()).build();
    }
}
