
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
    Burger burger = new Burger();
    Ingredient expectedIngredient = new Ingredient(SAUCE,"Соус Spicy-X", 90);
    Ingredient secondIngredient = new Ingredient(SAUCE,"Соус фирменный Space Sauce", 80);


    @Mock
    Burger burgerMock;
    @Test
    public void setBunsCorrect() {
        burger.setBuns(bun);
        Assert.assertEquals(Burger.bun, bun);
    }

    @Test
    public void addIngredientCorrect() {
        burger.addIngredient(expectedIngredient);
        Ingredient actualIngredientAdded = burger.ingredients.get(burger.ingredients.size() - 1);
        Assert.assertEquals(expectedIngredient, actualIngredientAdded);
    }

    @Test
    public void removeIngredientCorrect() {
        burger.addIngredient(expectedIngredient);
        int expectedSizeAfterRemove = burger.ingredients.size() - 1;
        burger.removeIngredient(burger.ingredients.size() - 1);
        int actualSizeAfterRemove = burger.ingredients.size();
        Assert.assertEquals(expectedSizeAfterRemove, actualSizeAfterRemove);
    }
    @Test
    public void moveIngredientCorrect() {
        burger.addIngredient(expectedIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        Assert.assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void getPriceCorrect() {
        burger.setBuns(new Bun("Краторная булка N-200i", 1255));
        burger.addIngredient(expectedIngredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = (1255*2 + 90);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
