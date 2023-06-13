package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

    public float getMinBunPrice() {
        float minBunPrice = buns.get(0).getPrice();
        for (Bun bun : buns) {
           if (bun.getPrice() < minBunPrice) {
           minBunPrice = bun.getPrice();
           }
        }
        return  minBunPrice;
    }

    public float getMaxBunPrice() {
        float maxBunPrice = buns.get(0).getPrice();
        for (Bun bun : buns) {
            if (bun.getPrice() > maxBunPrice) {
                maxBunPrice = bun.getPrice();
            }
        }
        return  maxBunPrice;
    }

}