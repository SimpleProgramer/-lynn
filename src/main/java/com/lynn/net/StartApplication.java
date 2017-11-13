package com.lynn.net;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude=MybatisAutoConfiguration.class)
public class StartApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(StartApplication.class, args);
    }
}
