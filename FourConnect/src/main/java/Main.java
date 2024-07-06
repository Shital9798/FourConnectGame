import java.util.Scanner;

public class Main {
  private static final int ROWS = 6;
  private static final int COLS = 7;
  private static final char PLAYER1 = 'X';
  private static final char PLAYER2 = 'O';
  private static final char EMPTY = ' ';

  private char[][] board;
  private boolean player1Turn;

  public Main() {
    resetBoard();
    player1Turn = true;
  }

  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Connect Four!");
    System.out.println("Player 1 is 'X' and Player 2 is 'O'.");

    while (true) {
      clearScreen();
      printBoard();
      System.out.println("It's Player " + (player1Turn ? "1 (X)" : "2 (O)") + "'s turn.");
      int column = getColumnInput(scanner);
      if (isValidMove(column)) {
        makeMove(column);
        if (checkWin()) {
          clearScreen();
          printBoard();
          System.out.println("Player " + (player1Turn ? "1 (X)" : "2 (O)") + " wins!");
          if (!playAgain(scanner)) {
            break;
          } else {
            resetBoard();
            player1Turn = true;
          }
        } else if (isBoardFull()) {
          clearScreen();
          printBoard();
          System.out.println("It's a tie!");
          if (!playAgain(scanner)) {
            break;
          } else {
            resetBoard();
            player1Turn = true;
          }
        }
        player1Turn = !player1Turn;
      } else {
        System.out.println("Invalid move, try again.");
      }
    }
    System.out.println("Thank you for playing!");
    scanner.close();
  }

  private boolean playAgain(Scanner scanner) {
    System.out.print("Do you want to play again? (yes/no): ");
    String response = scanner.next().toLowerCase();
    return response.equals("yes");
  }

  private void resetBoard() {
    board = new char[ROWS][COLS];
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        board[i][j] = EMPTY;
      }
    }
  }

  private void printBoard() {
    System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7");
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private void clearScreen() {
    // Clear the screen by printing ANSI escape code
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private int getColumnInput(Scanner scanner) {
    int column = -1;
    while (column < 0 || column >= COLS) {
      System.out.print("Enter a column (1-7): ");
      column = scanner.nextInt() - 1; // adjust for 0-based indexing
      if (column < 0 || column >= COLS) {
        System.out.println("Invalid column, please enter a number between 1 and 7.");
      }
    }
    return column;
  }

  private boolean isValidMove(int column) {
    return board[0][column] == EMPTY;
  }

  private void makeMove(int column) {
    for (int i = ROWS - 1; i >= 0; i--) {
      if (board[i][column] == EMPTY) {
        board[i][column] = player1Turn ? PLAYER1 : PLAYER2;
        break;
      }
    }
  }

  private boolean checkWin() {
    // check horizontal wins
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS - 3; j++) {
        if (board[i][j] != EMPTY && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]
            && board[i][j] == board[i][j + 3]) {
          return true;
        }
      }
    }

    // check vertical wins
    for (int i = 0; i < ROWS - 3; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] != EMPTY && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]
            && board[i][j] == board[i + 3][j]) {
          return true;
        }
      }
    }

    // check diagonal wins
    for (int i = 0; i < ROWS - 3; i++) {
      for (int j = 0; j < COLS - 3; j++) {
        if (board[i][j] != EMPTY && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
            && board[i][j] == board[i + 3][j + 3]) {
          return true;
        }
      }
    }

    for (int i = 3; i < ROWS; i++) {
      for (int j = 0; j < COLS - 3; j++) {
        if (board[i][j] != EMPTY && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2]
            && board[i][j] == board[i - 3][j + 3]) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean isBoardFull() {
    for (int i = 0; i < COLS; i++) {
      if (board[0][i] == EMPTY) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Main game = new Main();
    game.playGame();
  }
}
