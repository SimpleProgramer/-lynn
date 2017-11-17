package com.lynn.net.commons.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.user.entity.UserParam;

@Controller
public class CommonsController {

	@RequestMapping("/")
	public String toLogin(Map<String, Object> map) {
		map.put("name", "张三");
		return "index";
	}
	
	@RequestMapping("/doLogin")
	public ApiResult<String> toLogin(@RequestBody UserParam userParam) {
		ApiResult<String> resp = new ApiResult<String>();
		try {
			String userName = userParam.getUserName();
			String password = userParam.getPassword();
			if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
				throw new CustomException("参数校验失败");
			}
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
}
