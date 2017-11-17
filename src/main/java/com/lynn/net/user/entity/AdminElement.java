package com.lynn.net.user.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class AdminElement {
	private String id;
	
	private String name;
	
	private String password;
	
	private String phone;
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", getId());
		map.put("name", getName());
		map.put("password", getPassword());
		map.put("phone", getPhone());
		return map;
	}
	
	public AdminElement fromMap(Map<String, String> map) {
		AdminElement ae = new AdminElement();
		ae.setId(map.get("id"));
		ae.setName(map.get("name"));
		ae.setPassword(map.get("password"));
		ae.setPhone(map.get("phone"));
		return ae;
	}
}
