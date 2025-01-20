import java.util.*;
public class Barbarian extends Adventurer{

  public void Tick()
  {
    if(evoDuration > 0)
    {
      evoDuration--;
      if( evoDuration == 0)
      {
        Game.outputResult(getName() + "'s evolution wore off.'", !good);
      }
    }
    switch (state)
    {
      case BURN:
        break;
      case BLEED:
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
    Game.outputResult(getName() + " has evolved.", !good);
  }

  public String getSpecialName()
  {
    return("Consecutive Swings");
  }

  public String getAttackName()
  {
    return ("Sword Swing");
  }

  public String attack(int other)
  {
    Game.outputResult(getName() + " used " + getAttackName() + " on " + enemies.get(other).getName() + "!", !good);
    int damage = 4;
    if(evoDuration > 0)
    {
      Game.outputResult(getName() + " is evolved! Enraged swings deal more damage.", !good);
      damage = 6;
      if (chance(50))
      damage = 8;
    }
    enemies.get(other).applyDamage(damage);
	  return("");
  }

  public String support(int other)
  {
    Game.outputResult(getName() + " healed" + adventurers.get(other).getName() + ". They restored 10 HP.", !good);
    adventurers.get(other).heal();
	  return("");
  }

  public String support()
  {
    Game.outputResult(getName() + " evolved!", !good);
    Evolve(3);
	  return("");
  }

  public String specialAttack(int other)
  {
    Random rand = new Random();
    int otherPlayer = rand.nextInt(enemies.size());
    double damage = 4;
    if (evoDuration > 0)
    {
      damage = damage * 1.5;
    }
    Game.outputResult(getName() + " used " + getSpecialName() + " on " + enemies.get(other).getName() + "!", !good);
    enemies.get(otherPlayer).applyDamage((int)damage);
    int next = rand.nextInt(enemies.size());
    Game.outputResult(getName() + " used " + getSpecialName() + " on " + enemies.get(next).getName() + "!", !good);
    if (otherPlayer == next)
    {
      Game.outputResult("Powerful swings struck the same target twice, dealing more damage!", !good);
      enemies.get(next).applyDamage((int)(damage * (1.5)));
    }
    else
    {
      Game.outputResult(getName() + " used " + getSpecialName() + " on " + enemies.get(next).getName() + "!", !good);
      enemies.get(next).applyDamage((int)damage);
    }

    return("");
  }

  public Barbarian(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, boolean team){
	  super("Barbarian", 30, slot, adventurers, enemies, team);
     specialCost = 4;
     supportCost = 6;
  }

}
