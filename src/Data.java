import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Data implements RecipeRepository {
    private final Connection connection;

    public Data(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (title, description, ingredients, instructions, author) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, recipe.getTitle());
            statement.setString(2, recipe.getDescription());
            statement.setString(3, String.join(", ", recipe.getIngredients()));
            statement.setString(4, recipe.getInstructions());
            statement.setString(5, recipe.getAuthor());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Recipe getRecipeByTitle(String title) {
        String sql = "SELECT * FROM recipes WHERE title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createRecipeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateRecipe(Recipe oldRecipe, Recipe newRecipe) {
        String sql = "UPDATE recipes SET title = ?, description = ?, ingredients = ?, instructions = ?, author = ? " +
                "WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newRecipe.getTitle());
            statement.setString(2, newRecipe.getDescription());
            statement.setString(3, String.join(", ", newRecipe.getIngredients()));
            statement.setString(4, newRecipe.getInstructions());
            statement.setString(5, newRecipe.getAuthor());
            statement.setInt(6, oldRecipe.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        String sql = "DELETE FROM recipes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT * FROM recipes";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                recipes.add(createRecipeFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    private Recipe createRecipeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String[] ingredients = resultSet.getString("ingredients").split(", ");
        String instructions = resultSet.getString("instructions");
        String author = resultSet.getString("author");

        return new Recipe( id, title, description, List.of(ingredients), instructions, author);
    }
}
