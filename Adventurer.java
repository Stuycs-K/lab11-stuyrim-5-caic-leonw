import java.util.Random;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  public int evoDuration;
  private int slot;
  public int attackCost;
  public int specialCost;
  public int supportCost;
  public int healCost;
  public List<Adventurer> adventurers;
  public List<Adventurer> enemies;
  public boolean Alive;

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


  public void Evolve(int duration)
  {
    evoDuration = duration;
    System.out.println(getName() + " has evolved.");
  }

  public abstract String getSpecialName();

  public abstract String getAttackName();

  public abstract String attack(int other);

  public abstract String support(int other);

  public abstract String support();

  public abstract String specialAttack(int other);

  public void applyDamage(int amount){
    this.HP -= amount;
    CheckDeath();
  }
  private void CheckDeath()
  {
    if (this.HP <= 0)
    {
      System.out.println(getName() + " Died.");
      Alive = false;
    }
  }
  public Adventurer(String name, int hp, int slot, List<Adventurer> adventurers, List<Adventurer> enemies){
    this.name = name;
    this.HP = hp;
    this.slot = slot;
    this.maxHP = hp;
    healCost = 3;
    attackCost = 2;
    this.adventurers  = adventurers;
    this.enemies = enemies;
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
  protected void setHP(int health){
    this.HP = health;
    CheckDeath();
  }

  private void setName(String s){
    this.name = s;
  }
  public void heal()
  {
    this.HP += 10;
    if (this.HP > this.maxHP)
    {
      this.HP = maxHP;
    }
  }
  public static boolean chance (int percent)
  {
    Random rand = new Random();
    return (percent < rand.nextInt(100));
  }
}
