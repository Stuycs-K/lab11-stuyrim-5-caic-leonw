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
  public static void TextBox(int row, int col, int width, int height, String text) {
    if (height <= 0 || text.isEmpty())
    {
      return;
    }

    String line;
    if (text.length() < width)
    {
      line = text + " ".repeat(width - text.length());
    }
    else
    {
      line = text.substring(0, width);
    }

    drawText(line, row, col);
    if (text.length() > width)
    {
      TextBox(row + 1, col, width, height - 1, text.substring(width));
    }
    else
    {
      TextBox(row + 1, col, width, height - 1, " ");
    }
  }

  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if (((double)hp / maxHP) < 0.25) {
      output = Text.colorize(output, 31);
    } else if (((double)hp / maxHP) < 0.75 && ((double)hp / maxHP) > 0.25) {
      output = Text.colorize(output, 33);
    } else {
      output = Text.colorize(output, 37);
    }
    return output;
  }

  public static String userInput(Scanner in){
    
    //Move cursor to prompt location
    Text.go(15, 3);

    //show cursor
    Text.showCursor();
    String input = in.nextLine();

    //clear the text that was written

    TextBox(10,2,38,6, " ");

    return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(30,1);
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
    int elixir = 10;
    int darkElixir = 10;
    int party = 3;
    boolean boss = false;
    boolean win = false;
    int enemyelixir = 10;
    int enemydarkElixir = 10;

    //Draw the window border
    ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
    boss = Adventurer.chance(20);
    if (boss)
    {
      enemies.add(new Boss(0, enemies, adventurers, false));
      enemies.get(0).Tick();
    }
    else
    {
      for (int i = 0; i < 3; i++)
      {
        enemies.add(rand(i, enemies, adventurers, false));
        enemies.get(i).Tick();
      }
    }
    for (int i = 0; i < 3; i++)
    {
      adventurers.add(rand(i, adventurers, enemies, true));
      adventurers.get(i).Tick();
    }

    //You can add parameters to draw screen!
    drawBackground();//initial state.
    Drawelixir(elixir, darkElixir);
    Drawelixir(elixir, darkElixir, true);

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+adventurers.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) && !win)
    {
      //Read user input
      outputResult(preprompt, !partyTurn);

      input = userInput(in);

      String out = "";
      if(partyTurn )
      {
        if (adventurers.get(whichPlayer).alive == true)
        {
          if(input.equals("attack") || input.equals("a"))
          {
            if (elixir > 2)
            {
              out = "Who should " + adventurers.get(whichPlayer) + " target: 0/1/2";
              outputResult(out);
              input = userInput(in);
              int target = Integer.parseInt(input);
              if (target < enemies.size())
              {
                elixir -= 2;
                adventurers.get(whichPlayer).attack(target);
              }
            }
            else
            {
              out = "Failed! Not enough elixir.";
              outputResult(out);
            }
          }


          else if(input.equals("special") || input.equals("sp"))

          {
            if (darkElixir > adventurers.get(whichPlayer).specialCost)
            {
              out = "Who should " + adventurers.get(whichPlayer) + " target: 0/1/2";
              outputResult(out);
              input = userInput(in);
              int target = Integer.parseInt(input);
              if (target < enemies.size())
              {
                darkElixir -= adventurers.get(whichPlayer).specialCost;
                adventurers.get(whichPlayer).specialAttack(target);
              }
            }
            else
            {
              out = "Failed! Not enough dark elixir.";
              outputResult(out);
            }
          }

          else if(input.equals("su") || input.equals("support"))

          {
            out = "Who should " + adventurers.get(whichPlayer) + " target: 0/1/2";
            outputResult(out);
            input = userInput(in);
            int target = Integer.parseInt(input);
            if(target != whichPlayer && target < adventurers.size())
            {
              if(elixir > 3)
              {
                elixir -=3;
                adventurers.get(Integer.parseInt(input)).heal();
              }
              else
              {
                out = "Failed! Not enough elixir.";
                outputResult(out);
              }
            }
            else if (darkElixir > 6)
            {
              darkElixir -= 6;
              adventurers.get(whichPlayer).Evolve(3);
              adventurers.get(whichPlayer).Tick();
            }
            else
            {
              out = "Failed! Not enough dark elixir.";
              outputResult(out);
            }
          }

        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        for (Adventurer enemy : enemies) {
          enemy.Tick();
        }
        for (Adventurer player : adventurers) {
          player.Tick();
        }
        whichPlayer++;
        Drawelixir(elixir, darkElixir);


        if(whichPlayer < adventurers.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          preprompt = "Enter command for "+adventurers.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit";
        }
        else
        {
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          preprompt = "Press enter to see monster's turn";
          elixir += 10;
          darkElixir += 5;
          partyTurn = false;
          whichOpponent = 0;
        }

      }
      else{
        if (enemies.get(whichOpponent).alive)
        {
          preprompt = "Press enter to see next turn";

          Random random = new Random();
          int c = random.nextInt(3);
          ArrayList<Integer> trueIndices = new ArrayList<>();
          for (int i = 0; i < adventurers.size(); i++) {
              if (adventurers.get(i).alive) {
                  trueIndices.add(i);
              }
          }
          int k = trueIndices.get(random.nextInt(trueIndices.size()));
          if(c == 0)
          {
            if (enemyelixir > 2)
            {
              enemies.get(whichOpponent).attack(k);
              enemyelixir-= 2;
            }
            else
            {
              out = "Failed! Not enough elixir.";
            }
          }


          else if(c == 1)

          {
            if (enemydarkElixir> enemies.get(whichOpponent).specialCost)
            {
              enemies.get(whichOpponent).specialAttack(k);
              enemydarkElixir-= enemies.get(whichOpponent).specialCost;
            }
            else
            {
              out = "Failed! Not enough dark elixir.";
              outputResult(out, true);
            }
          }

          else if(c == 2)
          {
            k = random.nextInt(enemies.size());
            if(k != whichOpponent)
            {
              if(enemyelixir> 3)
              {
                enemyelixir-=3;
                enemies.get(k).heal();
              }
              else
              {
                out = "Failed! Not enough elixir.";
                outputResult(out, true);
              }
            }
            else if (enemydarkElixir> 6)
            {
              enemydarkElixir-= 6;
              enemies.get(whichOpponent).Evolve(3);
            }
            else
            {
              out = "Failed! Not enough dark elixir.";
              outputResult(out, true);
            }
          }
        }

        for (Adventurer player : adventurers) {
          player.Tick();
        }
        for (Adventurer enemy : enemies) {
          enemy.Tick();
        }
        whichOpponent++;
        Drawelixir(enemyelixir, enemydarkElixir, true);
      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        enemyelixir += 10;
        enemydarkElixir += 5;
        preprompt = "Enter command for "+adventurers.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit";
        boolean end = true;
        for (int i = 0; i < enemies.size(); i++)
        {
          if (enemies.get(i).alive)
          {
            end = false;
            break;
          }
        }
        if (end)
        {
          outputResult("You win!");
          win = true;
        }
        end = true;
        for (int i = 0; i < adventurers.size(); i++)
        {
          if (adventurers.get(i).alive)
          {
            end = false;
            break;
          }
        }
        if (end)
        {
          outputResult("You lose...");
          win = true;
        }
      }

      drawBackground();
      Drawelixir(elixir, darkElixir);
      Drawelixir(elixir, darkElixir, true);
    }

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

  public static void outputResult(String str)
  {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    TextBox(10,2,38,6, str);
  }

  public static void outputResult(String str, boolean right)
  {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    int col = 2;
    if (right)
    {
      col += 40;
    }
    TextBox(10,col,38,6, str);
  }

  public static void Drawelixir(int elixir, int darkElixir)
  {
    TextBox(17,2,30,6, "Elixir: " + elixir + ". Dark Elixir: " + darkElixir);
  }

  public static void Drawelixir(int elixir, int darkElixir, boolean right)
  {
    int col = 2;
    if (right)
    {
      col += 40;
    }
    TextBox(17,col,30,6, "Elixir: " + elixir + ". Dark Elixir: " + darkElixir);
  }

  public static void DrawTeam(String str, int slot, boolean right)
  {
    int col = 2;
    col += slot * 27;
    int offset = right? -10 : 0;
    TextBox(30 + offset ,col,38,6,str);
  }

  public static void drawStats(String name, int hp, int maxHP, int evo, boolean good, int slot, boolean alive)
  {
    int thing = slot * 27;
    int offset = good? 0:-22;
    if (alive)
    {
      Game.drawText(name, 24 + offset, 2 + thing);
      Game.drawText("HP: " + colorByPercent(hp, maxHP), 25 + offset, 2 + thing);
      Game.drawText("Evo Duration: " + evo, 26 + offset, 2 + thing);
    }
    else
    {
      Game.drawText(name + " is dead.", 24 + offset, 2 + thing);
    }

  }

  public static void main (String[] args) {
    run();
  }

}
