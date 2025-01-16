import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){

    //outer borders
    drawText("╔", 1, 1);
    drawText("╗", 1, 80);
    drawText("╚", 28, 1);
    drawText("╝", 28, 80);
    for (int i = 0; i < 28; i+=27) {
      for (int j = 0; j < 78; j++) {
        drawText("═", 1+i, 2+j);
      }
    }
    for (int i = 0; i < 80; i+=79) {
      for (int j = 0; j < 26; j++) {
        drawText("║", 2+j, 1+i);
      }
    }

    //inner party and text borders
    for (int i = 0; i < 18; i+=17) {
      for (int j = 0; j < 78; j++) {
        drawText("═", 6+i, 2+j);
      }
    }
    for (int i = 0; i < 16; i++) {
      drawText("║", 7+i, 40);
    }
    for (int i = 0; i < 27; i+= 26) {
      for (int j = 0; j < 4; j++) {
        drawText("║", 2+j, 28+i);
      }
    }
    for (int i = 0; i < 27; i+= 26) {
      for (int j = 0; j < 4; j++) {
        drawText("║", 24+j, 28+i);
      }
    }

    //adding corner characters
    drawText("╠", 6, 1);
    drawText("╠", 23, 1);
    drawText("╣", 6, 80);
    drawText("╣", 23, 80);
    drawText("╦", 6, 40);
    drawText("╩", 23, 40);

    for (int i = 0; i < 27; i+= 26) {
      drawText("╦", 1, 28+i);
    }
    for (int i = 0; i < 27; i+= 26) {
      drawText("╦", 23, 28+i);
    }
    for (int i = 0; i < 27; i+= 26) {
      drawText("╩", 6, 28+i);
    }
    for (int i = 0; i < 27; i+= 26) {
      drawText("╩", 28, 28+i);
    }

    Text.go(30, 1);
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    if (text.length() < width) {
      for (int i = 0; i < width - text.length(); i++) {
        text += "e";
      }
      drawText(text, row, col);
      if (height > 0) {
        TextBox(row+1, col, width, height-1, text);
      }
    } else {
      drawText(text.substring(0, width), row, col);
      TextBox(row+1, col, width, height-1, text.substring(width));
    }
  }

  //return a random adventurer (choose between all available subclasses)
  //feel free to overload this method to allow specific names/stats.
  // public static Adventurer createRandomAdventurer(){
  //   return new CodeWarrior("Bob"+(int)(Math.random()*100));
  // }

  /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
  *Should include Name HP and Special on 3 separate lines.
  *Note there is one blank row reserved for your use if you choose.
  *Format:
  *Bob          Amy        Jun
  *HP: 10       HP: 15     HP:19
  *Caffeine: 20 Mana: 10   Snark: 1
  * ***THIS ROW INTENTIONALLY LEFT BLANK***
  */
  public static void drawParty(ArrayList<Adventurer> party,int startRow){

  }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(){

    drawBackground();

    //draw player party

    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();



    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    int exlir = 10;
    int darkExlir = 10;
    int party = 3;
    boolean boss = false;

    //Draw the window border
    ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
    boss = Adventurer.chance(50);
    if (boss)
    {
      enemies.add(new Boss(0, enemies, adventurers, false));
    }
    else
    {
      for (int i = 0; i < 3; i++)
      {
        enemies.add(rand(i, enemies, adventurers, false));
      }
    }
    for (int i = 0; i < 3; i++)
    {
      adventurers.add(rand(i, adventurers, enemies, true));
    }
    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+adventurers.get(whichPlayer)+": attack/special/support/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          if (exlir > adventurers.get(whichPlayer).attackCost)
          {
            String ouy= "Who should " + adventurers.get(whichPlayer) + "target";
            input = userInput(in);
            exlir -= adventurers.get(whichPlayer).specialCost;
          }
          else
          {
            String out = "Failed! Not enough exlir.";
          }
        }
        else if(input.equals("special") || input.equals("sp")){
          if (darkExlir > adventurers.get(whichPlayer).specialCost)
          {
            String ouy = "Who should " + adventurers.get(whichPlayer) + "target";
            input = userInput(in);
            exlir -= adventurers.get(whichPlayer).specialCost;
          }
        }
        else if(input.equals("su ") || input.equals("support ")){
          String out = "Who should " + adventurers.get(whichPlayer) + "target";
          input = userInput(in);
          if(!input.equals(""+whichPlayer))
          {
            if(exlir > 3)
            {
              exlir -=3;
              adventurers.get(Integer.parseInt(input)).heal();
            }
          }
          else if (darkExlir > 6)
          {
            exlir -= 6;
            adventurers.get(whichPlayer).Evolve(3);
          }
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < adventurers.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+adventurers.get(whichPlayer)+": attack/special/support/quit";


        }
        else
        {
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }

      }
      else{


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+adventurers.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
  public static Adventurer rand(int slot, ArrayList<Adventurer> adventurers, ArrayList<Adventurer> enemies, boolean team)
  {
    Random rand = new Random();
    int k = rand.nextInt(3);
    switch (k)
    {
      case 0:
        return new Archer(slot, adventurers, enemies, team);
      case 1:
        return new Barbarian(slot, adventurers, enemies, team);
      case 2:
        return new Wizard(slot, adventurers, enemies, team);
      default:
        return new Wizard(slot, adventurers, enemies, team);
    }
  }

  public static void main (String[] args) {

    Text.hideCursor();
    Text.clear();

    drawBackground();

    Text.reset();
    Text.showCursor();

  }

}
