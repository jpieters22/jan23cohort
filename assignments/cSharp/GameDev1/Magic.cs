public class Magic : Enemy{
    public Magic(string Name) : base(Name){
        base.Health = 80;
        Attack Fireball = new Attack("Fireball", 25);
        base.AttackList.Add(Fireball);
        Attack Lightning = new Attack("Lightning Bolt", 20);
        base.AttackList.Add(Lightning);
        Attack Staff = new Attack("Staff Strike", 10);
        base.AttackList.Add(Staff);
    }

    public void Heal(Enemy Target) {
        Target.Health += 40;
        Console.WriteLine($"{Name} has healed {Target.Name}! Their new health is {Target.Health}!");
    }
}