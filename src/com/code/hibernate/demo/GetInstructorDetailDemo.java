package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Instructor;
import com.code.hibernate.entity.InstructorDetail;
import com.code.hibernate.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					
					//start transaction
					session.beginTransaction();
					
					// get the instructor detail id
					int theId = 1;
					InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);
					
					// print the instructor detail
					System.out.println("the instructorDetail: " + instructorDetail);
					
					// print the associated instructor
					System.out.println("the asssocieted instructor " + instructorDetail.getInstructor());
					// commit the transaction
					session.getTransaction().commit();
				}finally{
					factory.close();
				}

	}

}
