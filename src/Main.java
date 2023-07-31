import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/recipe_sharing";
        String dbUser = "postgres";
        String dbPassword = "1234";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            RecipeRepository recipeRepository = new Data(connection);
            RecipeService recipeService = new RecipeService(recipeRepository);

            recipeService.createRecipe(
                    "Baursaq",
                    "Kazakh national bread dish.",
                    List.of("White flour, 2 eggs, milk or airan, baking powder, pinch of salt and pepper"),
                    "Mix ingredients together, leave the dough for an hour and more, cut it in little pieces of hand's size and fry each for 1 minute on each side of it.",
                    "Din"
            );

            List<Recipe> allRecipes = recipeService.getAllRecipes();
            for (Recipe recipe : allRecipes) {
                System.out.println("Recipe: " + recipe.getTitle());
                System.out.println("Description: " + recipe.getDescription());
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Instructions: " + recipe.getInstructions());
                System.out.println("Author: " + recipe.getAuthor());
                System.out.println();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}