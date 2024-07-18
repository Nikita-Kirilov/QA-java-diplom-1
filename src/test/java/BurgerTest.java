import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final float DELTA_FOR_ASSERT = 0;
    @Mock
    Bun bunMcok = new Bun("Carrot", 50.50f);

    @Mock
    IngredientType ingredientType;
    @Mock
    Ingredient ingredient = new Ingredient(ingredientType, "Peach", 50.50f);

    @Spy
    Burger burgerSpy;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMcok);
        Assert.assertEquals(bunMcok,burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        int index = 0;
        burger.removeIngredient(index);
        Assert.assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        int index = 1;
        int newIndex = 1;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(index,newIndex);
        Assert.assertEquals(0,burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bunMcok.getPrice()).thenReturn(50.50f);
        Mockito.when(ingredient.getPrice()).thenReturn(50.50f);
        burger.bun = bunMcok;
        burger.ingredients.add(ingredient);
        float priceActual = burger.getPrice();
        float priceExpected = bunMcok.getPrice() * 2 + ingredient.getPrice();
        Assert.assertEquals(priceExpected,priceActual,DELTA_FOR_ASSERT);
    }

    @Test
    public void getReceiptTest() {
        float priceExp = 0.0f;
        Mockito.when(bunMcok.getName()).thenReturn("Carrot");
        Mockito.when(ingredient.getName()).thenReturn("Watermelon");
        Mockito.when(ingredient.getType()).thenReturn(ingredientType.SAUCE);

        StringBuilder receiptExpected = new StringBuilder(String.format("(==== %s ====)%n", bunMcok.getName()));
        receiptExpected.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        receiptExpected.append(String.format("(==== %s ====)%n", bunMcok.getName()));
        receiptExpected.append(String.format("%nPrice: %f%n", priceExp));
        String receiptExpectedToString = receiptExpected.toString();

        Mockito.when(bunMcok.getName()).thenReturn("Carrot");
        Mockito.when(ingredient.getName()).thenReturn("Watermelon");
        Mockito.when(ingredient.getType()).thenReturn(ingredientType.SAUCE);
        burgerSpy.bun = bunMcok;
        burgerSpy.ingredients.add(ingredient);
        String receiptActual= burgerSpy.getReceipt();
        Assert.assertEquals(receiptExpectedToString,receiptActual);
        Mockito.verify(burgerSpy, Mockito.times(1)).getPrice();
    }

}
