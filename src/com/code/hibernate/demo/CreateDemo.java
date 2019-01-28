package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Instructor;
import com.code.hibernate.entity.InstructorDetail;
import com.code.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					// create the objects
					Instructor theInstructor = new Instructor("Musa", "Macheke", "Musa@codeWorld.com");
					InstructorDetail theInstructorDetail = new InstructorDetail("youtube","coding");
					
					// associate the objects
					theInstructor.setInstructoDetail(theInstructorDetail);
					
					//start transaction
					session.beginTransaction();
					
					// save the object
					session.save(theInstructor);
					
					// commit the transaction
					session.getTransaction().commit();
				}finally{
					factory.close();
				}

	}

}
