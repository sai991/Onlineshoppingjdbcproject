package com.app.model;

public class Cart {
private int cid;
private int pid;
private int quantity;
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
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Cart [cid=" + cid + ", pid=" + pid + ", quantity=" + quantity + "]";
}
public Cart(int cid, int pid, int quantity) {
	super();
	this.cid = cid;
	this.pid = pid;
	this.quantity = quantity;
}
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}

}
