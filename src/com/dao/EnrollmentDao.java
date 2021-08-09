package com.dao;

import com.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface EnrollmentDao
{
    public List<Course> getEnrolledCourses(int learner_id) throws SQLException;
}
