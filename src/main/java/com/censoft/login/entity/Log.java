package com.censoft.login.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * log实体类
 */
public class Log implements Serializable{
private int id;
private String name;
private String passworld;
private String shijian;
private int cz;


public Log() {
	super();
}
public Log(int id, String name, String passworld, int cz, String shijian) {
	super();
	this.id = id;
	this.name = name;
	this.passworld = passworld;
	this.shijian = shijian;
	this.cz = cz;
}


@Override
public String toString() {
	return "Log [id=" + id + ", name=" + name + ", passworld=" + passworld + ", shijian=" + shijian + ", cz=" + cz
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
public String getPassworld() {
	return passworld;
}
public void setPassworld(String passworld) {
	this.passworld = passworld;
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
