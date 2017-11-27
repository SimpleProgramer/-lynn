package com.lynn.net.commons.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.user.entity.UserParam;
import com.lynn.net.user.service.AdminService;

@Controller
public class CommonsController {


	@RequestMapping("/")
	public String toLogin() {
		return "index";
	}
	
}
