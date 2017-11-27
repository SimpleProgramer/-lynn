package com.lynn.net.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.user.entity.UserParam;
import com.lynn.net.user.entity.VipParam;
import com.lynn.net.user.entity.VipUser;
import com.lynn.net.user.service.AdminService;
import com.lynn.net.user.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	private ApiResult<String,Object> resp;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/doLogin")
	@ResponseBody
	public ApiResult<String,Object> toLogin(@ModelAttribute UserParam userParam) {
		resp = new ApiResult<String,Object>();
		resp = adminService.doLogin(userParam);
		return resp;
	}
	
	@RequestMapping("/loadVipDatas")
	@ResponseBody
	public ApiResult<String,VipUser> loadVipDatas(@ModelAttribute PageParam page) {
		ApiResult<String, VipUser> resp = new ApiResult<String,VipUser>();
		resp = userService.loadVipDatas(page);
		return resp;
	}

	@RequestMapping("/main")
	public ModelAndView toMain(@ModelAttribute PageParam page) {
		ModelAndView mv = null;
		List<VipUser> resp = new ArrayList<VipUser>();
		ApiResult<String, VipUser> resps = userService.loadVipDatas(page);
		resp = resps.getList();
		mv = new ModelAndView("main");
		mv.addObject("resps",resp);
		return mv;
	}
	
	@RequestMapping("/updateVipDatas")
	@ResponseBody
	public ApiResult<String, VipParam> updateVipDatas(@ModelAttribute VipParam param) {
		ApiResult<String, VipParam> resp = new ApiResult<String, VipParam>();
		resp = userService.updateVipDatas(param);
		return resp;
	}
}
