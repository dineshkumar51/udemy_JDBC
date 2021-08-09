package com.dao;

import com.model.Course;
import com.util.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImplementation implements EnrollmentDao
{
    private static Connection con = MysqlConnection.getConnection();

    @Override
    public List<Course> getEnrolledCourses(int learner_id) throws SQLException
    {
        String query = "SELECT c.* FROM enrollments e INNER JOIN course c on e.course_id = c.course_id WHERE e.learner_id = ?";
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
}
