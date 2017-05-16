package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TActivity;

public class TActivityDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TActivityDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TActivity transientInstance)
	{
		log.debug("saving TActivity instance");
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

	public void delete(TActivity persistentInstance)
	{
		log.debug("deleting TActivity instance");
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

	public TActivity findById(java.lang.Integer id)
	{
		log.debug("getting TActivity instance with id: " + id);
		try
		{
			TActivity instance = (TActivity) getHibernateTemplate().get(
					"com.model.TActivity", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public TActivity getTheFirstActivity()
	{
		log.debug("getting TActivity_id: ");
		try
		{
			String hql = "from TActivity order by id desc limit 1";
			List temp = getHibernateTemplate().find(hql);
			System.out.println(temp.size());
			if (temp.size() >= 1) {
				TActivity AI =  (TActivity) temp.get(0); 
				System.out.println("最新的活动id"+AI.getId());
				
				return AI;
			} else {
				log.debug("没有查询到最新活动");
				return null;
			}
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(TActivity instance)
	{
		log.debug("finding TActivity instance by example");
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
		log.debug("finding TActivity instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TActivity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TActivity instances");
		try
		{
			String queryString = "from TActivity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TActivity merge(TActivity detachedInstance)
	{
		log.debug("merging TActivity instance");
		try
		{
			TActivity result = (TActivity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TActivity instance)
	{
		log.debug("attaching dirty TActivity instance");
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

	public void attachClean(TActivity instance)
	{
		log.debug("attaching clean TActivity instance");
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

	public static TActivityDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TActivityDAO) ctx.getBean("TActivityDAO");
	}
}
