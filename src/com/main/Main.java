package com.main;

import com.dao.*;
import com.model.Category;
import com.model.Instructor;
import com.model.Learner;

public class Main {

    public static void main(String[] args) throws Exception
    {
        /*Instructor i = new Instructor(1,"dinesh@123","dine5151","Dinesh");
        Learner l = new Learner(3,"nan@1234","Nanthakumar1234","nant5151");
        UserDao userDao = new UserDaoImplementation();
        userDao.add(l,"learner");
        userDao.update(l,"learner");
        userDao.delete(3,"learner");
        System.out.println(userDao.getUsers("learner"));*/

        TopicDao top = new TopicDaoImplementation();
        CategoryDao cat = new CategoryDaoImplementation();

        System.out.println(top.getTopics());

    }
}
