package com.lynn.net.user.service;

import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.user.entity.VipParam;
import com.lynn.net.user.entity.VipUser;

/**
 * 会员管理业务类
 * @author wz
 * */
public interface UserService {

	/**
	 * 加载会员基本信息
	 * */
	ApiResult<String,VipUser> loadVipDatas(PageParam page);

	ApiResult<String, VipParam> updateVipDatas(VipParam param);

}
