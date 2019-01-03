package com.censoft.login.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * log实体类
 */
public class Log implements Serializable{
private int id;
private String name;
private String password;
private String shijian;
private int cz;


public Log() {
	super();
}
public Log(int id, String name, String password, int cz, String shijian) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.shijian = shijian;
	this.cz = cz;
}


@Override
public String toString() {
	return "Log [id=" + id + ", name=" + name + ", password=" + password + ", shijian=" + shijian + ", cz=" + cz
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getCz() {
	return cz;
}
public void setCz(int cz) {
	this.cz = cz;
}
public String getShijian() {
	return shijian;
}
public void setShijian(String shijian) {
	this.shijian = shijian;
}

}
