package com.app.model;

public class PlaceOrder {
	private int oid;
	private int cid;
	private int pid;
	private String pname;
	private int quantity;
	private boolean orderReceived=false;
	private boolean orderShipped=false;
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
	public boolean isOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(boolean orderReceived) {
		this.orderReceived = orderReceived;
	}
	public boolean isOrderShipped() {
		return orderShipped;
	}
	public void setOrderShipped(boolean orderShipped) {
		this.orderShipped = orderShipped;
	}
	@Override
	public String toString() {
		return "PlaceOrder [oid=" + oid + ", cid=" + cid + ", pid=" + pid + ", pname=" + pname + ", quantity="
				+ quantity + ", orderReceived=" + orderReceived + ", orderShipped=" + orderShipped + "]";
	}
	public PlaceOrder(int oid, int cid, int pid, String pname, int quantity, boolean orderReceived,
			boolean orderShipped) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.orderReceived = orderReceived;
		this.orderShipped = orderShipped;
	}
	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	

}
