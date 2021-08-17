package com.app.model;

public class Customer {
private int cid;
private String cname;
private String emailid;
private String password;
private long contact;
private String address;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Customer [cid=" + cid + ", cname=" + cname + ", emailid=" + emailid + ", password=" + password
			+ ", contact=" + contact + ", address=" + address + "]";
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int cid, String cname, String emailid, String password, long contact, String address) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.emailid = emailid;
	this.password = password;
	this.contact = contact;
	this.address = address;
}


}
