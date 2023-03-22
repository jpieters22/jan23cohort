import java.util.ArrayList;

public class IceCream {
    public void sellIceCream(){
        System.out.println("1 ice cream sold");
    }

    public void createArrayList(){
        ArrayList<String> flavors = new ArrayList<>();
        flavors.add("Chocolate");
        flavors.add("Raspberry");
        flavors.add("Cookies and Cream");
        flavors.add("Vanilla");
        flavors.add("Rocky Road");

        //for flavor in flavors
        //this will iterate through the array of flavors in array list created
        for(String flavor : flavors){
            System.out.println(flavor);
        }
    }

    public void orderIceCream(String flavor){
        if(flavor.toLowerCase().equals("rocky road")){
            System.out.println("That is free on the house today...");
        }
        else if(flavor.toUpperCase().equals("CHOCOLATE")) {
            System.out.println("$1 please");
        }
        else{
            System.out.println("$2 please");
        }
    }
}
