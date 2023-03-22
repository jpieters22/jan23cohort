
import java.util.ArrayList;
import java.util.Date;

public class Dog {
    public static int dogCount = 0;

    public static ArrayList<Dog> allDogs = new ArrayList<>();

    //using a private access modifier meaning it cant be accessed outside of this class we will need getters and setter to use them.

    private String name;
    private String breed;
    private boolean goodDog = true;
    private int age;
    //Homework challenge: Instead of putting the age of the dog, input the birthdate and then have age be calculated on subtracting the birthdate from todays date
    private boolean houseBroken; 
    private Owner owner = new Owner("Joslyn"); //Creating a default owner name 
    private ArrayList<String> toys = new ArrayList<>(); //creating a empty list where we can add toys 

    //constructor 
    public Dog(String name, String breed, int age, boolean houseBroken){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.houseBroken = houseBroken;
        Dog.dogCount += 1; //adding dog instances and adding them to the list with count, using static methods above every time a new dog is created 
        Dog.allDogs.add(this); //also using static method to add the new dog to the list of all dogs created 
    }

    //overloaded constructor 

    public Dog(String name, String breed, int age, boolean houseBroken, String ownerName) {
        this(name, breed, age, houseBroken);
        this.owner.setName(ownerName);
    }
}
