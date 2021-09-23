package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entitymanager = null;
	
	public CourseService() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("SMS");
		this.entitymanager = this.entityManagerFactory.createEntityManager();
	}
	
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		// This method takes no parameter and returns every Course in the table.
	
		String sql = "SELECT c FROM Course c";
		TypedQuery<Course> query = entitymanager.createQuery(sql, Course.class);
		List<Course> courses = query.getResultList();

		return courses;
	}
}
