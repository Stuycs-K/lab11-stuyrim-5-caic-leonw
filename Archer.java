import java.util.Random;
public class Archer extends Adventurer{

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

  public String getSpecialName()
  {
	return("");
  }

  public int getSpecial()
  {
	return(1);
  }

  public int getSpecialMax()
  {
	return(1);
  }

  public void setSpecial(int n)
  {

  }

  public String attack(Adventurer other)
  {
	   return("");
  }

  public String support(Adventurer other)
  {
	   return("");
  }

  public String support()
  {
	   return("");
  }

  public String specialAttack(Adventurer other)
  {
	   return("");
  }

  public void applyDamage(int amount){
	this.HP -= amount;
  }

  public Archer(String name, int hp, int slot){
  	super(name,hp, slot);
    specialCost = 5;
    supportCost = 6;
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
