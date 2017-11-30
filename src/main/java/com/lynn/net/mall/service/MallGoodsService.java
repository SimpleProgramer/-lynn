package com.lynn.net.mall.service;

import com.lynn.net.commons.resp.ApiResult;
import com.lynn.net.commons.util.PageParam;
import com.lynn.net.mall.entity.MallGoods;

public interface MallGoodsService {

	ApiResult<String, MallGoods> loadMallGoodsDatas(PageParam page);

}
