import org.example.FoodMain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodMainTest {

    @Test
    public void testGetToppings(){
        FoodMain foodMain = new FoodMain();
        FoodMain.BasicFood basicFood = foodMain.new BasicFood("Burger", 3.00);
        assertEquals("", basicFood.getToppings());
    }

    @Test
    public void testBasicFoodGetCost(){
        FoodMain foodMain = new FoodMain();
        FoodMain.BasicFood basicFood = foodMain.new BasicFood("Burger", 3.00);
        assertEquals(3.00, basicFood.getCost());
    }

    @Test
    public void testKetchupGetToppings(){
        FoodMain foodMain = new FoodMain();
        FoodMain.Food addKetchup = foodMain.new Ketchup(foodMain.new BasicFood("Burger", 3.00));
        assertEquals(" Ketchup ", addKetchup.getToppings());
    }

    @Test
    public void testMayoGetToppings(){
        FoodMain foodMain = new FoodMain();
        FoodMain.Food addMayo = foodMain.new Mayo(foodMain.new BasicFood("Burger", 3.00));
        assertEquals(" Mayo ", addMayo.getToppings());
    }

    @Test
    public void testMustardGetToppings(){
        FoodMain foodMain = new FoodMain();
        FoodMain.Food addMustard = foodMain.new Mustard(foodMain.new BasicFood("Burger", 3.00));
        assertEquals(" Mustard ", addMustard.getToppings());
    }

    @Test
    public void testCustomerLoyalty(){
        FoodMain foodMain = new FoodMain();
        FoodMain.CustomerLoyalty loyalty = foodMain.new CustomerLoyalty("loyal");
        assertEquals(-1.00, loyalty.Discount(), 0.001);
    }




}
