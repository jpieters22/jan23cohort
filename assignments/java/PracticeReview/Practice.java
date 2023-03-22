package assignments.java.PracticeReview;

public class Practice {
    
    public static void main(String[] args) {
        System.out.println("Hello from Java!");

        //Data types
        int age = 40; //integer
        double altAge = 44.5; 
        System.out.println(age);
        System.out.println(altAge);
        System.out.println(age + altAge);

        char test = 'a';
        String myString = "This is a string"; //string is uppercase as oppose to c# being lowercase
        String name = "Melissa";
        hi();
        int num = 24;
        System.out.println(favNum(name, num));
        if (num > 10){
            System.out.println("less than 10");
        }
        else if(num < 25){
            System.out.println("less than 25");
        }
        else if(num < 30){
            System.out.println("less than 30");
        }
        //all if statements will be checked. if else is where it will check if statements are true. If true it will print the first statements if runs true. 
        fizzBuzz();
    }

    public static void hi(){
        System.out.println("\nHello my old friends.");
    }

    //Function called favNum that will return something after accepting 2 arguments 
    //the return statement is returning a string that is formatted and using the passed arguments
    public static String favNum(String name, int num) {
        //both return will work for this function with or without .format
        return String.format("Hey everyone guess what? " + name + " has a favorite number of " + num);
        //return "Hey everyone guess what? " + name + " has a favorite number of " + num
    }

    public static void fizzBuzz(){
        int number = 100;

        for(int i = 1; i <= number; i++){
            if(i% 15 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            else{
                System.out.println(i);
            }
        }
    }
}

    // divisible by 3 print fizz
    // divisible by 5 print buzz
    // divisible by both print fizz buzz
    // else just print the number
    //1 - 100