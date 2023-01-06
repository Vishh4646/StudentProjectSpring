package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Marks;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student ){
		student.setRollNo(0);
		Student addedStudent=studentService.addStudent(student);
		return new ResponseEntity<Student>(addedStudent,HttpStatus.OK);
		
	}
	
	@GetMapping("/student/{rollNo}")
	public ResponseEntity<?> getStudent(@PathVariable int rollNo){
		Student resp=studentService.getStudent(rollNo);
		if(resp==null) {
			return new ResponseEntity<String>("Not able to get student data",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Student>(resp,HttpStatus.OK);
	}
	
	@PostMapping("/student/add-marks/{rollNo}")
	public ResponseEntity<?> addMarks(@RequestBody Marks marks ,@PathVariable int rollNo){
	    int roll=studentService.addMarks(marks,rollNo);
		Student respStudent=studentService.getStudent(rollNo);
		
		if(respStudent.getMarks()==null) {
			return new ResponseEntity<String>("Could not add marks",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Student>(respStudent,HttpStatus.OK);
		
	}
}
