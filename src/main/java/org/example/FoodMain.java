package org.example;

public class FoodMain{
    public interface Food{ //Component: Defines the methods or properties that object and decorators will implement
        public String getToppings();
        public double getCost();
    }

    public class BasicFood implements Food{  //concrete component:object we want to decorate

        private String typeFood;
        private double cost;

        public BasicFood(String typeFood, double cost){
            this.typeFood = typeFood;
            this.cost = cost;

        }
        @Override
        public String getToppings() {
            return "";
        }

        @Override
        public double getCost() {
            return 1.00;
        }
        //object we want to decorate or modify

    }

    public abstract class FoodDecorator implements Food{ //Decorator: abstract class that implements interface
        protected Food tempFood;

        public FoodDecorator(Food food) {
            tempFood = food;
        }

        @Override
        public String getToppings() {
            return tempFood.getToppings();
        }
        @Override
        public double getCost() {
            return tempFood.getCost();
        }
    }

    public class Ketchup extends FoodDecorator{ //Concrete Decorator: adds specific functionality or behaviour to object

        public Ketchup(Food food) {
            super(food);
        }

        @Override
        public String getToppings() {
            return tempFood.getToppings() + " Ketchup ";
        }

        @Override
        public double getCost() {
            return tempFood.getCost() + 0.50;
        }
    }

    public class Mustard extends FoodDecorator{ //Concrete Decorator: adds specific functionality or behaviour to object

        public Mustard(Food food) {
            super(food);
        }

        @Override
        public String getToppings() {
            return tempFood.getToppings() + " Mustard ";
        }

        @Override
        public double getCost() {
            return tempFood.getCost() + 0.75;
        }
    }

    public class Mayo extends FoodDecorator{ //Concrete Decorator: adds specific functionality or behaviour to object

        public Mayo(Food food) {
            super(food);
        }

        @Override
        public String getToppings() {
            return tempFood.getToppings() + " Mayo ";
        }

        @Override
        public double getCost() {
            return tempFood.getCost() + 1.00;
        }
    }

    public class CustomerLoyalty{
      String  customer;

      public CustomerLoyalty(String customerType){
          this.customer = customerType;
      }
        public double Discount(){
          double discount = 0;

          if(customer.equals("loyal")){
              discount = -1.00;
          }
          return discount;
        }

    }


    public static void main(String[] args) {
        FoodMain foodMain = new FoodMain();
        CustomerLoyalty loyalCustomer = foodMain.new CustomerLoyalty("loyal");
        double discount = loyalCustomer.Discount();
        Food burger = foodMain.new BasicFood("Burger",3.00);
        Food hotDog = foodMain.new BasicFood("Hot Dog",3.00);
        Food fries = foodMain.new BasicFood("Fries",2.00);
        Food addKetchup = foodMain.new Ketchup(burger);
        Food addMustard = foodMain.new Mustard(foodMain.new Ketchup(hotDog));
        Food addMayo = foodMain.new Mayo(fries);

        System.out.println("Customer: Standard");
        System.out.println("Food Item: Burger");
        System.out.println("Toppings: " + addKetchup.getToppings());
        System.out.println("Total Cost: " + addKetchup.getCost()+ "\n");
        System.out.println("Customer: Loyal");
        System.out.println("Food Item: HotDog");
        System.out.println("Toppings" + addKetchup.getToppings() + addMustard.getToppings());
        System.out.println("Total Cost: " + (addKetchup.getCost() + addMustard.getCost()) + discount+ "\n");
        System.out.println("Customer: Standard");
        System.out.println("Food Item: Fries");
        System.out.println("Toppings" + addKetchup.getToppings() + addMayo.getToppings());
        System.out.println("Total Cost: " + (addKetchup.getCost() + addMayo.getCost()));

    }
}




