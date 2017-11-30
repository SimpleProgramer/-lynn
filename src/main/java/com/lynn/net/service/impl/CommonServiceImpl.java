package com.lynn.net.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.mall.entity.MallGoods;
import com.lynn.net.mall.service.MallGoodsService;
import com.lynn.net.service.CommonService;
import com.lynn.net.user.entity.VipUser;
import com.lynn.net.user.service.UserService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private UserService userService;
	@Autowired
	private MallGoodsService mallGoodsService;
	
	@Override
	public List getDatasByPath(String path,PageParam page) {
		List list = new ArrayList();
		if(path.startsWith("main")) {
			ApiResult<String, VipUser> resps = userService.loadVipDatas(page);
			list = resps.getList();
		}else if (path.startsWith("mall")) {
			ApiResult<String, MallGoods> reps = mallGoodsService.loadMallGoodsDatas(page);
			list = reps.getList();
		}
		return list;
	}
}
