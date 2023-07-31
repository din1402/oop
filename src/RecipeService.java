import java.util.List;

class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void createRecipe(String title, String description, List<String> ingredients, String instructions, String author) {
        Recipe recipe = new Recipe(title, description, ingredients, instructions, author);
        recipeRepository.addRecipe(recipe);
    }

    public Recipe getRecipeByTitle(String title) {
        return recipeRepository.getRecipeByTitle(title);
    }

    public void updateRecipe(String oldTitle, String newTitle, String description, List<String> ingredients, String instructions, String author) {
        Recipe oldRecipe = recipeRepository.getRecipeByTitle(oldTitle);
        if (oldRecipe != null) {
            Recipe newRecipe = new Recipe(newTitle, description, ingredients, instructions, author);
            recipeRepository.updateRecipe(oldRecipe, newRecipe);
        }
    }

    public void deleteRecipe(String title) {
        Recipe recipe = recipeRepository.getRecipeByTitle(title);
        if (recipe != null) {
            recipeRepository.deleteRecipe(recipe);
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
}