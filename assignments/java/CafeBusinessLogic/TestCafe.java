

import java.util.ArrayList;
import java.util.Scanner;

public class TestCafe {
    public static void main(String[] args) {
        System.out.println("hello");

        CafeUtil test = new CafeUtil();

        System.out.println("\n ---------Streak Goal ---------");

        System.out.printf("Purchases needed by week 10: %s \n\n", test.getStreakGoal(5));

        System.out.println("-----Order Total-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};

        System.out.printf("Order Total: %s \n\n", test.getOrderTotal(lineItems));

        System.out.println("-----Display Menu-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Drip Coffee");
        menu.add("Cappuccino");
        menu.add("Latte");
        menu.add("Mocha");

        test.displayMenu(menu);

        System.out.println("\n-----Add Customer------");

        ArrayList<String> customers = new ArrayList<String>();

        for(int i = 0; i < 4; i++){
            test.addCustomer(customers);
        }

        System.out.println(customers);
    }
}
