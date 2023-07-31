import java.util.ArrayList;
import java.util.List;
class Recipe {
    private int id;
    private String title;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String author;

    public Recipe(int id, String title, String description, List<String> ingredients, String instructions, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.author = author;
    }

    public Recipe( String title, String description, List<String> ingredients, String instructions, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getAuthor() {
        return author;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}