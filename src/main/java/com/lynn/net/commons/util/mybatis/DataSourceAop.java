package com.lynn.net.commons.util.mybatis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {
	
	 public DataSourceAop() {
		 System.out.println("架在我");
	}
	
	@Before("execution(* com..*.*Dao.select*(..))")
	public void setReadDataSource() {
		DataSourceContextHolder.read();
	}
	
	@Before("execution(* com..*.*Dao.insert*(..)) or execution(* com..*.*Dao.update*(..)) or execution(* com..*.*Dao.delete*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
    }
}
