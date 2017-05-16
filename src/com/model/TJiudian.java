package com.model;

/**
 * TJiudian entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TJiudian implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mingcheng;
	private String dizhi;
	private String dianhua;
	private String jieshao;

	// Constructors

	/** default constructor */
	public TJiudian() {
	}

	/** full constructor */
	public TJiudian(String mingcheng, String dizhi, String dianhua,
			String jieshao) {
		this.mingcheng = mingcheng;
		this.dizhi = dizhi;
		this.dianhua = dianhua;
		this.jieshao = jieshao;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getDizhi() {
		return this.dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getJieshao() {
		return this.jieshao;
	}

	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

}