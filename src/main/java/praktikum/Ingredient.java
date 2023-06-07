package praktikum;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {

    public static IngredientType type;
    public static String name;
    public static float price;

    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static void setType(IngredientType type) {
        Ingredient.type = type;
    }

    public static void setName(String name) {
        Ingredient.name = name;
    }

    public static void setPrice(float price) {
        Ingredient.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public IngredientType getType() {
        return type;
    }

}