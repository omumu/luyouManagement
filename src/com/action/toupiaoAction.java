package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TToupiaoDAO;
import com.model.TToupiao;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class toupiaoAction extends ActionSupport{
	
	private Integer id;
	private Integer userId;
	private Integer acId;
	private Integer eId;

	private TToupiaoDAO toupiaoDAO;
	
	public String toupiaoAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TUser user=(TUser)session.getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "未登录，请先<a href='/lsfxt'>登录</a>");
			return "msg";
		}
		TToupiao tp=new TToupiao();
		
		tp.setUserId(user.getUserId());
		tp.setAcId(acId);
		tp.seteId(eId);
		/*int count = toupiaoDAO.getCountByAcidAndUserId(acId, user.getUserId());
		if (count > 3) {
			request.setAttribute("msg",  "投票失败，一人只能在一次活动中投票三次，<a href='/lsfxt/activityDetailForUser.action?page=1'>点击返回</a>");
			return "msg";
		}*/
		toupiaoDAO.attachDirty(tp);
		
		request.setAttribute("msg", "投票成功，<a href='/lsfxt/activityDetailForUser.action?page=1'>点击返回</a>");
		return "msg";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public TToupiaoDAO getToupiaoDAO() {
		return toupiaoDAO;
	}

	public void setToupiaoDAO(TToupiaoDAO toupiaoDAO) {
		this.toupiaoDAO = toupiaoDAO;
	}
	
}
