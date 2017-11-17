package com.lynn.net.commons.resp;

import java.util.List;

import lombok.Data;
/**
 * 返回参数统一工具类
 * */
@Data
public class ApiResult <T> {
	private int code = 200;
	private String message;
	private T data;
	private List<T> list;
}
