// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");

Attack MyAttack1 = new Attack("Fireball", 20);
Attack MyAttack2 = new Attack("Punch", 7);
Attack MyAttack3 = new Attack("Kick", 13);

Enemy Enemy1 = new Enemy("Joslyn");

Enemy1.AttackList.Add(MyAttack1);
Enemy1.AttackList.Add(MyAttack2);
Enemy1.AttackList.Add(MyAttack3);
// Console.WriteLine(Enemy1.AttackList[0].Name);
// Console.WriteLine(Enemy1.AttackList[1].Name);
// Console.WriteLine(Enemy1.AttackList[2].Name);

// Enemy1.Fetch();

Melee Meathead = new Melee("MeatHead");
Melee Shark = new Melee("Shark");
Melee Doom = new Melee("Doom");

Meathead.Fetch();
Shark.Fetch();
Doom.Fetch();

Console.WriteLine(Meathead.Name);
Console.WriteLine(Shark.Name);
Console.WriteLine(Doom.Name);
Console.WriteLine(Meathead.Health);

Ranged RangedFighter1 = new Ranged("Robin");

RangedFighter1.Fetch();
Console.WriteLine(RangedFighter1.Name);
Console.WriteLine(RangedFighter1.Health);

Magic TheWiz = new Magic("The Wiz");
Magic HarryPotter = new Magic("Harry Potter");

TheWiz.Fetch();
Console.WriteLine(TheWiz.Name);
Console.WriteLine(TheWiz.Health);

Meathead.PerformAttack(RangedFighter1, Meathead.AttackList[0]);
RangedFighter1.PerformAttack(Shark, RangedFighter1.AttackList[1]);
RangedFighter1.PerformAttack(Meathead, RangedFighter1.AttackList[0]);
// RangedFighter1.Dash();

TheWiz.PerformAttack(Meathead, TheWiz.AttackList[0]);

TheWiz.Heal(RangedFighter1);
TheWiz.Heal(TheWiz);
TheWiz.Heal(Meathead);


Meathead.Rage(Shark);
Console.WriteLine(TheWiz.Health);
Console.WriteLine(HarryPotter.Health);