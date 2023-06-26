package com.academy.cic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		Dao dao = new Dao();
		
		
		Student s1=new Student(1, "Stefano", "Bianchi", 20);
		Student s2=new Student(2, "Sara", "Vitagliano", 23);
		Student s3=new Student(3, "Filippo", "Rossi", 24);
		
	
		Course c1=new Course(1, "Course1");
		Course c2=new Course(2, "Course2");
		Course c3=new Course(3, "Course3");
		
		
		Registration reg1=new Registration(1, 1, s1, c1);
		Registration reg2=new Registration(2, 1, s2,c2);
		Registration reg3=new Registration(3, 1, s3,c3);
	
		
		dao.insertStudent(s1);
		dao.insertStudent(s2);
		dao.insertStudent(s3);
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		dao.insertCourse(c3);
		
		Student student=dao.selectByNameSurname("Sara", "Vitagliano");
		System.out.println(student);
		
		dao.updateCourseGradeById(1, 30);
		
		List<Course> courses = dao.findStudentCourses(1);
		if (courses != null) {
			for (Course c: courses)
				System.out.println(c);
		}
		
		List<StudentNumCourses> studentCountList = dao.findStudentIdNumCourses();
		if (studentCountList != null) {
			for (StudentNumCourses s: studentCountList)
				System.out.println(s.toStringId());
		}
		
		studentCountList = dao.findStudentDataNumCourses();
		if (studentCountList != null) {
			for (StudentNumCourses s: studentCountList)
				System.out.println(s.toString());
		}
		
	}

}
