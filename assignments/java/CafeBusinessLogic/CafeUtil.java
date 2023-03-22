

import java.util.ArrayList;
import java.util.Scanner;

public class CafeUtil {
    
    public void testing() {
        System.out.println("Testing");
    }

    public int getStreakGoal(int numWeeks) {
        int total = 0;

        for(int i = 1; i <= numWeeks; i++) {
            total += i;
        }

        return total;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;

        for(int i = 0; i < prices.length; i++) {
            total += prices[i];
        }

        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        
        for(int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");

        Scanner s = new Scanner(System.in);
        String userInput = s.next(); //s.next() prompts user for input
        customers.add(userInput);
    }
}
