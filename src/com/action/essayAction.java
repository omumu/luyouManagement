package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TEssayDAO;
import com.model.TEssay;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class essayAction extends ActionSupport{

	private Integer id;
	private String biaoti;
	private String neirong;
	private String fabusj;
	
	private Integer userId;
	private Integer acId;
	
	private TEssayDAO essayDAO;

	public String essayAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TUser user=(TUser)session.getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "未登录，请先<a href='/lsfxt'>登录</a>");
			return "msg";
		}
		
		TEssay essay=new TEssay();
		
		essay.setNeirong(neirong);
		essay.setBiaoti(biaoti);
		essay.setFabusj(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		essay.setUserId(user.getUserId());
		essay.setAcId(acId);

		essayDAO.save(essay);
		
		request.setAttribute("msg", "添加成功");
		return "msg";
	}
	
	
	public String essayMana()
	{
		String sql="from TEssay order by id";
		List essayList=essayDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("essayList", essayList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String essayDel()
	{
		TEssay essay=essayDAO.findById(id);
		essayDAO.delete(essay);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "删除成功");
		return "msg";
	}
	
	
	public String essayDetail()
	{
		TEssay essay=essayDAO.findById(id);
		System.out.println(acId);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("essay", essay);
		request.setAttribute("acId", acId);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String essayAll()
	{
		String sql="from TEssay order by liuyanshi";
		List essayList=essayDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("essayList", essayList);
		return ActionSupport.SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public String getFabusj() {
		return fabusj;
	}

	public void setFabusj(String fabusj) {
		this.fabusj = fabusj;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public TEssayDAO getEssayDAO() {
		return essayDAO;
	}

	public void setEssayDAO(TEssayDAO essayDAO) {
		this.essayDAO = essayDAO;
	}	
	
}
