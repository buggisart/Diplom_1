
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    Burger burger = new Burger();
    @Mock
    Ingredient expectedIngredient;

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
        Ingredient secondIngredient = new Ingredient(SAUCE,"Соус фирменный Space Sauce", 80);
        burger.addIngredient(expectedIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        Assert.assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void getPriceCorrect() {
        Mockito.when(bun.getPrice()).thenReturn(1255F);
        burger.setBuns(bun);
        Mockito.when(expectedIngredient.getPrice()).thenReturn(90F);
        burger.addIngredient(expectedIngredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = (1255*2 + 90);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {

    }
}

