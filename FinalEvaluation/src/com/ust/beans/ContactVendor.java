package com.ust.beans;

public class ContactVendor {
	private int cid;
	private String name;
	private String department;
	private String email;
	private long phone;
	private int vid;
	private int isActive;
	private String vname;
	private String vaddr;
	private String vlocation;
	private String vservice;
	private long vpincode;
	public ContactVendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactVendor(int cid, String name, String department, String email,
			long phone, int vid, int isActive, String vname, String vaddr,
			String vlocation, String vservice, long vpincode) {
		super();
		this.cid = cid;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.vid = vid;
		this.isActive = isActive;
		this.vname = vname;
		this.vaddr = vaddr;
		this.vlocation = vlocation;
		this.vservice = vservice;
		this.vpincode = vpincode;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVaddr() {
		return vaddr;
	}
	public void setVaddr(String vaddr) {
		this.vaddr = vaddr;
	}
	public String getVlocation() {
		return vlocation;
	}
	public void setVlocation(String vlocation) {
		this.vlocation = vlocation;
	}
	public String getVservice() {
		return vservice;
	}
	public void setVservice(String vservice) {
		this.vservice = vservice;
	}
	public long getVpincode() {
		return vpincode;
	}
	public void setVpincode(long vpincode) {
		this.vpincode = vpincode;
	}
	@Override
	public String toString() {
		return "ContactVendor [cid=" + cid + ", name=" + name + ", department="
				+ department + ", email=" + email + ", phone=" + phone
				+ ", vid=" + vid + ", isActive=" + isActive + ", vname="
				+ vname + ", vaddr=" + vaddr + ", vlocation=" + vlocation
				+ ", vservice=" + vservice + ", vpincode=" + vpincode + "]";
	}
	
}
