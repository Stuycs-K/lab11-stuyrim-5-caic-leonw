import java.util.Random;
import java.util.*;
public class Archer extends Adventurer{

  public void Tick()
  {
	if(evoDuration > 0)
	{
    if( evoDuration == 1)
    {
      System.out.println(getName() + "'s evolution wore off.'");
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
    System.out.println(getName() + " used " + getAttackName() + " on " + enemies.get(other).getName() + "!");
    enemies.get(other).applyDamage(3);
    if(evoDuration > 0)
    {
      System.out.println(getName() + " is evolved! Ragged tipped arrows have a chance to apply bleed.");
    }
    if(chance(30) && evoDuration > 0)
    {
      System.out.println(enemies.get(other).getName() + " is bleeding!");
      enemies.get(other).state = Effect.BLEED;
    }
	  return("");
  }

  public String support(int other)
  {
    System.out.println(getName() + " healed" + adventurers.get(other).getName() + ". They restored 10 HP.");
    adventurers.get(other).heal();
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
    int otherPlayer = rand.nextInt(enemies.size());
    int damage = 3;
    System.out.println(getName() + " used " + getSpecialName() + " on " + enemies.get(other).getName() + "!");
    if (enemies.get(otherPlayer).getSlot() != this.getSlot())
    {
      damage *= 2;
    }
    enemies.get(otherPlayer).applyDamage(damage);
    if (chance(50))
    {
      System.out.println(enemies.get(otherPlayer).getName() + " is bleeding!");
      enemies.get(otherPlayer).state = Effect.BLEED;
    }

    return("");
  }


  public Archer(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies){
	  super("Archer", 24, slot, adventurers, enemies);
    specialCost = 5;
    supportCost = 6;
  }
}
