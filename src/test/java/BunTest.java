
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;
    String expectedName;
    float expectedPrice;

    private static Database database = new Database();
    private static float minBunPrice = database.getMinBunPrice();
    private static float maxBunPrice = database.getMaxBunPrice();


    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"red bun", maxBunPrice, "red bun", 300},
                {"black bun", minBunPrice, "black bun", 100},
                {"red bun", maxBunPrice + 1, "red bun", 301},
                {"black bun", minBunPrice - 1, "black bun", 99},
                {"black bun", minBunPrice + 1, "black bun", 101},
                {"red bun", maxBunPrice - 1, "red bun", 299},
                {"black bun", 0, "black bun", 0},
                {"white bun", -1, "white bun", -1},
                {"red bun", 0.001F, "red bun", 0.001F},
                {"", 150, "", 150},
                {"null", 150, "null", 150},
                {"true", 150, "true", 150},
                {"0", 150, "0", 150},
                {"~!@#$%^&*())_}{", 150, "~!@#$%^&*())_}{", 150},
                {"Кириллица", 150, "Кириллица", 150},
                {" ", 150, " ", 150},
                {"SELECT * from Users;", 150, "SELECT * from Users;", 150},
                {"<script>alert(1)</script>", 150, "<script>alert(1)</script>", 150},
                {"256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256sym",
                        150, "256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256symbols256sym", 150},

        };
    }
    @Test
    public void bunNameCorrect() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        System.out.println(bun.getName());
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void bunPriceCorrect() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
