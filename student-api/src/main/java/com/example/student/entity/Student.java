package com.example.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="student")

public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roll_no")
	private int rollNo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="class_name")
	private String className;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="marks_id")
	private Marks marks;
	
	public Student() {}

	public Student(String name, String gender, String email, String className) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.className = className;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
	     this.marks=marks;
	   
	
	}

	public void setMarkObject(Marks marks2) {
		if(this.marks==null) {
			this.marks=new Marks();
		}
		this.setMarks(marks2);
		
	}


	
	
	
	
	
}
