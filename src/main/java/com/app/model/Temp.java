package com.app.model;

public class Temp {
	private int pid;
	private String pname;
	private double cost;
	private Cart cart;
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ",quantity=" + cart.getQuantity() +"]";
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
	public Temp(int pid, String pname, double cost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
	}
	public Temp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
