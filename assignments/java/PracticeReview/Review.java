
public class Review {
    public static void main(String[] args) {
        System.out.println("Hello Class");
        int num = 24;
        String name = "Joslyn";
        char character = 'a'; //need single quotes for characters 
        double decimals = 24.24;
        boolean something = true;
        float num2 = 24.24f; //need f at the end for float 

        if(num < 15) {
            System.out.println("Less than 15");
        } else {
            System.out.println("Not less than 15");
        }

        //Good for multiple conditions that use the same that it is compairing ... i.e like user in the session or user level if it is 2 go here 4 go here also and so on
        switch(character){
            case 'a': 
                System.out.println("This is an a");
                break;
            default:
                System.out.println("This is not a letter");
        }

        //Good for if/else but not multiple conditions 
        System.out.println(something ? "It's Tuesday" : "It's not Tuesday");
    }
}
