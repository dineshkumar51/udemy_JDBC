package com.dao;

import com.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao
{
    public int add(Course course) throws SQLException;
    public void update(Course course) throws SQLException;
    public Course getCourse(int course_id) throws SQLException;
    public List<Course> getCourses() throws SQLException;
    public List<Course> getCoursesCreatedBy(int instructor_id) throws SQLException;
    public List<Course> getCoursesUnder(int topic_id) throws SQLException;
}
