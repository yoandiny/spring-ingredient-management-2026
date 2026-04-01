package edu.hei.school.ingredients.repository;

import edu.hei.school.ingredients.config.DataSource;
import edu.hei.school.ingredients.entity.CategoryEnum;
import edu.hei.school.ingredients.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {
    Connection connection;

    public IngredientRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Ingredient> findAll() {
        List<Ingredient> Ingredients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                            select id, name, price, category from ingredient
                            """);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setName(resultSet.getString("name"));
                ingredient.setCategory(CategoryEnum.valueOf(resultSet.getString("category")));
                ingredient.setPrice(resultSet.getDouble("price"));
                Ingredients.add(ingredient);
            }
            return Ingredients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
