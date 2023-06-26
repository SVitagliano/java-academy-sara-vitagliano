package com.academy.cic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class Dao {

	public void insertStudent(Student student) throws SQLException {
		String query = "INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME, AGE) VALUES (?, ?, ?, ?);";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, student.getId());
            pstm.setString(2, student.getFirst_name());
            pstm.setString(3, student.getLast_name());
            pstm.setInt(4, student.getAge());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	
	public void insertCourse(Course course) throws SQLException {
		String query = "INSERT INTO COURSE (ID, NAME) VALUES (?,?);";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, course.getId());
            pstm.setString(2, course.getName());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	
	
	public void registryStudentCourse(Registration registration) throws SQLException {
		String query = "INSERT INTO REGISTRATION (ID, STUDENT_ID, COURSE_ID) VALUES (?,?,?);";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, registration.getId());
            pstm.setInt(2, registration.getStudent().getId());
            pstm.setInt(3, registration.getCourse().getId());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	public Student selectByNameSurname(String name, String surname)throws SQLException {
		String query= "SELECT * FROM STUDENT WHERE FIRST_NAME = ? AND LAST_NAME = ?;";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	Student student=null;
    	
    	try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);
        	pstm.setString(1, name);
        	pstm.setString(2, surname);

            rs = pstm.executeQuery();

            student = new Student();
            if (rs.next()) {
                
                student.setId(rs.getInt("ID"));
                student.setFirst_name(rs.getString("FIRST_NAME"));
                student.setLast_name(rs.getString("LAST_NAME"));
                student.setAge(rs.getInt("AGE"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
        return student;
    	
    	
	}
	
	public void updateCourseGradeById(int registrationId, int grade) throws SQLException {
		String query= "UPDATE REGISTRATION SET GRADE=? WHERE ID=?;";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	
    	try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, grade);
            pstm.setInt(2, registrationId);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }}
    	
    	
	public List<Course> findStudentCourses(int studentId) throws SQLException {
    	String query = "SELECT C.ID, C.NAME FROM REGISTRATION R, COURSE C WHERE R.COURSE_ID = C.ID AND R.STUDENT_ID = ?";
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	List<Course> courses = null;
 
        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);
            pstm.setInt(1, studentId);

            rs = pstm.executeQuery();

            courses = new ArrayList<Course>();
            while (rs.next()) {
            	Course course = new Course();
            	course.setId(rs.getInt("ID"));
            	course.setName(rs.getString("NAME"));
            	courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
        return courses;
    }
    	
        
    	public List<StudentNumCourses> findStudentIdNumCourses() throws SQLException {
        	String query = "SELECT STUDENT_ID, COUNT(*) AS COURSE_COUNT FROM REGISTRATION GROUP BY STUDENT_ID";
        	
        	Connection conn = null;
        	PreparedStatement pstm = null;
        	ResultSet rs = null;
        	List<StudentNumCourses> studentCountList = null;
        	
            try {
            	conn = JdbcUtil.getConnection();
            	pstm = conn.prepareStatement(query);
                rs = pstm.executeQuery();

                studentCountList = new ArrayList<StudentNumCourses>();
                while (rs.next()) {
                	StudentNumCourses studentCount = new StudentNumCourses();
                	Student student = new Student();
                	student.setId(rs.getInt("STUDENT_ID"));
                	studentCount.setStudent(student);
                	studentCount.setCourseCount(rs.getInt("COURSE_COUNT"));
                	studentCountList.add(studentCount);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            	JdbcUtil.closeResultSet(rs);
            	JdbcUtil.closePreparedStatement(pstm);
            	JdbcUtil.closeConnection(conn);
            }
            return studentCountList;
        }
    	
	
	
    	public List<StudentNumCourses> findStudentDataNumCourses() throws SQLException {
        	String query = "SELECT S.ID, S.FIRST_NAME, S.LAST_NAME, S.AGE, COUNT(*) AS COURSE_COUNT "
        			+ "FROM REGISTRATION R INNER JOIN STUDENT S ON R.STUDENT_ID=S.ID GROUP BY R.STUDENT_ID";
       
        	Connection conn = null;
        	PreparedStatement pstm = null;
        	ResultSet rs = null;
        	List<StudentNumCourses> studentCountList = null;
        	
            try {
            	conn = JdbcUtil.getConnection();
            	pstm = conn.prepareStatement(query);
                rs = pstm.executeQuery();

                studentCountList = new ArrayList<StudentNumCourses>();
                while (rs.next()) {
                	StudentNumCourses studentCount = new StudentNumCourses();
                	Student student = new Student();
                	student.setId(rs.getInt("ID"));
                	student.setFirst_name(rs.getString("FIRST_NAME"));
                	student.setLast_name(rs.getString("LAST_NAME"));
                	student.setAge(rs.getInt("AGE"));
                	studentCount.setStudent(student);
                	studentCount.setCourseCount(rs.getInt("COURSE_COUNT"));
                	studentCountList.add(studentCount);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            	JdbcUtil.closeResultSet(rs);
            	JdbcUtil.closePreparedStatement(pstm);
            	JdbcUtil.closeConnection(conn);
            }
            return studentCountList;
        }
	
	
	
	
	
}
