
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;
    String expectedName;
    float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D3", 988, "Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255, "Краторная булка N-200i", 1255}
        };
    }
    @Test
    public void bunNameCorrect() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void bunPriceCorrect() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
