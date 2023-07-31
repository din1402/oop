public class VegetarianRecipe extends Recipe {
    private boolean isVegan;

    public VegetarianRecipe(String title, String description, List<String> ingredients, String instructions, String author, boolean isVegan) {
        super(title, description, ingredients, instructions, author);
        this.isVegan = isVegan;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String toString() {
        return super.toString() + " | Is Vegan: " + isVegan;
    }
}