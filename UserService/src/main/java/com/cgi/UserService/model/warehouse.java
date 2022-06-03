package com.cgi.UserService.model;

public class warehouse {

	String warehouseid;
	String warehousename;
	
	
	
	

public warehouse(String warehouseid, String warehousename) {
		super();
		this.warehouseid = warehouseid;
		this.warehousename = warehousename;
	}
public warehouse() {
	
}
public String getWarehouseid() {
	return warehouseid;
}
public void setWarehouseid(String warehouseid) {
	this.warehouseid = warehouseid;
}
public String getWarehousename() {
	return warehousename;
}
public void setWarehousename(String warehousename) {
	this.warehousename = warehousename;
}
@Override
public String toString() {
	return "warehouse [warehouseid=" + warehouseid + ", warehousename=" + warehousename + "]";
}

	
	
}