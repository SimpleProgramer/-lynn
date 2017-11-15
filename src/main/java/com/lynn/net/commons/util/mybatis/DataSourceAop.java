package com.lynn.net.commons.util.mybatis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {
	
	@Before("execution(* com.lynn.net.*.dao..*.find*(..)) or execution(* com.lynn.net.*.dao..*.get*(..))")
	public void setReadDataSource() {
		DataSourceContextHolder.read();
	}
	
	@Before("execution(* com.lynn.net.*.dao..*.insert*(..)) or execution(* com.lynn.net.*.dao..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
    }
}
