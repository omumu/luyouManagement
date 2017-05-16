package com.model;

public class TToupiao  implements java.io.Serializable{

	private Integer id;
	
	private Integer userId;
	
	private Integer acId;
	
	private Integer eId;

	public TToupiao() {
	}

	public TToupiao(Integer id, Integer userId, Integer acId, Integer eId) {
		super();
		this.id = id;
		this.userId = userId;
		this.acId = acId;
		this.eId = eId;
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

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}
	
}
