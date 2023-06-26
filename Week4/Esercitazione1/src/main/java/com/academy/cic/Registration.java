package com.academy.cic;

public class Registration {

	private int id;
	private int grade;
	private Student student;
	private Course course;
	
	
	public Registration() {}


	public Registration(int id, int grade, Student student, Course course) {
		this.id = id;
		this.grade = grade;
		this.student = student;
		this.course = course;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Registration [id=" + id + ", grade=" + grade + ", student=" + student + ", course=" + course + "]";
	}
	
	
	
}
