package com.censoft.login.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.censoft.login.dao.LogDao;
import com.censoft.login.entity.Log;
import com.censoft.login.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogDao  logMapper;;
	
	//插入日志信息
	public void insertlog(Log u){
		
		logMapper.insertlog(u);
	}
	// 查询所有
	public List<Log> selectAll() {
		List<Log> selectList = logMapper.selectAll();
		return selectList;
	}
	//删除
	public void del(Log u) {
		// TODO Auto-generated method stub
		logMapper.del(u);
	}
}
