package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYouji;

/**
 	* A data access object (DAO) providing persistence and search support for TYouji entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.model.TYouji
  * @author MyEclipse Persistence Tools 
 */

public class TYoujiDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(TYoujiDAO.class);
		//property constants
	public static final String BIAOTI = "biaoti";
	public static final String NEIRONG = "neirong";
	public static final String FABUSHI = "fabushi";
	public static final String USER_ID = "userId";



	protected void initDao() {
		//do nothing
	}
    
    public void save(TYouji transientInstance) {
        log.debug("saving TYouji instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TYouji persistentInstance) {
        log.debug("deleting TYouji instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TYouji findById( java.lang.Integer id) {
        log.debug("getting TYouji instance with id: " + id);
        try {
            TYouji instance = (TYouji) getHibernateTemplate()
                    .get("com.model.TYouji", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TYouji instance) {
        log.debug("finding TYouji instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TYouji instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TYouji as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBiaoti(Object biaoti
	) {
		return findByProperty(BIAOTI, biaoti
		);
	}
	
	public List findByNeirong(Object neirong
	) {
		return findByProperty(NEIRONG, neirong
		);
	}
	
	public List findByFabushi(Object fabushi
	) {
		return findByProperty(FABUSHI, fabushi
		);
	}
	
	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	

	public List findAll() {
		log.debug("finding all TYouji instances");
		try {
			String queryString = "from TYouji";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TYouji merge(TYouji detachedInstance) {
        log.debug("merging TYouji instance");
        try {
            TYouji result = (TYouji) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TYouji instance) {
        log.debug("attaching dirty TYouji instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TYouji instance) {
        log.debug("attaching clean TYouji instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TYoujiDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TYoujiDAO) ctx.getBean("TYoujiDAO");
	}
}