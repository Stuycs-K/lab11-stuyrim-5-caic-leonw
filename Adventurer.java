import java.util.Random;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  private int evoDuration;
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

  public abstract int getSpecial();

  public abstract int getSpecialMax();

  public abstract void setSpecial(int n);

  public abstract String attack(Adventurer other);

  public abstract String support(Adventurer other);

  public abstract String support();

  public abstract String specialAttack(Adventurer other);

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  public Adventurer(){
    this("");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
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
