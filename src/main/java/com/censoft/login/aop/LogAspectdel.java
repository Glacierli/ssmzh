package com.censoft.login.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.censoft.login.entity.Userlogin;

@Service
@Aspect
public class LogAspectdel {

	@Pointcut("execution(void com.censoft.login.dao.*Dao.del(..))")
	public void piontcut(){}
	@After("piontcut()")
	public void login(JoinPoint point) throws Throwable{

		Arrays.toString(point.getArgs());
		System.out.println( Arrays.toString(point.getArgs())+ "del");
	}
	
	
}
