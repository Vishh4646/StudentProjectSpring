package com.example.student.dao;

import com.example.student.entity.Marks;
import com.example.student.entity.Student;

public interface StudentDAO {

	Student addStudent(Student student);

	Student getStudent(int rollNo);

	int addMarks(Marks marks, int rollNo);

}
