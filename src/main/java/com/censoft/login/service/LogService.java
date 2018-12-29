package com.censoft.login.service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.censoft.login.dao.LogDao;
import com.censoft.login.entity.Log;
@Service
public interface LogService {

	
	//插入日志信息
	public void insertlog(Log u) ;
	// 查询所有
	public List<Log> selectAll();
	//删除
	public void del(Log u);


}
