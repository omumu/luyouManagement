package com.model;

/**
 * TBaoming entity. @author MyEclipse Persistence Tools
 */

public class TBaoming implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer xianluId;
	private Integer userId;
	private String lianxifangshi;
	
	private String beizhu;
	private String baomingshi;
	private String zhuangtai;
	
	private TXianlu xianlu;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getXianluId()
	{
		return xianluId;
	}
	public void setXianluId(Integer xianluId)
	{
		this.xianluId = xianluId;
	}
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
	public TXianlu getXianlu()
	{
		return xianlu;
	}
	public void setXianlu(TXianlu xianlu)
	{
		this.xianlu = xianlu;
	}
	public String getLianxifangshi()
	{
		return lianxifangshi;
	}
	public void setLianxifangshi(String lianxifangshi)
	{
		this.lianxifangshi = lianxifangshi;
	}
	public String getBeizhu()
	{
		return beizhu;
	}
	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}
	public String getBaomingshi()
	{
		return baomingshi;
	}
	public void setBaomingshi(String baomingshi)
	{
		this.baomingshi = baomingshi;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}