# Tic-Tac-Toe-with-AI


Project Overview

🔧 Language:

Java

🕹️ main.java.org.example.Game Modes:

User vs User

User vs AI (Easy / Medium / Hard)

AI vs AI (any combination of difficulty levels)

🤖 AI Difficulty Levels:

Easy – Random moves

Medium – Strategic (win/block/fallback)

Hard – Perfect play via Minimax Algorithm

🛠️ Development Stages Summary

✅ Stage 1: Board Initialization & Input Validation

Render a 3x3 board with user-defined input.

Validate user input:

Must be two numbers.

Must be in range (1–3).

Cell must be unoccupied.

Determine turn based on board state.

Display game outcome:

main.java.org.example.Game not finished, X wins, O wins, Draw

✅ Stage 2: Add Easy AI

User plays as X, AI plays as O.

AI makes random valid moves.

Alternating turns until win/draw.

Handles input errors gracefully.

✅ Stage 3: main.java.org.example.Game Menu & main.java.org.example.Player Configuration

Add a command-based menu:

start

exit to quit the game

main.java.org.example.Player types:

user, easy

Example:

start user easy, start easy user, start easy easy, start user user

Displays "Bad parameters!" on invalid input.

✅ Stage 4: Add Medium AI

AI uses a rule-based strategy:

Make a winning move if possible.

Block the opponent from winning.

Otherwise, play randomly.

Introduced medium difficulty level.

Supports all valid player combinations.

✅ Stage 5: Add Hard AI with Minimax

Implemented the Minimax algorithm:

AI evaluates all possible moves recursively.

Plays optimally and never loses.

Introduced hard difficulty level.

Final AI plays perfectly against any opponent.
