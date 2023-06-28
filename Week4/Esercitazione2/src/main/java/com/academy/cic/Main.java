package com.academy.cic;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
Dao dao = new Dao();
        
    
        Course course = new Course(1, "Course A", new Date(), new Date(), new HashSet<Module>());
        Integer courseId = dao.insertCourse(course);
        System.out.println("Inserted course ID: " + courseId);
        
        Course foundCourse = dao.findCourseByName("Course A");
        System.out.println("Found course: " + foundCourse);
        
        Module module = new Module(1, "Module 1", "Sara", foundCourse);
        dao.addModuleToCourse(module, courseId);
        System.out.println("Module added to course");
        
        Set<Module> modules = dao.findCourseModules(courseId);
        System.out.println("Modules of the course:");
        for (Module m : modules) {
            System.out.println(m);
        }
        
        Date newStartDate = new Date();
        dao.updateStartDate(newStartDate, courseId);
        System.out.println("Start date updated for course ID: " + courseId);
        
        dao.deleteCourse(courseId);
        System.out.println("Course deleted with ID: " + courseId);
    }

}
