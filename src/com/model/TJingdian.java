package com.model;

/**
 * TJingdian generated by MyEclipse Persistence Tools
 */

public class TJingdian implements java.io.Serializable
{

	// Fields

	private Integer id;

	private String name;

	private String dizhi;

	private Integer menpiao;

	private String jieshao;

	private String fujian;

	private String del;

	// Constructors

	/** default constructor */
	public TJingdian()
	{
	}

	/** full constructor */
	public TJingdian(String name, String dizhi, Integer menpiao,
			String jieshao, String fujian, String del)
	{
		this.name = name;
		this.dizhi = dizhi;
		this.menpiao = menpiao;
		this.jieshao = jieshao;
		this.fujian = fujian;
		this.del = del;
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

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDizhi()
	{
		return this.dizhi;
	}

	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}

	public Integer getMenpiao()
	{
		return this.menpiao;
	}

	public void setMenpiao(Integer menpiao)
	{
		this.menpiao = menpiao;
	}

	public String getJieshao()
	{
		return this.jieshao;
	}

	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}

	public String getFujian()
	{
		return this.fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}