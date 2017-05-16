package com.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.dao.TXianluDAO;
import com.model.TXianlu;
import com.opensymphony.xwork2.ActionSupport;

public class xianluAction extends ActionSupport
{
	private int id;
	private String xianlumincheng;
	private String fatuandidian;
	private String fatuanshiian;
	private String xianlujiage;
	private String lianxidianhua;
	private String lianxiren;
	private String fabushijian;
	
	private String message;
	private String path;
	
	private TXianluDAO xianluDAO;
	
	public String xianluAdd()
	{
		TXianlu xianlu=new TXianlu();
		
		xianlu.setXianlumincheng(xianlumincheng);
		xianlu.setFatuandidian(fatuandidian);
		xianlu.setFatuanshiian(fatuanshiian);
		xianlu.setXianlujiage(xianlujiage);
		xianlu.setLianxidianhua(lianxidianhua);
		xianlu.setLianxiren(lianxiren);
		xianlu.setFabushijian(fabushijian);
		xianlu.setDel("no");
		
		xianluDAO.save(xianlu);
		this.setMessage("操作成功");
		this.setPath("xianluMana.action");
		return "succeed";
	}
	
	
	public String xianluMana()
	{
		List xianluList =xianluDAO.getHibernateTemplate().find("from TXianlu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xianluList", xianluList);
		return ActionSupport.SUCCESS;
	}
	
	public String xianluDel()
	{
		TXianlu xianlu=xianluDAO.findById(id);
		xianlu.setDel("yes");
		xianluDAO.getHibernateTemplate().update(xianlu);
		this.setMessage("操作成功");
		this.setPath("xianluMana.action");
		return "succeed";
	}
	
	
	
	
	public String xianluAll()
	{
		List xianluList =xianluDAO.getHibernateTemplate().find("from TXianlu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xianluList", xianluList);
		return ActionSupport.SUCCESS;
	}
	
	public String xianluDetailQian()
	{
		TXianlu xianlu=xianluDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xianlu", xianlu);
		return ActionSupport.SUCCESS;
	}
	
	public String xianluRes()
	{
		List xianluList =xianluDAO.getHibernateTemplate().find("from TXianlu where del='no' and xianlumincheng like '%"+xianlumincheng.trim()+"%'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xianluList", xianluList);
		return ActionSupport.SUCCESS;
	}
	

	public String getFatuandidian()
	{
		return fatuandidian;
	}



	public String getFabushijian()
	{
		return fabushijian;
	}



	public void setFabushijian(String fabushijian)
	{
		this.fabushijian = fabushijian;
	}


	public void setFatuandidian(String fatuandidian)
	{
		this.fatuandidian = fatuandidian;
	}


	public String getFatuanshiian()
	{
		return fatuanshiian;
	}


	public void setFatuanshiian(String fatuanshiian)
	{
		this.fatuanshiian = fatuanshiian;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getLianxidianhua()
	{
		return lianxidianhua;
	}


	public void setLianxidianhua(String lianxidianhua)
	{
		this.lianxidianhua = lianxidianhua;
	}


	public String getLianxiren()
	{
		return lianxiren;
	}


	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public TXianluDAO getXianluDAO()
	{
		return xianluDAO;
	}


	public void setXianluDAO(TXianluDAO xianluDAO)
	{
		this.xianluDAO = xianluDAO;
	}


	public String getXianlujiage()
	{
		return xianlujiage;
	}


	public void setXianlujiage(String xianlujiage)
	{
		this.xianlujiage = xianlujiage;
	}

	public String getXianlumincheng()
	{
		return xianlumincheng;
	}


	public void setXianlumincheng(String xianlumincheng)
	{
		this.xianlumincheng = xianlumincheng;
	}
	
}
