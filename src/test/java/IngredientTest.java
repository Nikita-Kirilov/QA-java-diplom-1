import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    IngredientType ingredientType;

    private String ingredientName = "Carrot";
    private float ingredientPrice = 14.999f;
    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType,ingredientName,ingredientPrice);
        float ingredientPriceActual = ingredient.getPrice();
        Assert.assertEquals(ingredientPrice,ingredientPriceActual,0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType,ingredientName,ingredientPrice);
        String ingredientNameActual = ingredient.getName();
        Assert.assertEquals(ingredientName,ingredientNameActual);
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType,ingredientName,ingredientPrice);
        assertThat(ingredient.getType(), notNullValue());
    }
}
