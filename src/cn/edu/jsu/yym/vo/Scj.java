package cn.edu.jsu.yym.vo;

import java.io.Serializable;

public class Scj implements Serializable {
	private String xh;
	private String xm;
	private String xb;
	private Integer cj;
	public Scj() {
	}
	public Scj(String xh, String xm, String xb, Integer cj) {
		this.xh = xh;
		this.xm = xm;
		this.xb = xb;
		this.cj = cj;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public Integer getCj() {
		return cj;
	}
	public void setCj(Integer cj) {
		this.cj = cj;
	}
	@Override
	public String toString() {
		return "学号=" + xh + ", 姓名=" + xm + ", 性别=" + xb + ", 成绩=" + cj;
	}
}
