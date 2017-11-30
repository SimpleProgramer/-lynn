package com.lynn.net.mall.dao;

import java.util.List;

import com.lynn.net.mall.entity.MallGoods;
import com.lynn.net.mall.entity.MallGoodsExample;
import com.wz.net.GenericMapper;

 /**
 * generator XML
 **/
public interface MallGoodsDao extends GenericMapper<MallGoods, MallGoodsExample, String> {

	List<MallGoods> selectTwoTableByExample(MallGoodsExample example);
}