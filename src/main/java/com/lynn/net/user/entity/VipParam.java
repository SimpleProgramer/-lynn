package com.lynn.net.user.entity;

import java.util.Date;

import com.lynn.net.commons.util.PageParam;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VipParam extends PageParam {
	private String id;
	private String vipName;
	private double vipAmount;
	private String vipPhone;
	private String vipAddress;
	private Date createDate;
	
}
