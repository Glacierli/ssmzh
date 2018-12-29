package com.censoft.login.service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.censoft.login.dao.UserloginDao;
import com.censoft.login.entity.Userlogin;
@Service
public interface UserloginService {
	//插入用户信息
	public void insertuser(Userlogin u) ;
	// 查询所有
	public List<Userlogin> selectAll() ;
	//根据id 查询
	public Userlogin finbyid(Userlogin u) ;
	public void update(Userlogin u);
	public void del(Userlogin u) ;

}
