import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

public class IngredientTest {
    public IngredientType type = SAUCE;
    public String name = "hot sauce";
    public float price = 100;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void ingredientConstructorCorrect() {
        Ingredient ingredient1 = new Ingredient(type, name, price);
        IngredientType actualType = ingredient1.type;
        String actualName = ingredient1.name;
        float actualPrice = ingredient1.price;
    Assert.assertEquals(type, actualType);
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice, 0);

    }
    @Test
    public void getPriceCorrect() {
        float actualGetPriceMethodResult = ingredient.getPrice();
        float expectedGetPriceMethodResult = 100;
        Assert.assertEquals(expectedGetPriceMethodResult, actualGetPriceMethodResult, 0);
    }

    @Test
    public void getNameCorrect() {
        String actualGetNameMethodResult = ingredient.getName();
        String expectedGetNameMethodResult = "hot sauce";
        Assert.assertEquals(expectedGetNameMethodResult, actualGetNameMethodResult);
    }

    @Test
    public void getTypeCorrect() {
        IngredientType actualGetTypeMethodResult = ingredient.getType();
        IngredientType expectedGetTypeMethodResult = SAUCE;
        Assert.assertEquals(expectedGetTypeMethodResult, actualGetTypeMethodResult);
    }

}
