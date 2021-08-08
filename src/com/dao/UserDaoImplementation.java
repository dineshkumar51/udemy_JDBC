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
    static Connection con = MysqlConnection.getConnection();

    @Override
    public int add(User user, String type) throws SQLException
    {
        String query = String.format("INSERT INTO %s (username, password, full_name, created_date) "+
                        "VALUES (?,?,?,CURRENT_TIMESTAMP())",type);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,user.getUserName());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getFullName());
        int n = ps.executeUpdate();
        ps.close();
        return n;
    }

   @Override
    public void delete(int id,String type) throws SQLException
    {
        String query = String.format("DELETE FROM %s WHERE %s_id = ?",type,type);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public User getUser(int id, String type) throws SQLException
    {
        String query = String.format("SELECT * FROM %s WHERE %s_id = ?",type,type);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new Instructor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
        rs.close();
        ps.close();
        return user;
    }

    @Override
    public List<User> getUsers(String type) throws SQLException
    {
        String query = String.format("SELECT * FROM %s",type);
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<>();
        while(rs.next())
        {
            User user= new Instructor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            userList.add(user);
        }
        rs.close();
        ps.close();
        return userList;
    }

    @Override
    public void update(User user,String type) throws SQLException
    {
        String query = String.format("UPDATE %s "+
                "SET username = ?,password = ?,full_name = ? "+
                "WHERE %s_id = ?",type,type);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,user.getUserName());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getFullName());
        ps.setInt(4,user.getId());
        ps.executeUpdate();
        ps.close();

    }
}
