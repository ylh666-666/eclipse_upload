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
		File file = new File("test1.xlsx");// ��λҪ������excel�ļ�
		Workbook workbook = new XSSFWorkbook();// ��������������
		Sheet sheet = workbook.createSheet("test1");// �������������
		
		int i=0;
		for(Scj scj:listscj) {
			Row row = sheet.createRow(i);// �����ж����±��0��ʼ
			Cell cell1 = row.createCell(0);// ������Ԫ�񣬴�0��ʼ
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
			workbook.write(fos);// ������д�뵽ָ����excel�ĵ�
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
