import java.util.Arrays;
import java.util.Scanner;
 
public class TicTacToe {
  
    public static int checkForRowWin(String[][] board, char player){
    // variable to track row that holds a win
    int rowNumber = 0;
    for(int row = 0; row <3; row++) {
      if(board[row][0].equals(" " + player + " ") &&
        board[row][1].equals(" " + player + " ") &&
        board[row][2].equals(" " + player + " ")) {
        // Add 1 to row number to match human count (starting wiht 0)
        rowNumber = row + 1;
        break;
        }
    }
    // If rowNumber > 0, there is a winning row
    return rowNumber;
  }
    public static int checkForDiagWin(String[][] board, char player){
      // variable to track diagonal that holds a win
      int diagNumber = 0;
      for(int diag = 0; diag<3; diag++) {
        if(board[0][0].equals(" " + player + " ") &&
          board[1][1].equals(" " + player + " ") &&
          board[2][2].equals(" " + player + " ") ||
          board[2][0].equals(" " + player + " ") &&
          board[1][1].equals(" " + player + " ") &&
          board[0][2].equals(" " + player + " ")) {
        diagNumber = diag + 1;
        break;
      }
    }
  return diagNumber;
    }

  public static int checkForColWin(String[][] board, char player){
    // variable to track col that holds a win
    int colNumber = 0;
    for(int col = 0; col<3; col++) {
      if(board[0][col].equals(" " + player + " ") &&
        board[1][col].equals(" " + player + " ") &&
        board[2][col].equals(" " + player + " ")) {
        // add 1 to col number to match human count (starting with 0)
        colNumber = col + 1;
        break;
        }
    }
    // If colNumber > 0, there is a winning column
    return colNumber;
  }
 
  public static void main(String[] args) {
    String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};
        
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
        
    Scanner input = new Scanner(System.in);
    
    // Initialize col & row so that the input validation works
    int col = 0;
    int row = 0;
    // variable to keep track of current player
    char player;

    // for loop to provide a total of 9 turns
    for(int turns = 0; turns < 9; turns++){ 
      // if an even turn number, player is x
      if(turns % 2 == 0) {
        player = 'X';
      }
      // otherwise, odd turns are O's turn
      else{
        player = 'O';
      }
// Check if col or row is less than 1 or greater than 3
    System.out.println("DEBUG: " + turns);
      while(col < 1 || col > 3 || row < 1 || row > 3){
    System.out.print(player + " - Select row (1-3) & select column (1-3) ");
    System.out.print("separated by a space: ");
    row = input.nextInt();
    col = input.nextInt();
      }
    if(board[row - 1][col - 1].equals(" - ")) {
      // use player to provide character X or O 
      board[row - 1][col - 1] = " " + player + " ";
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    }
    else {
      // if position is already taken, print message
      System.out.println("Sorry, that spot is taken, please try again.");
      // decrement turns counter by 1, to roll back so player doesnt lose their turn.
      turns--;
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    
    }
      // reset col and row, without this it their value will alway be the input resulting in an infinite loop.
    col = 0;
    row = 0;


    int winningRow = checkForRowWin(board, player);
    if(winningRow > 0) {
      System.out.println("Win by " + player + " on row " + winningRow);
      break;
    }
    int winningCol = checkForColWin(board, player);
    if(winningCol > 0) {
      System.out.println("Win by " + player + " on col " + winningCol);
      break;
    }
    int winningDiag = checkForDiagWin(board, player);
      if(winningDiag > 0) {
        System.out.println("Win by " + player + " on Diagonal ");
        break;      
      }

      
  }
    input.close();
    System.out.println("End Match");
  }
  
}