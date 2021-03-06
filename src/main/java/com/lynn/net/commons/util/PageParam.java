package com.lynn.net.commons.util;

import lombok.Data;

@Data
public class PageParam {

	private int pageSize = 10;
	private int pageIndex = 1;
	
	public int getFromNumber() {
		return getPageSize() * (getPageIndex() - 1);
	}
}
