package com.lynn.net;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.lynn.net.commons.util.mybatis.MybatisConfigureValue;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude=MybatisAutoConfiguration.class)
@EnableConfigurationProperties({MybatisConfigureValue.class})
public class StartApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(StartApplication.class, args);
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
}
