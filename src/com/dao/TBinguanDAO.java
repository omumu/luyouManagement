package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBinguan;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBinguan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TBinguan
 * @author MyEclipse Persistence Tools
 */

public class TBinguanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TBinguanDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String DIZHI = "dizhi";
	public static final String DIANHUA = "dianhua";
	public static final String JIESHAO = "jieshao";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TBinguan transientInstance)
	{
		log.debug("saving TBinguan instance");
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

	public void delete(TBinguan persistentInstance)
	{
		log.debug("deleting TBinguan instance");
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

	public TBinguan findById(java.lang.Integer id)
	{
		log.debug("getting TBinguan instance with id: " + id);
		try
		{
			TBinguan instance = (TBinguan) getHibernateTemplate().get(
					"com.model.TBinguan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBinguan instance)
	{
		log.debug("finding TBinguan instance by example");
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
		log.debug("finding TBinguan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TBinguan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByDizhi(Object dizhi)
	{
		return findByProperty(DIZHI, dizhi);
	}

	public List findByDianhua(Object dianhua)
	{
		return findByProperty(DIANHUA, dianhua);
	}

	public List findByJieshao(Object jieshao)
	{
		return findByProperty(JIESHAO, jieshao);
	}

	public List findAll()
	{
		log.debug("finding all TBinguan instances");
		try
		{
			String queryString = "from TBinguan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBinguan merge(TBinguan detachedInstance)
	{
		log.debug("merging TBinguan instance");
		try
		{
			TBinguan result = (TBinguan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBinguan instance)
	{
		log.debug("attaching dirty TBinguan instance");
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

	public void attachClean(TBinguan instance)
	{
		log.debug("attaching clean TBinguan instance");
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

	public static TBinguanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TBinguanDAO) ctx.getBean("TBinguanDAO");
	}
}