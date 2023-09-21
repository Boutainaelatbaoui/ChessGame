# Chess Console Application in Java

## Overview
This Java console application allows you to play the classic game of chess on your computer. It provides a simple and text-based interface for a two-player chess match.

## Project Structure
The project is organized as follows:
- `Chessboard.java`: Contains the chessboard representation and logic for piece movements and capturing.
- `Piece.java`: Defines the Piece class and its subclasses (Pawn, Rook, Knight, Bishop, Queen, King).
- `Player.java`: Represents a player with a name and a color (white or black).
- `ChessGame.java`: The main class that manages the game loop and player interactions.

## Getting Started
To run the chess game, follow these steps:

1. Clone this Git repository to your local machine:
   ```shell
   git clone <repository-url>

## Compilation and Execution

1. Compile the Java source code using a Java development environment of your choice.


2. Run the console application:
   ```shell
   java ChessGame
   
3. Follow the on-screen instructions to make your moves. The game will notify you of check and checkmate situations.

## Rules and Features

- The chessboard is displayed as an 8x8 grid with algebraic notation.


- You can move pieces by specifying the source and destination squares (e.g., "e2 e4" to move a pawn).


- The game validates moves and ensures they comply with the rules of chess.


- When a piece moves to a square occupied by an opponent's piece, the piece is captured and removed from the board.


- The game detects and announces check and checkmate situations.



Enjoy playing chess!