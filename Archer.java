import java.util.Random;
public class Archer extends Adventurer{

  public void Tick()
  {
	if(evoDuration > 0)
	{
    if( evoDuration == 1)
    {
      System.out.println(getName() + "'s evolution wore off.'")
    }
  	evoDuration--;
	}
	switch (state)
	{
  	case Effect.BURN:
      setHP(getHP() -2);
    	break;
  	case Effect.BLEED:
      setHP(getHP() -2);
    	break;
  	default:
    	break;
	}
  }

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()

  public void Evolve(int duration)
  {
	   evoDuration = duration;
	    System.out.println(getName() + " has evolved.");
  }

  public String getSpecialName()
  {
    return("Long Distance Shot");
  }

  public String getAttackName()
  {
    return ("Tracking Shot");
  }

  public String attack(int other)
  {
    System.out.println(getName() + " used " + getAttackName() + " on " + adventurers[other].getName() + "!");
    adventurers[other].applyDamage(3);
    if(evoDuration > 0)
    {
      System.out.println(getName() + " is evolved! Ragged tipped arrows have a chance to apply bleed.")
    }
    if(chance(30) && evoDuration > 0)
    {
      System.out.println(adventurers[other].getName() + " is bleeding!")
      adventurers[other].state = Effect.BLEED;
    }
	  return("");
  }

  public String support(int other)
  {
    System.out.println(getName() + " healed" + adventurers[other].getName() + ". They restored 10 HP.")
    adventurers[other].heal();
	  return("");
  }

  public String support()
  {
    System.out.println(getName() + " evolved!");
    Evolve(3);
	  return("");
  }

  public String specialAttack(int other)
  {
    Random rand = new Random();
    int otherPlayer = rand.nextInt(3) + 3;
    int damage = 3;
    System.out.println(getName() + " used " + getSpecialName() + " on " + adventurers[otherPlayer].getName() + "!");
    if (adventurers[otherPlayer].getSlot() != this.getSlot())
    {
      damage *= 2;
    }
    adventurers[otherPlayer].applyDamage(damage);
    if (chance(50))
    {
      System.out.println(adventurers[other].getName() + " is bleeding!")
      adventurers[otherPlayer].state = Effect.BLEED;
    }

    return("");
  }


  public Archer(String name, int hp, int slot, Adventurer[] adventurers){
	  super(name,hp, slot, adventurers);
    specialCost = 5;
    supportCost = 6;
    this.adventurers = adventurers;
  }
}
