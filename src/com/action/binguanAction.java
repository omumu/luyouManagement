package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBinguanDAO;
import com.model.TBinguan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class binguanAction extends ActionSupport
{
	private int id;
	private String mingcheng;
	private String dizhi;
	private String dianhua;
	
	private String message;
	private String path;
	
	private TBinguanDAO binguanDAO;
	
	public String binguanAdd()
	{
		TBinguan binguan=new TBinguan();
		
		binguan.setMingcheng(mingcheng);
		binguan.setDizhi(dizhi);
		binguan.setDianhua(dianhua);
		
		binguanDAO.save(binguan);
		this.setMessage("��Ϣ������");
		this.setPath("binguanMana.action");
		return "succeed";
	}
	
	
	public String binguanMana()
	{
		List binguanList =binguanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("binguanList", binguanList);
		return ActionSupport.SUCCESS;
	}
	
	public String binguanDel()
	{
		TBinguan binguan=binguanDAO.findById(id);
		binguanDAO.delete(binguan);
		this.setMessage("�͹���Ϣɾ�����");
		this.setPath("binguanMana.action");
		return "succeed";
	}
	
	
	
	public String binguanAll()
	{
		List binguanList =binguanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("binguanList", binguanList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String binguanDetailQian()
	{
		TBinguan binguan=binguanDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("binguan", binguan);
		
		return ActionSupport.SUCCESS;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMingcheng() {
		return mingcheng;
	}


	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}


	public String getDizhi() {
		return dizhi;
	}


	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}


	public String getDianhua() {
		return dianhua;
	}


	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}



	public TBinguanDAO getBinguanDAO()
	{
		return binguanDAO;
	}


	public void setBinguanDAO(TBinguanDAO binguanDAO)
	{
		this.binguanDAO = binguanDAO;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

	
}
