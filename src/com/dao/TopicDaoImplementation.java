package com.dao;

import com.model.Category;
import com.model.Topic;
import com.util.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImplementation implements TopicDao
{
    private Connection con = MysqlConnection.getConnection();

    @Override
    public List<Topic> getTopics() throws SQLException
    {
        String query = "SELECT * FROM topic";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Topic> topics = new ArrayList<>();
        while(rs.next())
        {
            Topic topic= new Topic(rs.getInt(1),rs.getString(2),rs.getInt(3));
            topics.add(topic);
        }
        return topics;
    }

    @Override
    public List<Topic> getTopics(int category_id) throws SQLException
    {
        String query = "SELECT * FROM topic WHERE category_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,category_id);
        ResultSet rs = ps.executeQuery();
        List<Topic> topics = new ArrayList<>();
        while(rs.next())
        {
            Topic topic= new Topic(rs.getInt(1),rs.getString(2),rs.getInt(3));
            topics.add(topic);
        }
        return topics;
    }
}
