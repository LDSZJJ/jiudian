package com.gx.po;

import java.sql.Timestamp;

public class CanzhuoyudingPo {
	private Integer id;
	
	private Integer TableTypeID;
	
	private String TableNumber;
	
	private String PassengerName;
	
	private String Date;
	
	//宽展字段
	private String TableTypeName;  //商品类别名称
	
	private String uOMName;  //计量单位名称
		
	
	public String getDate() {
		return Date;
	}



	public void setDate(String date) {
		Date = date;
	}



	private Integer uOMID;
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getTableTypeID() {
		return TableTypeID;
	}



	public void setTableTypeID(Integer tableTypeID) {
		TableTypeID = tableTypeID;
	}



	public String getTableNumber() {
		return TableNumber;
	}



	public void setTableNumber(String tableNumber) {
		TableNumber = tableNumber;
	}



	public String getPassengerName() {
		return PassengerName;
	}



	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}




	public Integer getuOMID() {
		return uOMID;
	}



	public void setuOMID(Integer uOMID) {
		this.uOMID = uOMID;
	}



	public String getTableTypeName() {
		return TableTypeName;
	}



	public void setTableTypeName(String tableTypeName) {
		TableTypeName = tableTypeName;
	}



	public String getuOMName() {
		return uOMName;
	}



	public void setuOMName(String uOMName) {
		this.uOMName = uOMName;
	}


	
}
