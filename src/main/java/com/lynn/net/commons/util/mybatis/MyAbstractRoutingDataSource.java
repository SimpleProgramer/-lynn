package com.lynn.net.commons.util.mybatis;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.lynn.net.commons.constants.Constants;
import com.lynn.net.commons.util.MD5Util;

public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
	 private final int dataSourceNumber;
	    private AtomicInteger count = new AtomicInteger(0);

	    public MyAbstractRoutingDataSource(int dataSourceNumber) {
	        this.dataSourceNumber = dataSourceNumber;
	    }

	    @Override
	    protected Object determineCurrentLookupKey() {
	        String typeKey = DataSourceContextHolder.getJdbcType();
	        if (typeKey.equals(DataSourceType.write.getType()))
	            return DataSourceType.write.getType();
	        // 读 简单轮循调用
	        int number = count.getAndAdd(1);
	        int lookupKey = number % dataSourceNumber;
	        return new Integer(lookupKey);
	    }
	    
	    public static void main(String[] args) {
			System.out.println(MD5Util.getMD5(Constants.PWD_PREX+"123456"));
		}

}
