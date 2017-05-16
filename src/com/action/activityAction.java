package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TActivityDAO;
import com.dao.TEssayDAO;
import com.dao.TToupiaoDAO;
import com.model.TActivity;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class activityAction extends ActionSupport{

	private Integer id;
	private String kaishisj;
	private String jieshusj;
	private String zhuti;
	private String jieshao;
	private String jiangli;
	
	private TActivityDAO activityDAO;
	private TEssayDAO essayDAO;
	private TToupiaoDAO toupiaoDAO;
	
	// 分页
	private Integer page;

	public String activityAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TUser user=(TUser)session.getAttribute("user");
		
		TActivity activity=new TActivity();
		
		activity.setKaishisj(kaishisj);
		activity.setJieshusj(jieshusj);
		activity.setZhuti(zhuti);;
		activity.setJieshao(jieshao);
		activity.setJiangli(jiangli);

		activityDAO.save(activity);
		
		request.setAttribute("msg", "添加活动成功");
		return "msg";
	}
	
	
	public String activityMana()
	{
		String sql="from TActivity order by id";
		List activityList=activityDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("activityList", activityList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String activityDel()
	{
		TActivity activity=activityDAO.findById(id);
		activityDAO.delete(activity);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "删除成功");
		return "msg";
	}
	
	// 得到活动详情与参与者发布的信息
	public String activityDetail()
	{
		TActivity activity=activityDAO.findById(id);
		int offset = (page-1) * 10;
		List essayList = essayDAO.findByAcid(id, offset, 10);
		int count = essayDAO.getEssayCountByAcid(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("activity", activity);
		request.setAttribute("essayList", essayList);
		request.setAttribute("pageCount", Math.ceil(count/10));
		return ActionSupport.SUCCESS;
	}
	
	// 得到活动详情与参与者发布的信息
	public String activityDetailForUser()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TActivity AI =activityDAO.getTheFirstActivity();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date kaishisj = sdf.parse(AI.getKaishisj());
			Date jieshusj = sdf.parse(AI.getJieshusj());
			Date now = new Date();
			if (kaishisj.compareTo(now) > 0) {
				request.setAttribute("msg", "活动未开始！<a href='/lsfxt'>点击回到主页</a>！");
				return "msg";
			}
			if (jieshusj.compareTo(now) < 0) {
				request.setAttribute("msg", "活动已经结束！<a href='/lsfxt'>点击回到主页</a>！");
				return "msg";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "出错了！<a href='/lsfxt'>点击回到主页</a>");
			return "msg";
		}
		int offset = (page-1) * 10;
		List essayList = essayDAO.findByAcid(AI.getId(), offset, 10);
		int count = essayDAO.getEssayCountByAcid(AI.getId());
		request.setAttribute("activity", AI);
		request.setAttribute("essayList", essayList);
		request.setAttribute("pageCount", Math.ceil(count/10));
		return ActionSupport.SUCCESS;
	}
	
	
	public String activityAll()
	{
		String sql="from TActivity order by liuyanshi";
		List activityList=activityDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("activityList", activityList);
		return ActionSupport.SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKaishisj() {
		return kaishisj;
	}

	public void setKaishisj(String kaishisj) {
		this.kaishisj = kaishisj;
	}

	public String getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(String jieshusj) {
		this.jieshusj = jieshusj;
	}

	public String getZhuti() {
		return zhuti;
	}

	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}

	public String getJieshao() {
		return jieshao;
	}

	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

	public String getJiangli() {
		return jiangli;
	}

	public void setJiangli(String jiangli) {
		this.jiangli = jiangli;
	}

	public TActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(TActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public TEssayDAO getEssayDAO() {
		return essayDAO;
	}

	public void setEssayDAO(TEssayDAO essayDAO) {
		this.essayDAO = essayDAO;
	}

	public TToupiaoDAO getToupiaoDAO() {
		return toupiaoDAO;
	}

	public void setToupiaoDAO(TToupiaoDAO toupiaoDAO) {
		this.toupiaoDAO = toupiaoDAO;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
