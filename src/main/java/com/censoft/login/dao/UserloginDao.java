package com.censoft.login.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.censoft.login.entity.Userlogin;
@Component
public interface UserloginDao {
	public void insertuser(Userlogin u);
	// 查询所有
		public List<Userlogin> selectAll();
		//根据id 查询
		public Userlogin finbyid(Userlogin u);
		public void update(Userlogin u);
		public void del(Userlogin u);
}
