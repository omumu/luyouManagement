package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBaomingDAO;
import com.dao.TXianluDAO;
import com.model.TBaoming;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class baomingAction extends ActionSupport
{
	private Integer id;
	private Integer xianluId;
	private Integer userId;
	private String lianxifangshi;
	
	private String beizhu;
	private String baomingshi;
	private String zhuangtai;
	
	private TBaomingDAO baomingDAO;
	private TXianluDAO xianluDAO;
	
	
	public String baomingAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TBaoming baoming=new TBaoming();
		
		//baoming.setId(0);
		baoming.setXianluId(xianluId);
		baoming.setUserId(user.getUserId());
		baoming.setLianxifangshi(lianxifangshi);
		
		baoming.setBeizhu(beizhu);
		baoming.setBaomingshi(baomingshi);
		
		baomingDAO.save(baoming);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "�ɹ�����");
		
		return "msg";
	}
	
	public String baomingMana()
	{
		String sql = "from TBaoming where xianluId="+xianluId;
		List baomingList=baomingDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("baomingList", baomingList);
		return ActionSupport.SUCCESS;
	}	
	
	public String baomingDel()
	{
		TBaoming baoming=baomingDAO.findById(id);
		baomingDAO.delete(baoming);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "��Ϣɾ���ɹ�");
		return "msg";
	}
	
	
	public String baomingMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql = "from TBaoming where userId="+user.getUserId();
		List baomingList=baomingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<baomingList.size();i++)
		{
			TBaoming baoming=(TBaoming)baomingList.get(i);
			baoming.setXianlu(xianluDAO.findById(baoming.getXianluId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("baomingList", baomingList);
		return ActionSupport.SUCCESS;
	}	
	
	public String baomingTY(){
		TBaoming bm=baomingDAO.findById(id);
		bm.setZhuangtai("已确认");
		baomingDAO.attachDirty(bm);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "确认成功");
		return "msg";
	}
	

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

	public TXianluDAO getXianluDAO()
	{
		return xianluDAO;
	}

	public void setXianluDAO(TXianluDAO xianluDAO)
	{
		this.xianluDAO = xianluDAO;
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

	public TBaomingDAO getBaomingDAO()
	{
		return baomingDAO;
	}

	public void setBaomingDAO(TBaomingDAO baomingDAO)
	{
		this.baomingDAO = baomingDAO;
	}
	
}
