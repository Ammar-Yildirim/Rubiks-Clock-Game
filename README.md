# Rubik's Clock Game

## Overview

This Java program implements the Rubik's Clock game, featuring a 3x3 grid of clocks, each displaying a time between 1 and 12. The goal is to press buttons strategically placed between clocks to set all clocks to show 12. The game provides a graphical user interface (GUI) where players can interact with the clocks and buttons.

## Game Rules

- The game starts with 9 clocks arranged in a 3x3 grid.
- Each clock can display a time between 1 and 12 (hour only).
- Each of the four clocks on a corner have a button placed between them.
- Pressing a button increases the time on the four adjacent clocks by one.
- The player wins when all clocks show 12.

## How to Play

1. **Initial Setup**: Launch the game, and you will see a 5x5 matrix on the GUI containing clocks, buttons, and empty labels.
2. **Button Clicks**: Click on the buttons strategically placed at (1,1), (3,1), (1,3), and (3,3) to increase the time on adjacent clocks by one.
3. **Winning**: The game recognizes when all clocks show 12, and a message box will display the number of steps it took to solve the game.
4. **Restart**: After completing a game, a new game starts automatically.

## Game Components

- **Clocks Class**: Manages the logic of the clocks, including changing clock times, resetting clocks, setting up random initial clock times, and checking for game completion.
- **RubiksClockGUI Class**: Handles the graphical user interface, initializes the frame, clocks, and components, sets up the menu bar with options to reset the puzzle and exit the game, and refreshes the display.
- **ButtonListener Class**: Listens for button clicks, changes the clocks, increments the step counter, and refreshes the display.

## Test Cases

1. The game loads with 9 clocks, each four clocks on the corner have a button in the middle.
2. Each clock is assigned a random value as its time, ensuring solvability.
3. Clicking on a button increases the time by one unit for each of the adjacent clocks.
4. Clock times reset to 0 if they go beyond 12.
5. Each click on a button is counted, and the step count is displayed at the end of the game.
6. Menu bar options include resetting the game and exiting.
   - a. Clicking on reset reloads the game.
   - b. Clicking on exit exits the game.
7. Clicking "ok" in the end-of-game message box reloads the game.
