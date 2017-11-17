package com.lynn.net.user.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.net.cache.CommonCacheUtil;
import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.user.dao.AdminDao;
import com.lynn.net.user.entity.AdminElement;
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

	@Override
	public ApiResult<String> doLogin(UserParam userParam) {
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
			if(!StringUtils.isBlank(pwd)) {
				//校验密码
			}else {
				//查询数据库
			}
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
