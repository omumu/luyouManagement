package com.model;

/**
 * TYuding generated by MyEclipse Persistence Tools
 */

public class TYuding implements java.io.Serializable
{


	private Integer id;
	private Integer kefangId;
	private String riqi;
	private String kehuming;
	
	private String dianhua;
	private String beizhu;
	private Integer userId;
	private String zhuangtai;
	
	private TKefang kefang;
	private TBinguan binguan;
	
	public String getBeizhu()
	{
		return beizhu;
	}
	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}
	public String getDianhua()
	{
		return dianhua;
	}
	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public TKefang getKefang()
	{
		return kefang;
	}
	public void setKefang(TKefang kefang)
	{
		this.kefang = kefang;
	}
	public String getKehuming()
	{
		return kehuming;
	}
	public void setKehuming(String kehuming)
	{
		this.kehuming = kehuming;
	}
	
	public String getRiqi()
	{
		return riqi;
	}
	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}
	public Integer getKefangId()
	{
		return kefangId;
	}
	public void setKefangId(Integer kefangId)
	{
		this.kefangId = kefangId;
	}
	public TBinguan getBinguan() {
		return binguan;
	}
	public void setBinguan(TBinguan binguan) {
		this.binguan = binguan;
	}
	
	
}