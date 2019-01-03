package com.censoft.login.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
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
	private LogService logService;

	// 登录页跳转
	@RequestMapping("/logintwo")
	public String logintwo() {
		return "logintwo";
	}

	// 存数据
	@RequestMapping(value = "/push")
	public String pushuser(Userlogin u) {
		try {
			userloginService.insertuser(u);
			Log rz = new Log();
			rz.setCz(2);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String t = df.format(new Date());
			rz.setShijian(t);
			rz.setName(u.getName());
			rz.setPassword(u.getPassword());
			logService.insertlog(rz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/task2/demo.do";
	}

	@RequestMapping("/demo")
	public String shouwdemo(ModelMap map) {
		try {
			List<Userlogin> selectAll = userloginService.selectAll();
			map.put("userlist", selectAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "demo";

	}

	@RequestMapping("/edit")
	public String showedit(Userlogin u, ModelMap map) {
		try {
			Userlogin uu = userloginService.finbyid(u);
			map.put("use", uu);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "edit";

	}

	@RequestMapping(value = "/editt")
	public String submit(Userlogin u) {
		try {

			Userlogin uu = userloginService.finbyid(u);
			Log rz = new Log();
			rz.setCz(0);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String t = df.format(new Date());
			rz.setShijian(t);
			rz.setName(uu.getName());
			rz.setPassword(uu.getPassword());
			userloginService.update(u);
			logService.insertlog(rz);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/task2/demo.do";

	}

	@RequestMapping("/del")
	public String delbyid(Userlogin u) throws Exception {

		Userlogin uu = userloginService.finbyid(u);
		Log rz = new Log();
		rz.setCz(1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t = df.format(new Date());
		rz.setShijian(t);
		rz.setName(uu.getName());
		rz.setPassword(uu.getPassword());
		logService.insertlog(rz);
		userloginService.del(u);
		return "redirect:/task2/demo.do";
	}

	// 日志页面的跳转
	@RequestMapping("/log")
	public String showlog(ModelMap map) throws Exception {
		map.put("log", logService.selectAll());
		return "log";
	}

	@RequestMapping("/dellog")
	public String dellog(Log u) {

		logService.del(u);

		return "redirect:/task2/log.do";
	}

	//导出日志 创建Excel
	@RequestMapping("/createExcel")
	public String createExcel(HttpServletResponse response) throws IOException {

		// 1.创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		//2. 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("日志表");
		// 3，在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 4.创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		//设置单元格的样式
		style(wb,cell);
		cell.setCellValue("用户操作日志一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
	
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("用户编号");
		row2.createCell(1).setCellValue("被操作u");
		row2.createCell(2).setCellValue("被操作p");
		row2.createCell(3).setCellValue("时间");
		row2.createCell(4).setCellValue("操作类型");
		// 在sheet里创建第三行
		List<Log> selectAll = logService.selectAll();
		for (int x = 0; x < selectAll.size(); x++) {
			Log log = selectAll.get(x);
			HSSFRow createRow = sheet.createRow(2 + x);
			createRow.createCell(0).setCellValue(x + 1);
			createRow.createCell(1).setCellValue(log.getName());
			createRow.createCell(2).setCellValue(log.getPassword());
			createRow.createCell(3).setCellValue(log.getShijian());
			String cz = "";
			if (log.getCz() == 0){
				cz = "编辑";
			} else if (log.getCz() == 1) {
				cz = "删除";
			} else {
				cz = "login";
			}
			createRow.createCell(4).setCellValue(cz);
		}
		// .....省略部分代码

		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=log.xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
		return null;
	}

	/**
	 * @param wb
	 * @param cell
	 */
	public void style(HSSFWorkbook wb, HSSFCell cell) {
		HSSFCellStyle cellStyle = cell.getCellStyle();
		// 设置单元格内容
		//设置风格，水平居中
		// 设置样式
		HSSFCellStyle createCellStyle = wb.createCellStyle();
		createCellStyle.cloneStyleFrom(cellStyle);
		createCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cell.setCellStyle(createCellStyle);
	}
}
