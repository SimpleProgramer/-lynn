package com.lynn.net.user.entity;

import com.lynn.net.user.entity.base.BVipUser;

public class VipUser extends BVipUser {
    private static final long serialVersionUID = 1L;
    
    private String dateString;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}