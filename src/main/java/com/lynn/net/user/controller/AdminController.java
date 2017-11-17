package com.lynn.net.user.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.user.entity.UserParam;
import com.lynn.net.user.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/doLogin")
	public ApiResult<String> toLogin(@RequestBody UserParam userParam) {
		ApiResult<String> resp = new ApiResult<String>();
		resp = adminService.doLogin(userParam);
		return resp;
	}
}
