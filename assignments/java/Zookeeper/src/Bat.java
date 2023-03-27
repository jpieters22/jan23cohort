
public class Bat extends Mammals {

	public int fly = 50;
	public int eatHumans = 25;
	public int attackTown = 100;
	public int displayEnergy;
	
	public Bat() {
		this.displayEnergy = 300;
	}
	
//	public void displayEnergy() {
//		
//		System.out.println(this.displayEnergy + " Is bat energy levels!");
//	}
	
	public void Fly() {
		displayEnergy -= fly;
		System.out.println("WHOOSH!");
		System.out.println("Our bat went flying new energy level is: " + displayEnergy);
	}
	
	public void EatHumans() {
		displayEnergy += eatHumans;
		System.out.println("Crunch!");
		System.out.println("Our bat ate a human, new energy level is: " + displayEnergy);
	}
	
	public void AttackTown() {
		displayEnergy -= attackTown;
		System.out.println("*Fire burning*");
		System.out.println("Our bat attacked a town, new energy level is: " + displayEnergy);
	}
}
