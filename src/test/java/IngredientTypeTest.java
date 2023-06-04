import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {


    IngredientType expectedIngredientType;

    String expectedString;

    public IngredientTypeTest(IngredientType expectedIngredientType, String expectedString) {
        this.expectedIngredientType = expectedIngredientType;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void ingredientTypeCorrect() {
       IngredientType actual = IngredientType.valueOf(expectedString);
       Assert.assertEquals(expectedIngredientType, actual);
    }

}
