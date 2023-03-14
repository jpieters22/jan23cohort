public class Ranged : Enemy {

    public int Distance;

    public Ranged(string Name) : base(Name){
        Distance = 5;
        base.Health = 100;
        Attack Arrow = new Attack("Arrow", 20);
        base.AttackList.Add(Arrow);
        Attack Knife = new Attack("Knife Throw", 15);
        base.AttackList.Add(Knife);
    }

    public override void PerformAttack(Enemy Target, Attack ChosenAttack){
        if(Distance < 10) {
            base.PerformAttack(Target, ChosenAttack);
        }
    }

    public void Dash() {
        Distance = 20;
        Console.WriteLine($"{Name} HashCode performed a dash! Setting their distance to 20!");
    }
}