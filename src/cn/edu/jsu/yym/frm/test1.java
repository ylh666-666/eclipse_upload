package cn.edu.jsu.yym.frm;

import java.util.Iterator;
import java.util.List;

import cn.edu.jsu.yym.dao.ScjDAO;
import cn.edu.jsu.yym.vo.Scj;

public class test1 {

	public static void main(String[] args) {
		List<Scj> list=new ScjDAO().getAllScjData();
		Iterator<Scj> it=list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}

}
