
public class Driver extends Car {

	public static int driving = 1;
	public static int boosting = 3;
	public static int refuel = 2;
	
	public void Driving() {
		gas -= driving;
		System.out.println("You drove the car.");
		System.out.println("Gas Remaining: " + gas + "/10");
	}
	
	public void Boosters() {
		gas -= boosting;
		System.out.println("Boosting decreased your gas by: " + gas);
	}
	
	public void Refueling() {
		gas += refuel;
		System.out.println("Refueling increased your gas by: " + gas);
	}
	
	public void Remaining() {
		System.out.println("Overall gas Remaining:"+ gas + "/10");
	}
}
