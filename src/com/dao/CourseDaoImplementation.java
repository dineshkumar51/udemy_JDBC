package com.dao;

import com.model.Course;
import com.util.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImplementation implements CourseDao
{
   private static Connection con = MysqlConnection.getConnection();

    @Override
    public int add(Course course) throws SQLException
    {
        String query = "INSERT INTO course(name, instructor_id, topic_id) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,course.getName());
        ps.setInt(2,course.getInstructorId());
        ps.setInt(3,course.getTopicId());
        int n = ps.executeUpdate();
        ps.close();
        return n;

    }

    @Override
    public void update(Course course) throws SQLException {

        String query = "UPDATE course"+
                " SET name = ?, instructor_id = ?, topic_id = ?,rating = ?,no_of_ratings = ?, no_of_enrolled_students = ?"+
                " WHERE course_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,course.getName());
        ps.setInt(2,course.getInstructorId());
        ps.setInt(3,course.getTopicId());
        ps.setFloat(4,course.getRating());
        ps.setInt(5,course.getNoOfRatings());
        ps.setInt(6,course.getNoOfEnrolledStudents());
        ps.setInt(7,course.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Course getCourse(int course_id) throws SQLException
    {
        String query = "SELECT * FROM course WHERE course_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,course_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Course course= new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7));
        rs.close();
        ps.close();
        return course;
    }

    @Override
    public List<Course> getCourses() throws SQLException {
        String query = "SELECT * FROM course";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Course> courses = new ArrayList<>();
        while(rs.next())
        {
            Course course= new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7));
            courses.add(course);
        }
        rs.close();
        ps.close();
        return courses;
    }

    @Override
    public List<Course> getCoursesCreatedBy(int instructor_id) throws SQLException {
        String query = "SELECT * FROM course WHERE instructor_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,instructor_id);
        ResultSet rs = ps.executeQuery();
        List<Course> courses = new ArrayList<>();
        while(rs.next())
        {
            Course course= new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7));
            courses.add(course);
        }
        rs.close();
        ps.close();
        return courses;
    }

    @Override
    public List<Course> getCoursesUnder(int topic_id) throws SQLException {
        String query = "SELECT * FROM course WHERE topic_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,topic_id);
        ResultSet rs = ps.executeQuery();
        List<Course> courses = new ArrayList<>();
        while(rs.next())
        {
            Course course= new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7));
            courses.add(course);
        }
        rs.close();
        ps.close();
        return courses;
    }
}
