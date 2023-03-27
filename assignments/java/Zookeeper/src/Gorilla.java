
public class Gorilla extends Mammals {

	public static int throwThings = 5;
	public static int eatBananas = 10;
	public static int climb = 10;
	
	public void Throw() {
		displayEnergy -= throwThings;
		System.out.println("Our gorilla threw something");
		System.out.println("The gorillas new energy is: " + displayEnergy + "/100");
	}
	
	public void EatBananas() {
		displayEnergy += eatBananas;
		System.out.println("Our gorilla ate bananas! Woohoo more energy!");
		System.out.println("The gorillas new energy is: " + displayEnergy + "/100");
	}
	
	public void Climb() {
		displayEnergy -= climb;
		System.out.println("Our gorilla went climbing");
		System.out.println("The gorillas new energy is: " + displayEnergy + "/100");
	}

//	public void displayEnergy() {
//		// TODO Auto-generated method stub
//		this.displayEnergy = 100;
//		System.out.println(this.displayEnergy + " Is gorillas energy levels!");
//	}
}
