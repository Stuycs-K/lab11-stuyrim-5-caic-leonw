import java.util.Random;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  private int evoDuration;
  private int slot;
  public int attackCost;
  public int specialCost;
  public int supportCost;
  public int healCost;
  public Adventurer[] adventurers;

  enum Effect
  {
    NONE,
    BURN,
    BLEED
  }
  public Effect state = Effect.NONE;

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
  public int restoreSpecial(int n){
      if( n > getSpecialMax() - getSpecial()){
              n = getSpecialMax() - getSpecial();
      }
      setSpecial(getSpecial()+n);
      return n;
  }

  public void Evolve(int duration)
  {
    evoDuration = duration;
    System.out.println(getName() + " has evolved.");
  }

  public abstract String getSpecialName();

  public abstract String getAttackName();

  public abstract String attack(Adventurer other);

  public abstract String support(Adventurer other);

  public abstract String support();

  public abstract String specialAttack(Adventurer other);

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  public Adventurer(String name, int hp, int slot, Adventurer[] adventurers){
    this.name = name;
    this.HP = hp;
    this.slot = slot;
    this.maxHP = hp;
    healCost = 3;
    attackCost = 2;
    this.adventurers  = adventurers;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }

  public int getEvoDuration(){
    return evoDuration;
  }
  public int getSlot()
  {
    return slot;
  }
  private void setmaxHP(int newMax){
    maxHP = newMax;
  }
  //Set Methods
  private void setHP(int health){
    this.HP = health;
  }

  private void setName(String s){
    this.name = s;
  }
}
