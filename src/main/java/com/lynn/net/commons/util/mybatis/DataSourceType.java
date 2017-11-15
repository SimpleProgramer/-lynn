package com.lynn.net.commons.util.mybatis;

import lombok.Getter;

public enum DataSourceType {
	 read("read", "从库"), write("write", "主库");
    @Getter
    private String type;
    @Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
