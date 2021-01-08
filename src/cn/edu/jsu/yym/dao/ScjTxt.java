package cn.edu.jsu.yym.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.edu.jsu.yym.vo.Scj;

public class ScjTxt {
	public void exportTxt(List<Scj> listscj) {
		File file = new File("test.txt");// 定位要操作的excel文件
		try(FileWriter fos = new FileWriter(file);
				BufferedWriter bw=new BufferedWriter(fos)) {
			int i=0;
			for(Scj scj:listscj) {
				bw.write(scj.toString());
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
		
	}
}
