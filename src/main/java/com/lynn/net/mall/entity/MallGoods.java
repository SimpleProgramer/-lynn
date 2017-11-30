package com.lynn.net.mall.entity;

import com.lynn.net.mall.entity.base.BMallGoods;


public class MallGoods extends BMallGoods {
    private static final long serialVersionUID = 1L;
    private String dateString;
    
    private String goodsClass;
	public String getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}