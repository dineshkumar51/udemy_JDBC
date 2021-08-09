package com.dao;

import com.model.Category;
import com.util.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplementation implements CategoryDao
{

    private static Connection con = MysqlConnection.getConnection();

    @Override
    public List<Category> getCategories() throws SQLException
    {
        String query = "SELECT * FROM category";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Category> categories = new ArrayList<>();
        while(rs.next())
        {
            Category category= new Category(rs.getInt(1),rs.getString(2));
            categories.add(category);
        }
        return categories;
    }
}
