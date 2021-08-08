package com.dao;

import com.model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao
{
    public List<Topic> getTopics() throws SQLException;
    public List<Topic> getTopics(int category_id) throws SQLException;
}
