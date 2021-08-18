package com.app.model;

public class PlaceOrder {
	private int oid;
	private int cid;
	private int pid;
	private String pname;
	private double cost;
	private int quantity;
	private String orderReceived="false";
	private String orderShipped="false";
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String isOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(String orderReceived) {
		this.orderReceived = orderReceived;
	}
	public String isOrderShipped() {
		return orderShipped;
	}
	public void setOrderShipped(String orderShipped) {
		this.orderShipped = orderShipped;
	}
	@Override
	public String toString() {
		return "PlaceOrder [oid=" + oid + ", cid=" + cid + ", pid=" + pid + ", pname=" + pname + ", cost=" + cost
				+ ", quantity=" + quantity + ", orderReceived=" + orderReceived + ", orderShipped=" + orderShipped
				+ "]";
	}
	public PlaceOrder(int oid, int cid, int pid, String pname, double cost, int quantity, String orderReceived,
			String orderShipped) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.quantity = quantity;
		this.orderReceived = orderReceived;
		this.orderShipped = orderShipped;
	}
	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
	

}
