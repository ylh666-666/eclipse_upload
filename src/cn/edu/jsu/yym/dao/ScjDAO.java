package cn.edu.jsu.yym.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.jsu.yym.dbc.DatabaseConnection;
import cn.edu.jsu.yym.vo.Scj;

public class ScjDAO {
	private Connection conn=new DatabaseConnection().getConnection();
	public ScjDAO() {}
	public List<Scj> getAllScjData() {
		List<Scj> list=new ArrayList<Scj>();
		String sql="select xh,xm,xb,cj from scj";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Scj scj=new Scj();
				scj.setXh(rs.getString(1));
				scj.setXm(rs.getString(2));
				scj.setXb(rs.getString(3));
				scj.setCj(rs.getInt(4));
				list.add(scj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Vector<Vector> getTableRows(List<Scj> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			Scj scj=list.get(i);
			Collections.addAll(row, scj.getXh(),scj.getXm(),scj.getXb(),scj.getCj());
			rows.add(row);
		}
		
		return rows;
	}

}
