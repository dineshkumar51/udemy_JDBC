package com.dao;

import com.model.Instructor;
import com.model.User;
import com.util.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDao
{
    private static Connection con = MysqlConnection.getConnection();

    @Override
    public int add(User user, String type)
    {
        String query = String.format("INSERT INTO %s (username, password, full_name, created_date) "+
                        "VALUES (?,?,?,CURRENT_TIMESTAMP())",type);
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());
            n = ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return n;
    }

   @Override
    public void delete(int id,String type)
    {
        String query = String.format("DELETE FROM %s WHERE %s_id = ?",type,type);
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id, String type)
    {
        String query = String.format("SELECT * FROM %s WHERE %s_id = ?",type,type);
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            user = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUser(String userName, String type){
        String query = String.format("SELECT * FROM %s WHERE username = ?",type);
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            user = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUsers(String type)
    {
        String query = String.format("SELECT * FROM %s",type);
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                userList.add(user);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return userList;


    }

    @Override
    public void update(User user,String type)
    {
        String query = String.format("UPDATE %s "+
                "SET username = ?,password = ?,full_name = ? "+
                "WHERE %s_id = ?",type,type);
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
