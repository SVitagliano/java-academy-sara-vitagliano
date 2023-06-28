package com.academy.cic;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Dao {

	private static final Logger logger = Logger.getLogger(Dao.class.getName());
	
	public Integer insertCourse(Course course) {
		logger.info("insertCourse");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer courseId = null;
        Transaction tx = null;
        try {
			tx = session.beginTransaction();
			session.persist(course); 
			courseId = (Integer) session.save(course);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
        return courseId;
    }
	
	public Course findCourseByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            String hql = "FROM Course c WHERE c.name = :name";
            TypedQuery<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
			session.close(); 
		}
        return null;
    }
	
	public void addModuleToCourse(Module module, int courseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
       Course course=null;
        try  {
            course = session.get(Course.class, courseId);
         if (course != null) {
            course.getModules().add(module);
            module.setCourse(course);
            session.saveOrUpdate(course);
        }}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
        
	}
	
	public Set<Module> findCourseModules(int courseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Set<Module> modules = null;
		try  {
            String hql = "SELECT m FROM Module m WHERE m.course.courseId = :courseId";
            TypedQuery<Module> query = session.createQuery(hql, Module.class);
            query.setParameter("courseId", courseId);
            
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
			session.close(); 
		}
        return modules;
	}
	
	public List<Course> findStartingCourseInRange(Date from, Date to) { 
		Session session = HibernateUtil.getSessionFactory().openSession();
	
        try {
            String hql = "FROM Course c WHERE c.startDate BETWEEN :fromDate AND :toDate";
            TypedQuery<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("fromDate", from);
            query.setParameter("toDate", to);
            return query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
			session.close(); 
		}
        return null;
}
	
	public void updateStartDate(Date startDate, int courseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try  {
            tx = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                course.setStart_date(startDate);
                session.saveOrUpdate(course);
            }
            
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
			session.close(); 
		}
    }
	
	public void deleteCourse(int courseId) { 
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction(); 
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
			session.close(); 
		}
    }

}

