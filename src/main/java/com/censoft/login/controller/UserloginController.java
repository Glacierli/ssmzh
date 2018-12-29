package com.censoft.login.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.censoft.login.entity.Log;
import com.censoft.login.entity.Userlogin;
import com.censoft.login.service.LogService;
import com.censoft.login.service.UserloginService;

@Controller
@RequestMapping("/task2")
public class UserloginController {

	@Autowired
	private UserloginService userloginService;
	@Autowired
	private LogService  logService;
	
	//登录页跳转
	@RequestMapping("/logintwo")
	public String logintwo(){
		return "logintwo";
	}
	
	//存数据
	@RequestMapping(value="/push")
	public String pushuser(Userlogin u ){
		try {
			userloginService.insertuser(u);
			Log rz=new Log();
			rz.setCz(2);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String t = df.format(new Date());
			rz.setShijian(t);
			rz.setName(u.getName());
			rz.setPassworld(u.getPassworld());
			logService.insertlog(rz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/task2/demo.do";
	}
	
	@RequestMapping("/demo")
	public String shouwdemo(ModelMap map){
		try {
			List<Userlogin> selectAll = userloginService.selectAll();
			map.put("userlist",selectAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "demo";
		
	}
	
	@RequestMapping("/edit")
	public String showedit(Userlogin u,ModelMap map){
		try {
			Userlogin uu = userloginService.finbyid(u);
			map.put("use", uu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "edit";
		
		
	}
	@RequestMapping(value="/editt")
	public String submit(Userlogin u){
		try {
			
			Userlogin uu = userloginService.finbyid(u);
			Log rz=new Log();
			rz.setCz(0);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String t = df.format(new Date());
			rz.setShijian(t);
			rz.setName(uu.getName());
			rz.setPassworld(uu.getPassworld());
			userloginService.update(u);
			logService.insertlog(rz);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/task2/demo.do";
	
	}
	@RequestMapping("/del")
	public String delbyid(Userlogin u) throws Exception{
		
		Userlogin uu = userloginService.finbyid(u);
		Log rz=new Log();
		rz.setCz(1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t = df.format(new Date());
		rz.setShijian(t);
		rz.setName(uu.getName());
		rz.setPassworld(uu.getPassworld());
		logService.insertlog(rz);
		userloginService.del(u);
		return "redirect:/task2/demo.do";
	}
	
	//日志页面的跳转
	@RequestMapping("/log")
	public String showlog(ModelMap map) throws Exception{
		map.put("log", logService.selectAll());
		return "log";
	}
	
	@RequestMapping("/dellog")
	public String dellog(Log u){
		
			logService.del(u);
		
		return "redirect:/task2/log.do";
	}
	
	
}
