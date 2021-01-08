package cn.edu.jsu.yym.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.edu.jsu.yym.vo.Scj;

public class ScjExcel {
	public void exportExcel(List<Scj> listscj) {
		File file = new File("test1.xlsx");// 定位要操作的excel文件
		Workbook workbook = new XSSFWorkbook();// 创建工作簿对象
		Sheet sheet = workbook.createSheet("test1");// 创建工作表对象
		
		int i=0;
		for(Scj scj:listscj) {
			Row row = sheet.createRow(i);// 创建行对象，下标从0开始
			Cell cell1 = row.createCell(0);// 创建单元格，从0开始
			cell1.setCellValue(scj.getXh());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(scj.getXm());
			Cell cell3 = row.createCell(2);
			cell3.setCellValue(scj.getXb());
			Cell cell4 = row.createCell(3);
			cell4.setCellValue(scj.getCj());
			i++;
		}
		
		
		try(FileOutputStream fos = new FileOutputStream(file);) {
			workbook.write(fos);// 将内容写入到指定的excel文档
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
