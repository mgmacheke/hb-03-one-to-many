package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Course;
import com.code.hibernate.entity.Instructor;
import com.code.hibernate.entity.InstructorDetail;
import com.code.hibernate.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					//start transaction
					session.beginTransaction();
					
					// get the instructor id
					int instructorId = 1;
					
					Instructor theInstructor = session.get(Instructor.class, instructorId);
					
					// create the courses
					Course tempCourse1 = new Course("Programming");
					Course tempCourse3 = new Course("ddNetworking");
					
					// save the courses into instructor
					theInstructor.add(tempCourse1);
					//theInstructor.add(tempCourse3); 
					theInstructor.add(tempCourse3);
					
					// save the course to the db
					session.save(tempCourse3);
					session.save(tempCourse1);
					
					
					// commit the transaction
					session.getTransaction().commit();
				}finally{
					session.close();
					
					factory.close();
				}

	}

}
