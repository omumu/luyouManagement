package com.model;



/**
 * TYouji entity. @author MyEclipse Persistence Tools
 */

public class TYouji  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String biaoti;
     private String neirong;
     private String fabushi;
     
     
     private Integer userId;


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getBiaoti()
	{
		return biaoti;
	}


	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}


	public String getNeirong()
	{
		return neirong;
	}


	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}


	public String getFabushi()
	{
		return fabushi;
	}


	public void setFabushi(String fabushi)
	{
		this.fabushi = fabushi;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}


}