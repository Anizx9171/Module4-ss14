package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import com.ra.utils.ConnectionDatabase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection connection = ConnectionDatabase.openConnection();
        List<Category> categories = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{CALL proc_show_list_category()}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        Connection connection = ConnectionDatabase.openConnection();
        int countChange = 0;
        try {
            if (category.getCategoryId() == 0) {
                CallableStatement statement = connection.prepareCall("{CALL proc_add_category(?,?)}");
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.isCategoryStatus());
                countChange = statement.executeUpdate();
            } else {
                CallableStatement statement = connection.prepareCall("{CALL proc_update_category(?,?,?)}");
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.isCategoryStatus());
                statement.setInt(3, category.getCategoryId());
                countChange = statement.executeUpdate();
            }
            if (countChange > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
