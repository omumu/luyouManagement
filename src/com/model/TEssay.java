package com.model;

public class TEssay  implements java.io.Serializable{

	private Integer id;
	
	private Integer userId;
	
	private Integer acId;
	
	private String biaoti;
	
	private String neirong;
	
	private String fabusj;

	
	public TEssay() {
	}

	public TEssay(Integer id, Integer userId, String neirong, String fabusj) {
		super();
		this.id = id;
		this.userId = userId;
		this.neirong = neirong;
		this.fabusj = fabusj;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getNeirong() {
		return neirong;
	}


	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}


	public String getFabusj() {
		return fabusj;
	}

	public void setFabusj(String fabusj) {
		this.fabusj = fabusj;
	}
	
}
