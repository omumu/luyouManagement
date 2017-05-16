package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TJingdianDAO;
import com.model.TJingdian;
import com.opensymphony.xwork2.ActionSupport;

public class jingdianAction extends ActionSupport
{
	private int id;
	private String name;
	private String dizhi;
	private int menpiao;
	
	private String jieshao;
	private String fujian;
	
	private String message;
	private String path;
	
	private TJingdianDAO jingdianDAO;
	
	public String jingdianAdd()
	{
		TJingdian jingdian=new TJingdian();
		
		jingdian.setName(name);
		jingdian.setDizhi(dizhi);
		jingdian.setMenpiao(menpiao);
		jingdian.setJieshao(jieshao);
		jingdian.setFujian(fujian);
		jingdian.setDel("no");
		
		jingdianDAO.save(jingdian);
		this.setMessage("操作成功");
		this.setPath("jingdianMana.action");
		return "succeed";
	}
	
	
	public String jingdianMana()
	{
		List jingdianList =jingdianDAO.getHibernateTemplate().find("from TJingdian where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jingdianList", jingdianList);
		return ActionSupport.SUCCESS;
	}
	
	public String jingdianDel()
	{
		TJingdian jingdian=jingdianDAO.findById(id);
		jingdian.setDel("yes");
		jingdianDAO.getHibernateTemplate().update(jingdian);
		this.setMessage("操作成功");
		this.setPath("jingdianMana.action");
		return "succeed";
	}
	
	
	
	public String jingdianDetailHou()
	{
		TJingdian jingdian=jingdianDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jingdian", jingdian);
		return ActionSupport.SUCCESS;
	}
	

	public String jingdianAll()
	{
		List jingdianList =jingdianDAO.getHibernateTemplate().find("from TJingdian where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jingdianList", jingdianList);
		return ActionSupport.SUCCESS;
	}
	
	public String jingdianDetailQian()
	{
		TJingdian jingdian=jingdianDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jingdian", jingdian);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String jingdianRes()
	{
		String sql="from TJingdian where del='no' and name like '%"+name.trim()+"%'";
		List jingdianList =jingdianDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jingdianList", jingdianList);
		return ActionSupport.SUCCESS;
	}
	
	public String getDizhi()
	{
		return dizhi;
	}


	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}


	public String getFujian()
	{
		return fujian;
	}


	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getJieshao()
	{
		return jieshao;
	}


	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}


	public TJingdianDAO getJingdianDAO()
	{
		return jingdianDAO;
	}


	public void setJingdianDAO(TJingdianDAO jingdianDAO)
	{
		this.jingdianDAO = jingdianDAO;
	}


	public int getMenpiao()
	{
		return menpiao;
	}


	public void setMenpiao(int menpiao)
	{
		this.menpiao = menpiao;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}
	
}
