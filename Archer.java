import java.util.*;
public class Archer extends Adventurer{

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
        setHP(getHP() -2);
      	break;
    	case BLEED:
        setHP(getHP() -2);
      	break;
    	default:
      	break;
  	}
    if (getSlot() == 0) {
      Game.drawText(getName(), 24, 2);
      Game.drawText("HP: " + getHP(), 25, 2);
      Game.drawText("Evo Duration: " + getEvoDuration(), 26, 2);
    }
    if (getSlot() == 1) {
      Game.drawText(getName(), 24, 29);
      Game.drawText("HP: " + getHP(), 25, 29);
      Game.drawText("Evo Duration: " + getEvoDuration(), 26, 29);
    }
    if (getSlot() == 2) {
      Game.drawText(getName(), 24, 56);
      Game.drawText("HP: " + getHP(), 25, 56);
      Game.drawText("Evo Duration: " + getEvoDuration(), 26, 56);
    }
    if (getSlot() == 3) {
      Game.drawText(getName(), 2, 2);
      Game.drawText("HP: " + getHP(), 3, 2);
      Game.drawText("Evo Duration: " + getEvoDuration(), 4, 2);
    }
    if (getSlot() == 4) {
      Game.drawText(getName(), 2, 29);
      Game.drawText("HP: " + getHP(), 3, 29);
      Game.drawText("Evo Duration: " + getEvoDuration(), 4, 29);
    }
    if (getSlot() == 5) {
      Game.drawText(getName(), 2, 56);
      Game.drawText("HP: " + getHP(), 3, 56);
      Game.drawText("Evo Duration: " + getEvoDuration(), 4, 56);
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
    return("Long Distance Shot");
  }

  public String getAttackName()
  {
    return ("Tracking Shot");
  }

  public String attack(int other)
  {
    Game.outputResult(getName() + " used " + getAttackName() + " on " + enemies.get(other).getName() + "!", !good);
    enemies.get(other).applyDamage(3);
    if(evoDuration > 0)
    {
      Game.outputResult(getName() + " is evolved! Ragged tipped arrows have a chance to apply bleed.", !good);
    }
    if(chance(30) && evoDuration > 0)
    {
      Game.outputResult(enemies.get(other).getName() + " is bleeding!", !good);
      enemies.get(other).state = Effect.BLEED;
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
    Random rand = new Random();
    int otherPlayer = rand.nextInt(enemies.size());
    int damage = 3;
    Game.outputResult(getName() + " used " + getSpecialName() + " on " + enemies.get(other).getName() + "!", !good);
    if (enemies.get(otherPlayer).getSlot() != this.getSlot())
    {
      damage *= 2;
    }
    enemies.get(otherPlayer).applyDamage(damage);
    if (chance(50))
    {
      Game.outputResult(enemies.get(otherPlayer).getName() + " is bleeding!", !good);
      enemies.get(otherPlayer).state = Effect.BLEED;
    }

    return("");
  }


  public Archer(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, boolean team)
  {
	  super("Archer", 24, slot, adventurers, enemies, team);
    specialCost = 5;
    supportCost = 6;
  }

}
