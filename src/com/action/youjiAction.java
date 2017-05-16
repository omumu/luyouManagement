package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TYoujiDAO;
import com.model.TUser;
import com.model.TYouji;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class youjiAction extends ActionSupport
{
	private Integer id;
    private String biaoti;
    private String neirong;
    private String fabushi;
    
    private Integer userId;
	
	
	
	private TYoujiDAO youjiDAO;
	
	
	
	public String youjiAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TYouji youji=new TYouji();
		
		//youji.setId(id);
		youji.setBiaoti(biaoti);
		youji.setNeirong(neirong);
		youji.setFabushi(fabushi);
		
		youji.setUserId(user.getUserId());
		
		
		
		youjiDAO.save(youji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String youjiMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql = "from TYouji where userId="+user.getUserId();
		List youjiList=youjiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("youjiList", youjiList);
		return ActionSupport.SUCCESS;
	}	
	
	
	
	public String youjiDel()
	{
		TYouji youji=youjiDAO.findById(id);
		youjiDAO.delete(youji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String youjiMana()
	{
		String sql = "from TYouji order by fabushi desc";
		List youjiList=youjiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("youjiList", youjiList);
		return ActionSupport.SUCCESS;
	}	
	
	
	public String youjiAll()
	{
		String sql = "from TYouji order by fabushi desc";
		List youjiList=youjiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("youjiList", youjiList);
		return ActionSupport.SUCCESS;
	}	
	
	
	public String youjiDetailQian()
	{
		TYouji youji=youjiDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("youji", youji);
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

	public TYoujiDAO getYoujiDAO()
	{
		return youjiDAO;
	}

	public void setYoujiDAO(TYoujiDAO youjiDAO)
	{
		this.youjiDAO = youjiDAO;
	}

}
