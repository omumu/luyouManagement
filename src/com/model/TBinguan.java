package com.model;

/**
 * TBinguan entity. @author MyEclipse Persistence Tools
 */

public class TBinguan implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String mingcheng;
	private String dizhi;
	private String dianhua;
	
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getMingcheng()
	{
		return mingcheng;
	}
	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}
	public String getDizhi()
	{
		return dizhi;
	}
	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}
	public String getDianhua()
	{
		return dianhua;
	}
	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}

}