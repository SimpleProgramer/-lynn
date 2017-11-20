package com.lynn.net.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.net.cache.CommonCacheUtil;
import com.lynn.net.commons.constants.Constants;
import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.MD5Util;
import com.lynn.net.user.dao.AdminDao;
import com.lynn.net.user.entity.Admin;
import com.lynn.net.user.entity.AdminElement;
import com.lynn.net.user.entity.AdminExample;
import com.lynn.net.user.entity.UserParam;
import com.lynn.net.user.service.AdminService;

/**
 * 管理员业务操作类
 * @author wangzun
 * */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CommonCacheUtil cacheUtil;
	private AdminExample example;
	private AdminExample.Criteria criteria;

	@Override
	public ApiResult<String> doLogin(UserParam userParam) {
		ApiResult<String> resp = new ApiResult<String>();
		//验证参数是否合法
		try {
			String userName = userParam.getUserName();
			String password = userParam.getPassword();
			boolean rememberMe = userParam.isRemember();
			if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
				throw new CustomException("参数校验失败");
			}
			//检查redis是否有该对象缓存有则查redis,无则查数据库
			String pwd = cacheUtil.getAdminLoginParam(userName);
			password = MD5Util.getMD5(Constants.PWD_PREX + password);
			if(!StringUtils.isBlank(pwd)) {
				//校验密码
				if(password.equals(pwd)) {
					//密码正确,登录成功
					resp.setCode(Constants.RESP_STATUS_OK);
					resp.setData(userName);
					resp.setMessage("登录成功");
				}else {
					resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
					resp.setData(userName);
					resp.setMessage("登录失败");
				}
			}else {
				//查询数据库
				example = new AdminExample();
				criteria = example.createCriteria();
				criteria.andNameEqualTo(userName);
				List<Admin> admins = adminDao.selectByExample(example);
				if(admins != null && admins.size() > 0) {
					if(password.equals(admins.get(0).getPassword())) {
						//密码正确,登录成功
						resp.setCode(Constants.RESP_STATUS_OK);
						resp.setData(userName);
						resp.setMessage("登录成功");
						//将密码及name存入redis
						cacheUtil.cache(userName, password);
					}else {
						resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
						resp.setData(userName);
						resp.setMessage("登录失败");
					}
				}
			}
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

}
