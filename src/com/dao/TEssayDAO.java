package com.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TEssay;
/*活动参与者发布的文章model*/
public class TEssayDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TEssayDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TEssay transientInstance)
	{
		log.debug("saving TEssay instance");
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

	public void delete(TEssay persistentInstance)
	{
		log.debug("deleting TEssay instance");
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

	public TEssay findById(java.lang.Integer id)
	{
		log.debug("getting TEssay instance with id: " + id);
		try
		{
			TEssay instance = (TEssay) getHibernateTemplate().get(
					"com.model.TEssay", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByAcid(java.lang.Integer acid,final java.lang.Integer offset,final java.lang.Integer length)
	{
		log.debug("通过活动id得到分页的文章");
		try
		{
			final String hql = "select e.id as id,e.biaoti as biaoti, e.neirong as neirong,e.fabusj as fabusj,count(distinct t.userid) as piaoshu,u.user_name as zuozhe from t_essay e, t_toupiao t, t_user u where u.user_id=e.userid and t.eid=e.id and e.acid="+acid+" group by t.eid  order by piaoshu desc" ;
			List results = (List) getHibernateTemplate().execute(new HibernateCallback() {     
				public Object doInHibernate(Session session) throws HibernateException, SQLException {     
					Query query = session.createSQLQuery(hql);     
					query.setFirstResult(offset);     
					query.setMaxResults(length);     
					List list = query.list();     
					return list;     
				}     
			});
			log.debug("find by acid successful ");
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Integer getEssayCountByAcid(java.lang.Integer acid){
		log.debug("通过活动id得到文章总数");
		try
		{
			final String hql = "select count(distinct e.id) from t_essay e where e.acid="+acid;
			Integer results = null;
			
			BigInteger temp = (BigInteger) getHibernateTemplate().execute(new HibernateCallback() {     
				public Object doInHibernate(Session session) throws HibernateException, SQLException {     
					Query query = session.createSQLQuery(hql);     
					return query.uniqueResult();  
				}     
			});
			results = temp.intValue();
			log.debug("getCount by acid successful ");
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List findByExample(TEssay instance)
	{
		log.debug("finding TEssay instance by example");
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
		log.debug("finding TEssay instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TEssay as model where model."
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
		log.debug("finding all TEssay instances");
		try
		{
			String queryString = "from TEssay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TEssay merge(TEssay detachedInstance)
	{
		log.debug("merging TEssay instance");
		try
		{
			TEssay result = (TEssay) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TEssay instance)
	{
		log.debug("attaching dirty TEssay instance");
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

	public void attachClean(TEssay instance)
	{
		log.debug("attaching clean TEssay instance");
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

	public static TEssayDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TEssayDAO) ctx.getBean("TEssayDAO");
	}
}
