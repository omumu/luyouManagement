package com.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.dao.TDingcaiDAO;
import com.dao.TGoodsDAO;
import com.dao.TJiudianDAO;
import com.dao.TKefangDAO;
import com.model.TDingcai;
import com.model.TGoods;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class dingcaiAction extends ActionSupport
{
	private Integer id;
	private Integer goodsId;
	private String shuliang;
	private String xingming;
	
	
	private String lianxi;
	private String dizhi;
	private Integer userId;
	
	private TDingcaiDAO dingcaiDAO;
	private TGoodsDAO goodsDAO;
	private TJiudianDAO jiudianDAO;
	
	
	public String dingcaiAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TDingcai dingcai=new TDingcai();
		
		//dingcai.setId(id);
		dingcai.setGoodsId(goodsId);
		dingcai.setShuliang(shuliang);
		dingcai.setXingming(xingming);
		
		dingcai.setLianxi(lianxi);
		dingcai.setDizhi(dizhi);
		dingcai.setUserId(user.getUserId());
			
		dingcaiDAO.save(dingcai);
		
		request.put("msg", "������Ϣ��ӳɹ������ǻἰʱ����");
		
		return "msg";
	}
	
	
	public String dingcaiMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TDingcai where userId="+user.getUserId();
		List dingcaiList=dingcaiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<dingcaiList.size();i++)
		{
			TDingcai dingcai=(TDingcai)dingcaiList.get(i);
			TGoods goods = goodsDAO.findById(dingcai.getGoodsId());
			dingcai.setGoods(goods);
			dingcai.setJiudian(jiudianDAO.findById(goods.getJiudianId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingcaiList", dingcaiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String dingcaiDel()
	{
		
		TDingcai dingcai=dingcaiDAO.findById(id);
		dingcaiDAO.delete(dingcai);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "��Ϣɾ���ɹ�");
		return "msg";
	}
	
	public String dingcaiMana()
	{
		String sql="from TDingcai";
		List dingcaiList=dingcaiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<dingcaiList.size();i++)
		{
			TDingcai dingcai=(TDingcai)dingcaiList.get(i);
			dingcai.setGoods(goodsDAO.findById(dingcai.getGoodsId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("dingcaiList", dingcaiList);
		return ActionSupport.SUCCESS;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public Integer getGoodsId()
	{
		return goodsId;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}


	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}


	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}


	public String getShuliang()
	{
		return shuliang;
	}


	public void setShuliang(String shuliang)
	{
		this.shuliang = shuliang;
	}


	public String getXingming()
	{
		return xingming;
	}


	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}


	public String getLianxi()
	{
		return lianxi;
	}


	public void setLianxi(String lianxi)
	{
		this.lianxi = lianxi;
	}


	public String getDizhi()
	{
		return dizhi;
	}


	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}


	public TDingcaiDAO getDingcaiDAO()
	{
		return dingcaiDAO;
	}


	public void setDingcaiDAO(TDingcaiDAO dingcaiDAO)
	{
		this.dingcaiDAO = dingcaiDAO;
	}


	public TJiudianDAO getJiudianDAO() {
		return jiudianDAO;
	}


	public void setJiudianDAO(TJiudianDAO jiudianDAO) {
		this.jiudianDAO = jiudianDAO;
	}
	
	
	
}
