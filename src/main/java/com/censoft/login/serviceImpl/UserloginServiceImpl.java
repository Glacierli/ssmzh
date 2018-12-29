package com.censoft.login.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.censoft.login.dao.UserloginDao;
import com.censoft.login.entity.Userlogin;
import com.censoft.login.service.UserloginService;

@Service
public class UserloginServiceImpl implements UserloginService {

	@Autowired
	private UserloginDao userloginMapper; 
	
 	
	//插入用户信息
	public void insertuser(Userlogin u){
		userloginMapper.insertuser(u);
	}
	// 查询所有
	public List<Userlogin> selectAll() {
		List<Userlogin> selectList = userloginMapper.selectAll();
		return selectList;
	}
	//根据id 查询
	public Userlogin finbyid(Userlogin u){
		Userlogin selectOne = userloginMapper.finbyid(u);
		return selectOne;
		
	}
	public void update(Userlogin u) {
		userloginMapper.update(u);
	}
	public void del(Userlogin u) {
		userloginMapper.del(u);
	}
}
