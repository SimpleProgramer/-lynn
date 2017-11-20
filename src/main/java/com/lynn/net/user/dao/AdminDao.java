package com.lynn.net.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lynn.net.user.entity.Admin;
import com.lynn.net.user.entity.AdminExample;
import com.wz.net.GenericMapper;

 /**
 * generator XML
 **/
public interface AdminDao extends GenericMapper<Admin, AdminExample, String> {
}