package com.censoft.login.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.censoft.login.entity.Log;
@Component
public interface LogDao {
	public void insertlog(Log u);
	public List<Log> selectAll();
	public void del(Log u) ;
}
