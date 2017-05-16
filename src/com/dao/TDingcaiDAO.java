package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TDingcai;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDingcai entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TDingcai
 * @author MyEclipse Persistence Tools
 */

public class TDingcaiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TDingcaiDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SHULIANG = "shuliang";
	public static final String XINGMING = "xingming";
	public static final String LIANXI = "lianxi";
	public static final String DIZHI = "dizhi";
	public static final String USER_ID = "userId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TDingcai transientInstance)
	{
		log.debug("saving TDingcai instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDingcai persistentInstance)
	{
		log.debug("deleting TDingcai instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDingcai findById(java.lang.Integer id)
	{
		log.debug("getting TDingcai instance with id: " + id);
		try
		{
			TDingcai instance = (TDingcai) getHibernateTemplate().get(
					"com.model.TDingcai", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDingcai instance)
	{
		log.debug("finding TDingcai instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TDingcai instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TDingcai as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByShuliang(Object shuliang)
	{
		return findByProperty(SHULIANG, shuliang);
	}

	public List findByXingming(Object xingming)
	{
		return findByProperty(XINGMING, xingming);
	}

	public List findByLianxi(Object lianxi)
	{
		return findByProperty(LIANXI, lianxi);
	}

	public List findByDizhi(Object dizhi)
	{
		return findByProperty(DIZHI, dizhi);
	}

	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}

	public List findAll()
	{
		log.debug("finding all TDingcai instances");
		try
		{
			String queryString = "from TDingcai";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDingcai merge(TDingcai detachedInstance)
	{
		log.debug("merging TDingcai instance");
		try
		{
			TDingcai result = (TDingcai) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDingcai instance)
	{
		log.debug("attaching dirty TDingcai instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDingcai instance)
	{
		log.debug("attaching clean TDingcai instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDingcaiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TDingcaiDAO) ctx.getBean("TDingcaiDAO");
	}
}