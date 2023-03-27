
public class TestMammals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gorilla George = new Gorilla();
		
		//This should take away 5 energy 
		George.Throw();
		George.Throw();
		George.Throw();
		
		//This will add 10 energy to gorilla
		George.EatBananas();
		George.EatBananas();
		
		//This will take 10 energy from gorilla 
		George.Climb();
		
		Bat Dracula = new Bat();
		
		Dracula.AttackTown();
		Dracula.AttackTown();
		Dracula.AttackTown();
		
		Dracula.EatHumans();
		Dracula.EatHumans();
		
		Dracula.Fly();
		Dracula.Fly();
	}

}
