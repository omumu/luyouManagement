package com.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.dao.TBinguanDAO;
import com.dao.TKefangDAO;
import com.dao.TYudingDAO;
import com.model.TKefang;
import com.model.TUser;
import com.model.TYuding;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class yudingAction extends ActionSupport
{
	private Integer id;
	private Integer kefangId;
	private String riqi;
	private String kehuming;
	
	private String dianhua;
	private String beizhu;
	private Integer userId;
	private String zhuangtai;
	
	private TKefangDAO kefangDAO;
	private TYudingDAO yudingDAO;
	private TBinguanDAO binguanDAO;
	
	
	public String yudingAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TYuding where kefangId=? and riqi=?";
		Object[] c={kefangId,riqi};
		List list=yudingDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			request.put("msg", riqi+"您在这天已经预定了房间");
		}
		else
		{
			TYuding yuding=new TYuding();
			
			yuding.setId(id);
			yuding.setRiqi(riqi);
			yuding.setKefangId(kefangId);
			yuding.setKehuming(kehuming);
			
			yuding.setDianhua(dianhua);
			yuding.setBeizhu(beizhu);
			yuding.setUserId(user.getUserId());
				
			yudingDAO.save(yuding);
			
			request.put("msg", "预定成功");
		}
		
		return "msg";
	}
	
	
	public String yudingMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TYuding where userId="+user.getUserId();
		List yudingList=yudingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yudingList.size();i++)
		{
			TYuding yuding=(TYuding)yudingList.get(i);
			TKefang kf = kefangDAO.findById(yuding.getKefangId());
			yuding.setKefang(kf);
			yuding.setBinguan(binguanDAO.findById(kf.getBinguanId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yudingList", yudingList);
		return ActionSupport.SUCCESS;
	}
	
	public String yudingMana()
	{
		String sql="from TYuding where kefangId="+kefangId; 
		List yudingList=yudingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yudingList.size();i++)
		{
			TYuding yuding=(TYuding)yudingList.get(i);
			yuding.setKefang(kefangDAO.findById(yuding.getKefangId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yudingList", yudingList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yudingDel()
	{
		
		TYuding yuding=yudingDAO.findById(id);
		yudingDAO.delete(yuding);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "删除成功");
		return "msg";
	}
	public String yudingTY(){
		TYuding yd=yudingDAO.findById(id);
		yd.setZhuangtai("已确认");
		yudingDAO.attachDirty(yd);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "确认成功");
		return "msg";
	}
	

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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public TKefangDAO getKefangDAO()
	{
		return kefangDAO;
	}

	public void setKefangDAO(TKefangDAO kefangDAO)
	{
		this.kefangDAO = kefangDAO;
	}

	public Integer getKefangId()
	{
		return kefangId;
	}

	public void setKefangId(Integer kefangId)
	{
		this.kefangId = kefangId;
	}

	public String getKehuming()
	{
		return kehuming;
	}

	public void setKehuming(String kehuming)
	{
		this.kehuming = kehuming;
	}

	public TYudingDAO getYudingDAO()
	{
		return yudingDAO;
	}

	public void setYudingDAO(TYudingDAO yudingDAO)
	{
		this.yudingDAO = yudingDAO;
	}


	public String getRiqi()
	{
		return riqi;
	}


	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}


	public String getZhuangtai() {
		return zhuangtai;
	}


	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}


	public TBinguanDAO getBinguanDAO() {
		return binguanDAO;
	}


	public void setBinguanDAO(TBinguanDAO binguanDAO) {
		this.binguanDAO = binguanDAO;
	}

	
	
}
