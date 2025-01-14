import java.util.Random;
public class Wizard extends Adventurer{

  public void Tick()
  {
    if(evoDuration > 0)
    {
      evoDuration--;
    }
    switch (state)
    {
      case Effect.BURN:
        break;
      case Effect.BLEED:
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
    return("");
  }

  public String getAttackName()
  {
    return ("");
  }


  public String attack(int other)
  {
    return("");
  }

  public String support(int other)
  {
    return("");
  }

  public String support()
  {
    return("");
  }

  public String specialAttack(int other)
  {
    return("");
  }
  public void applyDamage(int amount)
  {
    setHP(getHP() - amount);
  }



  public Wizard(String name, int hp, int slot, Adventurer[] adventurers){
	  super(name,hp, slot, adventurers);
    specialCost = 6;
    supportCost = 6;
  }

}
