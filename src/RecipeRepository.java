import java.util.List;

interface RecipeRepository {
    void addRecipe(Recipe recipe);
    Recipe getRecipeByTitle(String title);
    void updateRecipe(Recipe oldRecipe, Recipe newRecipe);
    void deleteRecipe(Recipe recipe);
    List<Recipe> getAllRecipes();
}

