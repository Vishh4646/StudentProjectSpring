package com.example.student.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Marks;
import com.example.student.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Student addStudent(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.save(student);
		return student;
	}

	@Override
	public Student getStudent(int rollNo) {
		Session session = entityManager.unwrap(Session.class);
		Student student = session.get(Student.class, rollNo);
		return student;
	}

	@Override
	public int addMarks(Marks marks, int rollNo) {
		Session session = entityManager.unwrap(Session.class);
		Student student = session.get(Student.class, rollNo);
		System.out.println(marks);
		session.saveOrUpdate(student);
		return rollNo;
	}

}
