import java.util.*;
public class Boss extends Adventurer{

  int attackTurn = -1;
  int lastHit;

  public void Tick()
  {
    if(evoDuration > 0)
    {
      evoDuration--;
        if (evoDuration == 0)
        {
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
    if (attackTurn < 2)
    {
      attackTurn++;
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
    return("Limb Breaker");
  }

  public String getAttackName()
  {
    return ("Saber Swing");
  }

  public String attack(int other)
  {
    if (attackTurn == 2)
    {
      Game.outputResult(getName() + " used " + getAttackName() + " on " + enemies.get(other).getName() + "!", !good);
      double damage = 6;
      if (lastHit == other)
      {
        lastHit = -1;
        damage = damage * 1.5;
      }
      if (evoDuration > 0)
      {
        Game.outputResult(getName() + " is evolved, healing after the attack!", !good);
        damage += 2;
        setHP(getHP() + 2);
      }
      enemies.get(other).applyDamage((int)damage);
      attackTurn = 0;
    }
    else
    {
      Game.outputResult("Pekka is recharging...", !good);
    }
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
    Game.outputResult(getName() + " used " + getSpecialName() + ", weakening them!", !good);
    lastHit = other;
    double damage = 10;
    if (lastHit == other)
    {
      lastHit = -1;
      damage = damage * 1.5;
    }
    if (evoDuration > 0)
    {
      Game.outputResult(getName() + " is evolved, healing after the attack!", !good);
      damage += 3;
      setHP(getHP() + 2);
    }
    enemies.get(other).applyDamage((int)damage);

    return("");
  }

  public Boss(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, boolean team){
	  super("Pekka", 40, slot, adventurers, enemies, team);
     specialCost = 4;
     supportCost = 6;
  }
  
}
