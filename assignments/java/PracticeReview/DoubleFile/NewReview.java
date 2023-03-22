

import java.util.ArrayList;
import java.util.HashMap;

public class NewReview {
    public void foodSold() {
        System.out.println("! food item was sold");
    }
    public void createArrayList() {
        ArrayList<String> food = new ArrayList<>();
        food.add("Sushi");
        food.add("Tacos");
        food.add("Tempura");
        food.add("Sashimi");
        food.add("Pizza");
        food.add("Wings");

        for(String item : food){
            System.out.println(item);
        }
    }

    public void orderFood(String food, String size){
        HashMap<String, Double> combo = new HashMap<>();
        combo.put("Sm Basket", 2.00);
        combo.put("Med Basket", 3.50);
        combo.put("Lg Basket", 5.00);

        if(food.toLowerCase().equals("sashimi")){
            System.out.println("Ummm what is that?");
        } else {
            System.out.printf("You ordered %s, at a cost of $%.2f %n", food, combo.get(size));
            //%.2f means 2 decimal places 
        }
    }
}
