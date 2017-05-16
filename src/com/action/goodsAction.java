package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TJiudianDAO;
import com.model.TGoods;
import com.model.TJiudian;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private Integer goodsId;
	private Integer jiudianId;
	private String goodsName;
	private String goodsMiaoshu;

	private String fujian;
	private Integer goodsShichangjia;
	private Integer goodsTejia;
	private String goodsIsnottejia;
	
	private String goodsDel;
	
	private String message;
	private String path;
	
	private TGoodsDAO goodsDAO;
	private TJiudianDAO jiudianDAO;
	
	
	public String goodsAdd()
	{
		TGoods goods=new TGoods();
		
		//goods.setGoodsId(0);
		goods.setJiudianId(jiudianId);
		goods.setGoodsName(goodsName);
		
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setFujian(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsShichangjia);
		
		goods.setGoodsIsnottejia("no");
		goods.setGoodsDel("no");
		
		goodsDAO.save(goods);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "��Ʒ�������");
		return "msg";
		
	}
	
	public String goodsMana()
	{
		String sql="from TGoods where goodsDel='no' and  jiudianId="+jiudianId;
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		TJiudian jd = jiudianDAO.findById(jiudianId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		ServletActionContext.getContext().getSession().put("jiudianmingcheng", jd.getMingcheng());
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDel()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "ɾ�����");
		return "msg";
	}
	
	
	
	
	
	
	
	public String goodsDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String goodsAll()
	{
		
		String sql="from TGoods where goodsDel='no' and jiudianId="+jiudianId;
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDetailQian()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public Integer getJiudianId()
	{
		return jiudianId;
	}

	public void setJiudianId(Integer jiudianId)
	{
		this.jiudianId = jiudianId;
	}

	public String getGoodsName()
	{
		return goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public String getGoodsMiaoshu()
	{
		return goodsMiaoshu;
	}

	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public Integer getGoodsShichangjia()
	{
		return goodsShichangjia;
	}

	public void setGoodsShichangjia(Integer goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}

	public Integer getGoodsTejia()
	{
		return goodsTejia;
	}

	public void setGoodsTejia(Integer goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}

	public String getGoodsIsnottejia()
	{
		return goodsIsnottejia;
	}

	public void setGoodsIsnottejia(String goodsIsnottejia)
	{
		this.goodsIsnottejia = goodsIsnottejia;
	}

	public String getGoodsDel()
	{
		return goodsDel;
	}

	public void setGoodsDel(String goodsDel)
	{
		this.goodsDel = goodsDel;
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

	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}

	public TJiudianDAO getJiudianDAO() {
		return jiudianDAO;
	}

	public void setJiudianDAO(TJiudianDAO jiudianDAO) {
		this.jiudianDAO = jiudianDAO;
	}
	
	
	
}
