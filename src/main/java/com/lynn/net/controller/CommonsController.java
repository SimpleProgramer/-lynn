package com.lynn.net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lynn.net.commons.util.PageParam;
import com.lynn.net.mall.entity.MallGoods;
import com.lynn.net.service.CommonService;
import com.lynn.net.user.entity.VipUser;

@Controller
public class CommonsController<E> {

	@Autowired
	private CommonService commonService;

	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{path}.{toPath}.{pageIndex}.{pageSize}")
	public ModelAndView toLogin(@PathVariable String path,@PathVariable String toPath,@PathVariable Integer pageIndex,@PathVariable Integer pageSize) {
		PageParam page = new PageParam();
		ModelAndView mv = null;
		if(pageIndex != null && pageIndex != 0)
			page.setPageIndex(pageIndex);
		if(pageSize != null && pageSize != 0)
			page.setPageSize(pageSize);

		if(toPath != null && !"".equals(toPath)) {
			String[] paths = toPath.split(";");
			for (int i = 0; i < paths.length; i++) {
				path += "/" + paths[i];
			}
		}
		mv = new ModelAndView(path);
		List list =commonService.getDatasByPath(path,page);
		if(path.startsWith("main")) {
			List<VipUser> lists = list;
			mv.addObject("resps", lists);
		}else if(path.startsWith("mall")) {
			List<MallGoods> lists = list;
			mv.addObject("resps",lists);
		}
		return mv;
	}
	
}
