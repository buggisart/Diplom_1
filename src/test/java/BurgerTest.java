import org.junit.After;
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
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient expectedIngredient;
    @Mock
    Ingredient secondIngredient;


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
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);
        burger.setBuns(bun);
        Mockito.when(expectedIngredient.getName()).thenReturn("cutlet");
        Mockito.when(expectedIngredient.getType()).thenReturn(FILLING);
        Mockito.when(expectedIngredient.getPrice()).thenReturn(100F);
        burger.addIngredient(expectedIngredient);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("%-19s%n%-18s%n%-19s%n%n%-17s%n",
                "(==== red bun ====)", "= filling cutlet =",
                "(==== red bun ====)","Price: 700.000000");
        Assert.assertEquals(expectedResult, actualResult);
    }
    @After
    public void cleanIngredientList() {
        burger.ingredients.clear();
    }
}