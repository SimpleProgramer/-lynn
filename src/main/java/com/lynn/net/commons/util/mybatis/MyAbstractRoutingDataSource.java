package com.lynn.net.commons.util.mybatis;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

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
	        // 读 简单负载均衡
	        int number = count.getAndAdd(1);
	        int lookupKey = number % dataSourceNumber;
	        return new Integer(lookupKey);
	    }

}
