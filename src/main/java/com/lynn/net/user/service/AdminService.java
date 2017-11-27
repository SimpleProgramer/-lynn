package com.lynn.net.user.service;

import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.user.entity.UserParam;

public interface AdminService {

	ApiResult<String,Object> doLogin(UserParam userParam);
	
}
