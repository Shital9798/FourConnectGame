# Connect Four Game

This is a simple console-based implementation of the classic Connect Four game in Java.

## How to Play

1. The game is played on a 6x7 grid.
2. There are two players: Player 1 (X) and Player 2 (O).
3. Players take turns to drop their discs into one of the columns.
4. The game continues until one player gets four of their discs in a row (horizontally, vertically, or diagonally) or the board is full.

## Features

- **Interactive Gameplay**: The game announces each player's turn and validates moves.
- **Winner Announcement**: The game announces the winner when a player gets four discs in a row.
- **Play Again Option**: After a game ends, players can choose to play again or exit the game.
- **Clear Screen**: The screen is cleared after each move to show an updated board.

## How to Run

1. Ensure you have Java installed on your system.
2. Clone this repository or download the code files.
3. Open a terminal and navigate to the directory containing the files.
4. Compile the Java file:
    ```sh
    javac Main.java
    ```
5. Run the compiled Java file:
    ```sh
    java Main
    ```

## Code Explanation

### Main Class

The `Main` class contains all the game logic and methods to manage the game.

- **Constructor**: Initializes the game board and sets the starting player.
- **playGame()**: The main game loop that handles player turns, move validation, and checks for a win or a tie.
- **playAgain(Scanner scanner)**: Prompts the user to play again or exit.
- **resetBoard()**: Resets the game board for a new game.
- **printBoard()**: Prints the current state of the game board.
- **clearScreen()**: Clears the console screen.
- **getColumnInput(Scanner scanner)**: Gets and validates the column input from the player.
- **isValidMove(int column)**: Checks if the selected column is valid for a move.
- **makeMove(int column)**: Makes a move for the current player in the selected column.
- **checkWin()**: Checks for a win condition (four discs in a row).
- **isBoardFull()**: Checks if the board is full.

### How to Modify

Feel free to modify the code to add new features or improve the gameplay experience. Contributions are welcome!

