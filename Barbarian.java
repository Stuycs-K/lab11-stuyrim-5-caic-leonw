import java.util.Random;
public class Barbarian extends Adventurer{
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


  public String attack(int  other)
  {
    return("");
  }

  public String support(int  other)
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

  public Barbarian(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, Game game){
	  super("Barbarian", 30, slot, adventurers, enemies, game);
     specialCost = 4;
     supportCost = 6;
  }
}
