package com.dao;

import com.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao
{
    public int add(User user,String type)
            throws SQLException;
    public void delete(int id,String type)
            throws SQLException;
    public User getUser(int id, String type)
            throws SQLException;
    public List<User> getUsers(String type)
            throws SQLException;
    public void update(User user,String type)
            throws SQLException;
}
