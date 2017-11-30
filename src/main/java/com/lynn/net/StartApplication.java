package com.lynn.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource("classpath:spring-mybatis.xml")
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
