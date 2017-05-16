package com.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.dao.TBinguanDAO;
import com.dao.TKefangDAO;
import com.model.TBinguan;
import com.model.TKefang;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class kefangAction extends ActionSupport
{
	private Integer id;
	private String kefangleixing;
	private String fangjianhao;
	private String area;
	
	private String jieshao;
	private String fujian;
	private Integer qianshu;
	
	private String del;
	private int binguanId;
	
	private TKefangDAO kefangDAO;
	private TBinguanDAO binguanDAO;
	
	
	
	public String kefangAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TKefang kefang=new TKefang();
		
		//kefang.setId(id);
		kefang.setKefangleixing(kefangleixing);
		kefang.setFangjianhao(fangjianhao);
		kefang.setArea(area);
		
		kefang.setJieshao(jieshao);
		kefang.setFujian(fujian);
		kefang.setQianshu(qianshu);
		
		kefang.setDel("no");
		kefang.setBinguanId(binguanId);
			
		kefangDAO.save(kefang);
		request.put("msg", "�ͷ���Ϣ��ӳɹ�");
			
		return "msg";
	}
	
	public String kefangMana()
	{
		
		String sql="from TKefang where del='no' and binguanId="+binguanId;
		List kefangList=kefangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		TBinguan bg = binguanDAO.findById(binguanId);
		ServletActionContext.getContext().getSession().put("binguanmingcheng", bg.getMingcheng());
		request.put("kefangList", kefangList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String kefangDel()
	{
		
		TKefang kefang=kefangDAO.findById(id);
		kefang.setDel("yes");
		kefangDAO.attachDirty(kefang);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "�ͷ���Ϣɾ���ɹ�");
		return "msg";
	}
	
	
	
	public String kefangAll()
	{
		String sql="from TKefang where del='no' and binguanId="+binguanId;
		List kefangList=kefangDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kefangList", kefangList);
		return ActionSupport.SUCCESS;
	}
	

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getFangjianhao()
	{
		return fangjianhao;
	}

	public void setFangjianhao(String fangjianhao)
	{
		this.fangjianhao = fangjianhao;
	}

	public String getFujian()
	{
		return fujian;
	}

	public int getBinguanId()
	{
		return binguanId;
	}

	public void setBinguanId(int binguanId)
	{
		this.binguanId = binguanId;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setQianshu(Integer qianshu)
	{
		this.qianshu = qianshu;
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

	public TKefangDAO getKefangDAO()
	{
		return kefangDAO;
	}

	public void setKefangDAO(TKefangDAO kefangDAO)
	{
		this.kefangDAO = kefangDAO;
	}

	public TBinguanDAO getBinguanDAO() {
		return binguanDAO;
	}

	public void setBinguanDAO(TBinguanDAO binguanDAO) {
		this.binguanDAO = binguanDAO;
	}

	public int getQianshu()
	{
		return qianshu;
	}

	public void setQianshu(int qianshu)
	{
		this.qianshu = qianshu;
	}

	public String getKefangleixing()
	{
		return kefangleixing;
	}

	public void setKefangleixing(String kefangleixing)
	{
		this.kefangleixing = kefangleixing;
	}	
		
}
