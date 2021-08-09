package com.dao;

import com.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao
{
    public int add(User user,String type);

    public void delete(int id,String type);

    public User getUser(int id, String type);

    public User getUser(String userName, String type);

    public List<User> getUsers(String type);

    public void update(User user,String type);

}
