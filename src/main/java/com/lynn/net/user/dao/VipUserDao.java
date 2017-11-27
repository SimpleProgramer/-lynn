package com.lynn.net.user.dao;

import com.lynn.net.user.entity.VipParam;
import com.lynn.net.user.entity.VipUser;
import com.lynn.net.user.entity.VipUserExample;
import com.wz.net.GenericMapper;

 /**
 * generator XML
 **/
public interface VipUserDao extends GenericMapper<VipUser, VipUserExample, String> {

	int updateVipInfoDatas(VipParam param);

}