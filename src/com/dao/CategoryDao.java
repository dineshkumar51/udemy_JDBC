package com.dao;

import com.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao
{
    public List<Category> getCategories() throws SQLException;

}
