package com.example.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.dao.StudentDAO;
import com.example.student.entity.Marks;
import com.example.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public Student addStudent(Student student) {
		Student addedStudent=studentDAO.addStudent(student);
		return addedStudent;
	}

	@Override
	@Transactional
	public Student getStudent(int rollNo) {
		
		return studentDAO.getStudent(rollNo);
	}

	@Override
	@Transactional
	public int addMarks(Marks marks, int rollNo) {
		// TODO Auto-generated method stub
		return studentDAO.addMarks(marks,rollNo);
	}

}
