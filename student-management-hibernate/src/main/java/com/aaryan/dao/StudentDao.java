package com.aaryan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aaryan.model.Student;
import com.aaryan.util.*;

public class StudentDao {
	
	public void saveStudent(Student student) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			
		}catch (Exception e) {
			if(transaction != null) transaction.rollback();
			e.printStackTrace();
		}		
	}
	
	public Student getStudent(int id) {
		
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
//		Eager fetching - gives detail in console
		return session.find(Student.class, id);
//		Lazy fetching - doesnot give detail in console
//		return session.byId(Student.class).load(id);
				
			}		
	}
	
	public List<Student> getAllStudents(){
		
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
		return session.createQuery("from Student", Student.class).list();
		
			}		
	}
	
	public void updateStudent(int id, String newName, String newEmail, String newCourse) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        
	        Student student = session.find(Student.class, id);
	        if (student != null) {
	            student.setName(newName);
	            student.setEmail(newEmail);
	            student.setCourse(newCourse);
	            session.merge(student);
	        }
	        
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	}
	
	public void deleteStudent(int id) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			Student student = session.find(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
			
		}catch (Exception e) {
			if(transaction != null) transaction.rollback();
			e.printStackTrace();
		}		
	}

}
