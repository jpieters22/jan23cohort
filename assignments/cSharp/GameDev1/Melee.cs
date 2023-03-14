public class Melee : Enemy {
    public Melee(string Name) : base(Name){
        base.Health = 120;
        Attack Punch = new Attack("Punch", 20);
        base.AttackList.Add(Punch);
        Attack Kick = new Attack("Kick", 15);
        base.AttackList.Add(Kick);
        Attack Tackle = new Attack("Tackle", 25);
        base.AttackList.Add(Tackle);
    }

    public void Rage(Enemy Target){
        Attack randomAttack = base.Fetch();
        randomAttack.DamageAmount += 10;
        base.PerformAttack(Target, randomAttack);
        randomAttack.DamageAmount -= 10;
        Console.WriteLine($"{Name} used rage!");
    }
}