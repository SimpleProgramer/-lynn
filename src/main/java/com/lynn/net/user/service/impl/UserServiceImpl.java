package com.lynn.net.user.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.net.cache.CommonCacheUtil;
import com.lynn.net.commons.constants.Constants;
import com.lynn.net.commons.exception.CustomException;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.GrnerateUUID;
import com.lynn.net.commons.util.JsonUtil;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.commons.util.TimeUtils;
import com.lynn.net.user.dao.VipUserDao;
import com.lynn.net.user.entity.VipParam;
import com.lynn.net.user.entity.VipUser;
import com.lynn.net.user.entity.VipUserExample;
import com.lynn.net.user.service.UserService;


/**
 * 会员管理业务类实现类
 * @author wz
 * @date 2017年11月22日14:35:39
 * */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private VipUserDao userDao;
	@Autowired
	private CommonCacheUtil cacheUtil;
	private VipUserExample example;
	private VipUserExample.Criteria criteria;
	
	@Override
	public ApiResult<String,VipUser> loadVipDatas(PageParam page) {
		ApiResult<String,VipUser> resp = new ApiResult<String,VipUser>();
		//会员信息属于热点数据,先从redis查找,再从数据库查找
		String jsonStr = cacheUtil.getCacheValue(Constants.VIP_USER_DATA_PREX + "pageSize:" + page.getPageSize() + "pageIndex:" + page.getPageIndex());
		List<VipUser> users = JsonUtil.jsonToList(jsonStr);
		if(users == null || users.size() == 0) {
			//查询数据库
			example = new VipUserExample();
			example.setFromRowNum(page.getFromNumber());
			example.setToRowNum(page.getPageSize());
			users = userDao.selectByExample(example);
			for (int i = 0; i < users.size(); i++) {
				VipUser vu = (VipUser) users.get(i);
				vu.setDateString(TimeUtils.dateToString(vu.getCreateDate(), "yyyy-MM-dd"));
			}
			//json缓存进redis
			cacheUtil.cache(Constants.VIP_USER_DATA_PREX + "pageSize:" + page.getPageSize() + "pageIndex:" + page.getPageIndex(), JsonUtil.listToJson(users));
		}
		resp.setCode(Constants.RESP_STATUS_OK);
		resp.setMessage("会员信息");
		resp.setList(users);
		return resp;
	}

	@Override
	public ApiResult<String, VipParam> updateVipDatas(VipParam param) {
		ApiResult<String,VipParam> resp = new ApiResult<String,VipParam>();
		//修改主库内容.理论上读库同步,但数据库没有做同步处理,
		//修改后清楚redis缓存,下一次重新读取.
		if(StringUtils.isBlank(param.getId())) {
			resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
			resp.setData("参数校验失败");
			resp.setMessage("登录失败");
			try {
				throw new CustomException("参数校验失败");
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		int result = 0;
		if("-1".equals(param.getId())) {
			//添加
			VipUser vu = new VipUser();
			vu.setId(GrnerateUUID.getUUID());
			vu.setCreateDate(new Date());
			vu.setSurplusAmount(param.getVipAmount());
			vu.setUserAddress(param.getVipAddress());
			vu.setUserName(param.getVipName());
			vu.setUserPhone(param.getVipPhone());
			result = userDao.insertSelective(vu);
		}else {
			//修改
			result = userDao.updateVipInfoDatas(param);
		}
		if(result > 0) {
			//删除redis缓存
			cacheUtil.delKey(Constants.VIP_USER_DATA_PREX + "pageSize:" + param.getPageSize() + "pageIndex:" + param.getPageIndex());
		}
		resp.setCode(Constants.RESP_STATUS_OK);
		resp.setMessage("修改成功");
		resp.setObj(param);
		return resp;
	}
}
