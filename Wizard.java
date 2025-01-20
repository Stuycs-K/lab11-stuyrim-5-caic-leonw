import java.util.*;
public class Wizard extends Adventurer{

  public int shield = 0;

  public void Tick()
  {
    if(evoDuration > 0)
    {
      evoDuration--;
      if (evoDuration == 0)
      {
        shield = 0;
        Game.outputResult(getName() + "'s evolution wore off", !good);
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
    Game.outputResult(getName() + " has evolved, gaining a Fire Shield.", !good);
    shield = 10;
  }

  public String getSpecialName()
  {
    return("Flamethrower");
  }

  public String getAttackName()
  {
    return ("Fireball");
  }

  public String attack(int other)
  {
    Game.outputResult(getName() + " used " + getAttackName() + " on " + enemies.get(other).getName() + "!", !good);
    int damage = 6;
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
    Game.outputResult(getName() + " used " + getSpecialName() + ", hitting all enemies!", !good);
    for (int i = 0; i < enemies.size(); i++)
    {
      enemies.get(i).applyDamage(4);
      if (chance(10))
      {
        enemies.get(i).state = Effect.BURN;
      }
    }
    return("");
  }

  public void applyDamage(int amount)
  {
    if (shield > 0)
    {
      shield -= amount;
      if (shield < 0)
      {
        shield = 0;
        evoDuration = 0;
        for (int i = 0; i < enemies.size(); i++)
        {
          enemies.get(i).applyDamage(3);
        }
        Game.outputResult(getName() + "'s Fire Shield broke, hitting all enemies!", !good);
      }
    }
    else
    {
      setHP(getHP() - amount);
    }
  }

  public Wizard(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, boolean team){
	  super("Wizard",  20, slot, adventurers, enemies, team);
    specialCost = 6;
    supportCost = 6;
  }

}
