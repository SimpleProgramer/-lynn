package com.lynn.net.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.net.commons.constants.Constants;
import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.commons.util.TimeUtils;
import com.lynn.net.mall.dao.MallGoodsDao;
import com.lynn.net.mall.entity.MallGoods;
import com.lynn.net.mall.entity.MallGoodsExample;
import com.lynn.net.mall.service.MallGoodsService;

@Service
public class MallGoodsServiceImpl implements MallGoodsService {
	
	@Autowired
	private MallGoodsDao mallGoodsDao;
	private MallGoodsExample example;
	private MallGoodsExample.Criteria criteria;

	@Override
	public ApiResult<String, MallGoods> loadMallGoodsDatas(PageParam page) {
		ApiResult<String, MallGoods> resp = new ApiResult<String, MallGoods>();
		example = new MallGoodsExample();
		criteria = example.createCriteria();
		example.setFromRowNum(page.getFromNumber());
		example.setToRowNum(page.getPageSize());
		List<MallGoods> list = mallGoodsDao.selectTwoTableByExample(example);
		if(list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setDateString(TimeUtils.dateToString(list.get(i).getCreateDate(), "yyyy-MM-dd"));
			}
			resp.setCode(Constants.RESP_STATUS_OK);
			resp.setList(list);
		}
		return resp;
	}
}
