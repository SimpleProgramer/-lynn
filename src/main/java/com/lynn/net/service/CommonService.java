package com.lynn.net.service;

import java.util.List;

import com.lynn.net.commons.util.PageParam;
import com.lynn.net.user.entity.VipUser;

public interface CommonService {

	List getDatasByPath(String path,PageParam page);


}
