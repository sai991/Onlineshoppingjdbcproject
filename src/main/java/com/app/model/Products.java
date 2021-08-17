package com.app.model;

public class Products {
	private int pid;
	private String pname;
	private double cost;
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", cost=" + cost + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Products(int pid, String pname, double cost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	}
	


