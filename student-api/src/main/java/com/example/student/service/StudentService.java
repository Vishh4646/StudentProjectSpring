package com.example.student.service;

import com.example.student.entity.Marks;
import com.example.student.entity.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student getStudent(int rollNo);

	int addMarks(Marks marks, int rollNo);

}
