package com.academy.cic;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;



public class Dao {

	private static final Logger logger = Logger.getLogger(Dao.class.getName());
	
	public void insertStudent(Student student) {
		logger.info("insertStudent");
        EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
       
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
	
	public void insertCourse(Course course) {
		logger.info("insertCourse");
		EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
		
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
	
	public void registryStudentCourse(Registration registration) {
		logger.info("registryStudentCourse");
		EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
		
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(registration);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
	
	public List<Student> findByNameSurname(String name, String surname) {
		logger.info("findByNameSurname");
		EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Student> students = null;
        try {
            TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByNameSurname", Student.class);
            query.setParameter("name", name);
            query.setParameter("surname", surname);
            students=query.getResultList();
        } catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return students;
    }
	
	public void updateCourseGradeById(int registrationId, int grade) {
		logger.info("updateCourseGradeById");
		EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Registration registration = entityManager.find(Registration.class, registrationId);
            registration.setGrade(grade);
            entityManager.getTransaction().begin();
            entityManager.merge(registration);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
            entityManager.close();
        }
    }
	
	public Double findAvgGradeByStudentId(int studentId) {
		logger.info("findAvgGradeByStudentId");
		EntityManager entityManager= JpaUtil.getEntityManagerFactory().createEntityManager();
		Double avg=null;
        try {
            TypedQuery<Double> query = entityManager.createNamedQuery("Registration.findAvgGradeByStudentId", Double.class);
            query.setParameter("studentId", studentId);
            avg=query.getSingleResult();
        } catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return avg;
    }
	
	public Student findStudent(int studentId) {
	    EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	    Student student=null;
	    try {
	    student = entityManager.find(Student.class, studentId);
	    
	    if (student != null) {
	        
	        student.getRegistrations().size(); 
	        
	        for (Registration registration : student.getRegistrations()) {
	            Course course = registration.getCourse();
	            int grade = registration.getGrade();
	            
	            System.out.println("Course: " + course.getName() + ", Grade: " + grade);
	        }
	    }}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
        } finally {
            entityManager.close();
        }
	    
	    entityManager.close();
	    return student;
	
}}
