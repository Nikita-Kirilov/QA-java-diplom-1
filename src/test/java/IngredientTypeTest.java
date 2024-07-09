import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredients;

    public IngredientTypeTest(String ingredients) {
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void getEnumValuesTest() {
        IngredientType ingredientType = null;
        String ingredientTypeActual = ingredientType.valueOf(ingredients).toString();
        Assert.assertEquals(ingredients,ingredientTypeActual);

    }
}
