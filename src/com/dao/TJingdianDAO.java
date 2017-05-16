package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJingdian;

/**
 * Data access object (DAO) for domain model class TJingdian.
 * 
 * @see com.model.TJingdian
 * @author MyEclipse Persistence Tools
 */

public class TJingdianDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TJingdianDAO.class);

	// property constants
	public static final String NAME = "name";

	public static final String DIZHI = "dizhi";

	public static final String MENPIAO = "menpiao";

	public static final String JIESHAO = "jieshao";

	public static final String FUJIAN = "fujian";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TJingdian transientInstance)
	{
		log.debug("saving TJingdian instance");
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

	public void delete(TJingdian persistentInstance)
	{
		log.debug("deleting TJingdian instance");
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

	public TJingdian findById(java.lang.Integer id)
	{
		log.debug("getting TJingdian instance with id: " + id);
		try
		{
			TJingdian instance = (TJingdian) getHibernateTemplate().get(
					"com.model.TJingdian", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJingdian instance)
	{
		log.debug("finding TJingdian instance by example");
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
		log.debug("finding TJingdian instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TJingdian as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByDizhi(Object dizhi)
	{
		return findByProperty(DIZHI, dizhi);
	}

	public List findByMenpiao(Object menpiao)
	{
		return findByProperty(MENPIAO, menpiao);
	}

	public List findByJieshao(Object jieshao)
	{
		return findByProperty(JIESHAO, jieshao);
	}

	public List findByFujian(Object fujian)
	{
		return findByProperty(FUJIAN, fujian);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TJingdian instances");
		try
		{
			String queryString = "from TJingdian";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJingdian merge(TJingdian detachedInstance)
	{
		log.debug("merging TJingdian instance");
		try
		{
			TJingdian result = (TJingdian) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJingdian instance)
	{
		log.debug("attaching dirty TJingdian instance");
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

	public void attachClean(TJingdian instance)
	{
		log.debug("attaching clean TJingdian instance");
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

	public static TJingdianDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TJingdianDAO) ctx.getBean("TJingdianDAO");
	}
}