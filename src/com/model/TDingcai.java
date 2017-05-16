package com.model;

/**
 * TDingcai entity. @author MyEclipse Persistence Tools
 */

public class TDingcai implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer goodsId;
	private String shuliang;
	private String xingming;
	
	
	private String lianxi;
	private String dizhi;
	private Integer userId;
	
	
	private TGoods goods;
	private TJiudian jiudian;

	// Constructors

	/** default constructor */
	public TDingcai()
	{
	}

	/** full constructor */
	public TDingcai(Integer goodsId, String shuliang, String xingming,
			String lianxi, String dizhi, Integer userId)
	{
		this.goodsId = goodsId;
		this.shuliang = shuliang;
		this.xingming = xingming;
		this.lianxi = lianxi;
		this.dizhi = dizhi;
		this.userId = userId;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getGoodsId()
	{
		return this.goodsId;
	}

	public TGoods getGoods()
	{
		return goods;
	}

	public void setGoods(TGoods goods)
	{
		this.goods = goods;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getShuliang()
	{
		return this.shuliang;
	}

	public void setShuliang(String shuliang)
	{
		this.shuliang = shuliang;
	}

	public String getXingming()
	{
		return this.xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getLianxi()
	{
		return this.lianxi;
	}

	public void setLianxi(String lianxi)
	{
		this.lianxi = lianxi;
	}

	public String getDizhi()
	{
		return this.dizhi;
	}

	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}

	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public TJiudian getJiudian() {
		return jiudian;
	}

	public void setJiudian(TJiudian jiudian) {
		this.jiudian = jiudian;
	}

}