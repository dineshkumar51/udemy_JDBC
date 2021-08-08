package com.model;

import java.util.Objects;

public class Course
{
    private int id;
    private String name;
    private int instructorId;
    private int topicId;
    private float rating;
    private int noOfRatings;
    private int noOfEnrolledStudents;

    public Course(int id, String name, int instructorId, int topicId, float rating, int noOfRatings, int noOfEnrolledStudents) {
        this.id = id;
        this.name = name;
        this.instructorId = instructorId;
        this.topicId = topicId;
        this.rating = rating;
        this.noOfRatings = noOfRatings;
        this.noOfEnrolledStudents = noOfEnrolledStudents;
    }

    public Course(String name, int instructorId, int topicId, float rating, int noOfRatings, int noOfEnrolledStudents) {
        this.name = name;
        this.instructorId = instructorId;
        this.topicId = topicId;
        this.rating = rating;
        this.noOfRatings = noOfRatings;
        this.noOfEnrolledStudents = noOfEnrolledStudents;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNoOfRatings() {
        return noOfRatings;
    }

    public void setNoOfRatings(int noOfRatings) {
        this.noOfRatings = noOfRatings;
    }

    public int getNoOfEnrolledStudents() {
        return noOfEnrolledStudents;
    }

    public void setNoOfEnrolledStudents(int noOfEnrolledStudents) {
        this.noOfEnrolledStudents = noOfEnrolledStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructorId=" + instructorId +
                ", topicId=" + topicId +
                ", rating=" + rating +
                ", noOfRatings=" + noOfRatings +
                ", noOfEnrolledStudents=" + noOfEnrolledStudents +
                '}';
    }
}

