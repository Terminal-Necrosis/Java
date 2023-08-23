import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Warships {

  public static void main(String[] args) {
    // variables to preset color coding for use on player symbols.
  String red = "\u001B[31m";
  String yellow = "\u001B[33m";
  String reset = "\u001B[0m";
  
  
    
    // title for Warships
  System.out.print ("  _     _   _______   _______   _______   _     _   _______   _______   _______ \n" +
                    " | |   | | (  ___  ) (  ____ ) (  ____ | | |   | | |__   __| (  ____ ) (  ____ | \n" +
                    " | |   | | | (   ) | | (    )| | (   |_| | )   ( |    ) (    | (    )| | (   |_| \n" +
                    " | | _ | | | (___) | | (____)| | (_____  | (___) |    | |    | (____)| | (_____  \n" +
                    " | |( )| | |  ___  | |     __) (_____  ) |  ___  |    | |    |  _____) (_____  ) \n" +
                    " | || || | | (   ) | | (( (     _    ) | | (   ) |    | |    | (        _    ) | \n" +
                    " | () () | | )   ( | | ) ( (_  | |___) | | )   ( |  __) (__  | )       | |___) | \n" +
                    " (_______) |)     (| |)   (__| |_______) |_|   |_| |_______| |_|       |_______) \n" );
    // end title for Warships
    System.out.println("Welcome to Warships, a more action-oriented take on the classic battleship board game." + "\n");

  int x = 1;
  while(x == 1) {
    // main selection menu
    System.out.print("Please enter a selection: \n" +
                    "1: How to Play and Rules\n" +
                    "2: New Game\n" + 
                    "3: Exit Program\n" +
                    "Your Selection: ");
    Scanner input = new Scanner(System.in);
   try{
    int selection = input.nextInt();

   
      if (selection == 1) {   
        
        // display rules
    System.out.println("\n" + "Warships: Rules" + "\n" +
    "Warships is a modified version of the classic board game Battleship.\n" + 
    "It has been designed to be played by 2 players using a single board.\n" +
    "The game is played on a 10x10 board, the ships are hidden from both players.\n" +
    "There are 5 ships total: \n\t" + 
    "1: 5x1 ship\n\t" +
    "1: 4x1 ship\n\t" +
    "2: 3x1 ships\n\t" +
    "1: 2x1 ship\n");
    
        // pause for readability, enter to proceed
        System.out.println("Press \"Enter\" to contine...");
        Scanner proceed = new Scanner(System.in);
        proceed.nextLine();
    System.out.println("Each player will take turns declaring their targeting locations.\n" +
    "The targeting locations are declared in classic Battleship fashion. IE: A1, C7, D3, etc.\n" +
    "When a player misses, the location will be marked with a white O. \n" +
    "If a player hits a ship, the location will be marked with an X in that players color.\n" +
    "Player 1 is" + yellow + " yellow" + reset + "\n" +
    "Player 2 is" + red + " red" + reset + "\n" +
    "If a player hits a ship they will get to take their turn again until they miss.\n" +
    "Each hit a player makes will award them 1 point.\n" +
    "Players will alternate turns until no ships (therefore no points) remain in play.\n" +
    "The players points will then be tallied and the winner declared.\n");

        // pause for readability, enter to proceed
    System.out.println("Press \"Enter\" to return to the Main Menu.");
        proceed.nextLine();

        continue;
        
      }
           
      else if (selection == 2) {

      // declare variables for gameplay
        int P1Score = 0;
        int P2Score = 0;
        String Player_1 = "";
        String Player_2 = "";
        String attSymbol = "";

        System.out.println("\n" + "New Game Start!" + "\n");

        
        // set loop so that player 1 is required to adhere to minimal naming standards
        int unnamed1 = 1;
          while (unnamed1 == 1) {
        // obtain player 1s name and save to variable
        System.out.print("Please Enter Name for Player 1: ");
        Scanner P1 = new Scanner(System.in);
        Player_1 = P1.nextLine();
        // require player1's name to be a non-empty string
            if( Player_1 == "") {
              System.out.println("Player 1 requires a name, please input the name or handle of player 1.");
                continue;
            }
        System.out.println("Player 1 is " + Player_1 + "." + "\n");
            unnamed1--;
          }

            // set loop so that player 2 is required to adhere to minimal naming standards
            int unnamed2 = 1;
            while (unnamed2 == 1) {
        // obtain player 2s name and save to variable
        System.out.print("Please Enter Name for Player 2: ");
        Scanner P2 = new Scanner(System.in);
        Player_2 = P2.nextLine();
        // require player2's name to be a non-empty string
            if( Player_2 == "") {
              System.out.println("Player 2 requires a name, please input the name or handle of player 2.");
                continue;
            }
        System.out.println("Player 2 is " + Player_2 + "." + "\n");
              unnamed2--;
            }  

        // loop installed to allow for multiple matches to be played without having to reinput player names or use the main menu.
        int play = 1;
        while (play == 1) {

        // pause before match start
        System.out.println("Press \"Enter\" to begin the match...");
        Scanner proceed = new Scanner(System.in);
        proceed.nextLine();

        
            // create & print board}
        String[][] board = gameBoard1();   
        for(int i = 0; i < 11; i++) {
          String baseBoard = Arrays.toString(board[i]);
          System.out.println("\t" + baseBoard); // prints the board for use
       } 
        // create target list , invisible to players
        String[] targets = getTargets();

        int match = 1;
        String player; // declare player variable
        while (match == 1) {
           for(int turns = 0; turns < 101; turns++){
               if(turns % 2 == 0) {
                   player = Player_1; // assign player variable to existing player names
                   attSymbol = yellow + " X " + reset; // assign players attack color
                   
               }
               else {
                   player = Player_2;
                   attSymbol = red + " X " + reset;
                   
               }

               // declare current players turn, and point value they possess
               Scanner strike = new Scanner(System.in);
               System.out.println("It is " + player + "'s turn.");
               if(player.equals(Player_1)){
                System.out.println(Player_1 + " has " + P1Score + " points.");
               }
               else if(player.equals(Player_2)){
                System.out.println(Player_2 + " has " + P2Score + " points.");
               }
               
               // declare rules for first coordinate declaration
               System.out.println("Please choose a target location, Column first then Row. Examples A4, c2");
               System.out.print("Column? (A-J): ");
               String charAtt = "";
               String coords = "";
               boolean charVal = false;
               boolean intVal = false;
               boolean coordVal = false;
               int numAt = 0;
               int row = 0;
               int col = 0;
       
               // create loop for testing and validating first coord is a valid and singular letter in the valid range of letters
               int attempt = 1;
               while(attempt == 1){
               //obtained and formated letter component of attack coords.
               charAtt = strike.nextLine();    
               charAtt = charAtt.toUpperCase();
                   if(charAtt.length() > 1){
                       System.out.println("One input at a time please, Alpha column only for first input.");
                       continue;
                   }
                   else{
                       attempt--;
                   }
       
               }
               // create array of valid range of letters to use for coordinate verification
               char[] columns = "ABCDEFGHIJ".toCharArray();
               try{  
       
                   // validating letter of attack coords.
                   for(int i = 0; i < 10; i++) {
                       if(charAtt.charAt(0) == columns[i]) {
                           charVal = true;
                       }
                   }
               }catch(Exception nonStr){        }// stubbed exception to keep it from crashing if "" is input, no message needed since the charVal remains false and it loops back anyway
                       if(charVal == false) {
                           System.out.println("Column entry is not a valid input, please try again.");
                           turns--;
                           continue;                   
                       }   
                           int attempt2 = 1;
                           try{
       
                    // obtain the numeric component of attack coords.
                    while(attempt2 == 1){
                      System.out.print("Row? (1-10): ");
                  
                      // validating the numeric component of attack coords.
                      numAt = strike.nextInt();
                      if(numAt >= 1 && numAt <= 10) {
                          intVal = true;
                          attempt2--;               
                      }
                      else if(numAt < 1 || numAt > 10){
                          System.out.println("Row entry is not a valid input, please try again.");
                          continue;
                      }  
                  }
                       }catch(Exception nonInt){
                           System.out.println("A non Integer value has been entered. Please try again.");
                           turns--;
                           continue;
                       }    
                       
                        // combine 2 coord components to create coord for final validation
                        coords = charAtt + numAt;

                        // validation that input coords exist within targeting array
                        if(Arrays.asList(targets).contains(coords)){
                          coordVal = true;
                          
                          }
                          else {
                          coordVal = false;
                          
                        }
                        
                        //convert Alphabetic coord into numeric coord for the array.
                        String conversion = toString(columns);
                        int convAtt = conversion.indexOf(charAtt) + 1;
                        
                        //converting attack coords into row and column for readability
                        row = numAt;
                        col = convAtt;
                        
                        //inspect target array location for prior use, if so reject coords.
                        if(board[row][col].equals(yellow + " X " + reset) || board[row][col].equals(red + " X " + reset) || board[row][col].equals(" O ") ){
                          System.out.println("That location has already been taken, try again.");
                          for(int i = 0; i < 11; i++) {
                            String baseBoard = Arrays.toString(board[i]);
                            System.out.println("\t" + baseBoard); // prints the board for use
                          }
                          turns--;
                          continue;
                        }

                        // final validation that all components of attack coords are valid.
                          else if(charVal == true && intVal == true && coordVal == false){
                            board[row][col] = " O ";
                            System.out.println(player + "'s attack has missed.");
                            for(int i = 0; i < 11; i++) {
                              String baseBoard = Arrays.toString(board[i]);
                              System.out.println("\t" + baseBoard); // prints the board for use
                            }
                          }
                        
                        else if(charVal == true && intVal == true && coordVal == true){
                          board[row][col] = attSymbol;
                          System.out.println(player + "'s attack was a direct hit!!");
                          turns--;
                          if(player.equals(Player_1)){
                            P1Score++;
                            for(int i = 0; i < 11; i++) {
                              String baseBoard = Arrays.toString(board[i]);
                              System.out.println("\t" + baseBoard); // prints the board for use
                            }
                          }
                          else if(player.equals(Player_2)){
                            P2Score++;
                            for(int i = 0; i < 11; i++) {
                              String baseBoard = Arrays.toString(board[i]);
                              System.out.println("\t" + baseBoard); // prints the board for use
                            }
                          }
                          
                          // checks to make sure maximum score has not been reached, if it has it ends the game.
                          if(P1Score + P2Score == 17){
                            System.out.println("The game is over!!");
                            if(P1Score > P2Score){
                              System.out.println("The final score was: \n\t" + Player_1 + " with " + P1Score + " points!\n\t" + "and\n\t" + Player_2 + " with " + P2Score + " points!" );
                              System.out.println(Player_1 + " is the victor!");
                              match--;
                              P1Score = 0;
                              P2Score = 0;
                              break;
                            }
                            else {
                              System.out.println("The final score was: \n\t" + Player_1 + " with " + P1Score + " points!\n\t" + "and\n\t" + Player_2 + " with " + P2Score + " points!" );
                              System.out.println(Player_2 + " is the victor!");
                              P1Score = 0;
                              P2Score = 0;
                              match--;
                              break;
                            }
                          }
                          else {
                            continue;
                          }                          
                        }
                   } 
               }

        int query = 1;
        while (query == 1 ){
        // offer to begin a new game or return to main menu.
        System.out.print("Would you like to play another game? (Y/N) ");
        Scanner sc = new Scanner(System.in);
        char rematch = sc.next().charAt(0);
        if (rematch == 'Y' || rematch == 'y'){
          query--;
          continue;
        }
        else if (rematch == 'N' || rematch == 'n'){
        System.out.println("Thank you for playing!");
          query--;
          play--;
        }
        else {
        System.out.println("That is not valid input, please enter either Yes (Y/y) or No (N/n).");
        }
      }
        }


      }

      else if (selection == 3) {
        // exit program
        System.out.println("Thank you for playing Warships!");
        break;
        
        }
        
      else {
        // display error messages
        System.out.println("You have made an invalid selection, please choose again." + "\n");
        continue;        
        }
    } catch(Exception nonInt) {
     // error catch for non-int entries
     System.out.println("Error Occured - User input is not a valid Integer, please try again." + "\n");
     continue;     
   }
  };    
}

// created toString method for comparing attack coordinates.
public static String toString(char[] Att){
  String string = new String(Att);
  return string;
}

  public static String red = "\u001B[31m";
  public static String blue = "\u001B[34m";
  public static String yellow = "\u001B[33m";
  public static String reset = "\u001B[0m";
  public static String[] targets = new String[17];

  // method for generating board as well as selecting ship layouts
public static String[][] gameBoard1(){
        String[][] board = new String[11][11];
        String arSpace = blue + " - " + reset;
          String[] alpha = {"   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J "};
          String[] numeric = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", "10 "};
          for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
              board[i][j] = arSpace;
              board[0][0] = "   ";
              for (int r = 1; r < 11; r++) {
                board[0][r] = alpha[r];
                for (int c = 1; c < 11; c++) {
                  board[c][0] = numeric[c];
                }
              }            
            }
              }


    return board;
  }
  // method for pulling targeting parameters to main
  public static String[] getTargets(){

                  // loop to make random redraw in the event i got my math wrong
                  int boardSelector = 1;
                  while (boardSelector == 1) {
                    // random method to chose the ships layouts and board configuration
                  Random rand = new Random();
                  int min = 0, max = 10;
                  int random = rand.nextInt(max - min + 1) + min;
                  if (random != 0 || random > 10) {
                    boardSelector--;
    
                    // switch system with 10 preconfigurated board layouts for semi-randomized play and expandablility by being able to add additional ship placements.
                  switch (random) {
                    
                    case 1: //write target values to targets array
                            targets[0] = "B1";
                            targets[1] = "C1";
                            targets[2] = "D1";
                            targets[3] = "E1";
                            targets[4] = "F1";
                            targets[5] = "H3";
                            targets[6] = "H4";
                            targets[7] = "D4";
                            targets[8] = "D5";
                            targets[9] = "D6";
                            targets[10] = "F7";
                            targets[11] = "G7";
                            targets[12] = "H7";
                            targets[13] = "B9";
                            targets[14] = "C9";
                            targets[15] = "D9";
                            targets[16] = "E9";
                    break;

                    case 2: //write target values to targets array
                    targets[0] = "F1";
                    targets[1] = "G1";
                    targets[2] = "H1";
                    targets[3] = "I1";
                    targets[4] = "B5";
                    targets[5] = "C5";
                    targets[6] = "D5";
                    targets[7] = "F6";
                    targets[8] = "G6";
                    targets[9] = "E8";
                    targets[10] = "F8";
                    targets[11] = "G8";
                    targets[12] = "F10";
                    targets[13] = "G10";
                    targets[14] = "H10";
                    targets[15] = "I10";
                    targets[16] = "J10";
                    break;

                    case 3: //write target values to targets array
                    targets[0] = "A1";
                    targets[1] = "B1";
                    targets[2] = "C4";
                    targets[3] = "D4";
                    targets[4] = "E4";
                    targets[5] = "F4";
                    targets[6] = "G4";
                    targets[7] = "J3";
                    targets[8] = "J4";
                    targets[9] = "J5";
                    targets[10] = "G6";
                    targets[11] = "G7";
                    targets[12] = "G8";
                    targets[13] = "B8";
                    targets[14] = "B9";
                    targets[15] = "B10";
                    targets[16] = "J6";
                    break;

                    case 4: //write target values to targets array
                    targets[0] = "C1";
                    targets[1] = "C2";
                    targets[2] = "C3";
                    targets[3] = "G1";
                    targets[4] = "H1";
                    targets[5] = "F4";
                    targets[6] = "F5";
                    targets[7] = "F6";
                    targets[8] = "F7";
                    targets[9] = "F8";
                    targets[10] = "A10";
                    targets[11] = "B10";
                    targets[12] = "C10";
                    targets[13] = "G10";
                    targets[14] = "H10";
                    targets[15] = "I10";
                    targets[16] = "J10";
                    break;

                    case 5://write target values to targets array
                    targets[0] = "A1";
                    targets[1] = "B1";
                    targets[2] = "C1";
                    targets[3] = "D1";
                    targets[4] = "F1";
                    targets[5] = "G1";
                    targets[6] = "H1";
                    targets[7] = "J6";
                    targets[8] = "J7";
                    targets[9] = "J8";
                    targets[10] = "J9";
                    targets[11] = "J10";
                    targets[12] = "F7";
                    targets[13] = "F8";
                    targets[14] = "A9";
                    targets[15] = "B9";
                    targets[16] = "C9";
                    break;

                    case 6: //write target values to targets array
                    targets[0] = "B1";
                    targets[1] = "B2";
                    targets[2] = "B3";
                    targets[3] = "F1";
                    targets[4] = "G1";
                    targets[5] = "H1";
                    targets[6] = "I1";
                    targets[7] = "J1";
                    targets[8] = "D6";
                    targets[9] = "D7";
                    targets[10] = "H8";
                    targets[11] = "I8";
                    targets[12] = "J8";
                    targets[13] = "A10";
                    targets[14] = "B10";
                    targets[15] = "C10";
                    targets[16] = "D10";
                    break;

                    case 7: //write target values to targets array
                    targets[0] = "A3";
                    targets[1] = "A4";
                    targets[2] = "A5";
                    targets[3] = "A6";
                    targets[4] = "A7";
                    targets[5] = "B3";
                    targets[6] = "B4";
                    targets[7] = "B5";
                    targets[8] = "B6";
                    targets[9] = "H6";
                    targets[10] = "H7";
                    targets[11] = "H8";
                    targets[12] = "D9";
                    targets[13] = "E9";
                    targets[14] = "F9";
                    targets[15] = "I10";
                    targets[16] = "J10";
                    break;

                    case 8://write target values to targets array
                    targets[0] = "E1";
                    targets[1] = "F1";
                    targets[2] = "G1";
                    targets[3] = "J2";
                    targets[4] = "J1";
                    targets[5] = "C4";
                    targets[6] = "C5";
                    targets[7] = "C6";
                    targets[8] = "D7";
                    targets[9] = "E7";
                    targets[10] = "F7";
                    targets[11] = "G7";
                    targets[12] = "H7";
                    targets[13] = "J7";
                    targets[14] = "J8";
                    targets[15] = "J9";
                    targets[16] = "J10";
                    break;

                    case 9: //write target values to targets array
                    targets[0] = "D1";
                    targets[1] = "E1";
                    targets[2] = "I3";
                    targets[3] = "I4";
                    targets[4] = "I5";
                    targets[5] = "I6";
                    targets[6] = "I7";
                    targets[7] = "H4";
                    targets[8] = "H5";
                    targets[9] = "H6";
                    targets[10] = "H7";
                    targets[11] = "A5";
                    targets[12] = "A6";
                    targets[13] = "A7";
                    targets[14] = "G8";
                    targets[15] = "G9";
                    targets[16] = "G10";
                    break;

                    case 10: //write target values to targets array
                    targets[0] = "A2";
                    targets[1] = "B2";
                    targets[2] = "C2";
                    targets[3] = "F4";
                    targets[4] = "G4";
                    targets[5] = "H4";
                    targets[6] = "J4";
                    targets[7] = "J5";
                    targets[8] = "J6";
                    targets[9] = "J7";
                    targets[10] = "C7";
                    targets[11] = "D7";
                    targets[12] = "B10";
                    targets[13] = "C10";
                    targets[14] = "D10";
                    targets[15] = "E10";
                    targets[16] = "F10";
                    break;
                  }
                }
                else {
                    continue;
                  }
                }
    return targets;
  }



}