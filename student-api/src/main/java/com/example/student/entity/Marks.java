package com.example.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="marks")
@JsonIgnoreProperties(
		value= {"student"})
public class Marks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="c")
	private int C;
	
	@Column(name="cpp")
	private int CPP;
	
	@Column(name="java")
	private int Java;
	
	@Column(name="python")
	private int Python;
	
	@Column(name="dbms")
	private int DBMS;
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "marks")
	private Student student;
	
	public Marks() {}

	public Marks(int c, int cPP, int java, int python, int dBMS) {
		super();
		C = c;
		CPP = cPP;
		Java = java;
		Python = python;
		DBMS = dBMS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public int getCPP() {
		return CPP;
	}

	public void setCPP(int cPP) {
		CPP = cPP;
	}

	public int getJava() {
		return Java;
	}

	public void setJava(int java) {
		Java = java;
	}

	public int getPython() {
		return Python;
	}

	public void setPython(int python) {
		Python = python;
	}

	public int getDBMS() {
		return DBMS;
	}

	public void setDBMS(int dBMS) {
		DBMS = dBMS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", C=" + C + ", CPP=" + CPP + ", Java=" + Java + ", Python=" + Python + ", DBMS="
				+ DBMS + ", student=" + student + "]";
	}



	
	

}
