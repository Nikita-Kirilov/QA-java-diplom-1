import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private String bunName = "Bulochka";
    private float bunPrice = 245.454f;
    @Test
    public void getNameTest() {

        Bun bun = new Bun(bunName,bunPrice);
        String actualBunName = bun.getName();
        Assert.assertEquals(bunName,actualBunName);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun(bunName,bunPrice);
        float actualBunPrice = bun.getPrice();
        Assert.assertEquals(bunPrice,actualBunPrice,0);
    }
}
