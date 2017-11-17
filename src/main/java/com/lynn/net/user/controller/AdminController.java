package com.lynn.net.user.controller;

import java.util.Map;

import org.apache.http.annotation.Contract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/login")
	public String toLogin(Map<String, Object> map) {
		map.put("name", "张三");
		return "index";
	}
	
}
