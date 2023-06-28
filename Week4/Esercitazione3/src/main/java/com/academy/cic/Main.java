package com.academy.cic;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Dao dao = new Dao();
		
		Student student1 = new Student();
		student1.setFirstName("Marco");
		student1.setLastName("Bianchi");
		student1.setAge(20);
        dao.insertStudent(student1);
        
        Course course1 = new Course();
        course1.setName("Matematica");
        dao.insertCourse(course1);
        
        Registration registration1 = new Registration();
        registration1.setCourse(course1);
        registration1.setStudent(student1);
        registration1.setGrade(3);
        dao.registryStudentCourse(registration1);
        
        List<Student> students=dao.findByNameSurname("Marco", "Bianchi");
        if(students!=null) {
        	 for (Student student : students) {
                 System.out.println(student);
             }
        }
        
        dao.updateCourseGradeById(registration1.getId(), 90);
        
        Double avg = dao.findAvgGradeByStudentId(student1.getId());
        System.out.println("Avg for student ID " + student1.getId() + ": " + avg);
        
        Student student = dao.findStudent(1);
        if (student != null) {
            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        }

	}

}
