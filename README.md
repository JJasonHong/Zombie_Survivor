# Zombie Survival Game

## Overview

This is a basic 2D Zombie Survival Game built using Java Swing. In this game, the player can move around and shoot bullets to defeat waves of zombies that move towards the player. The goal is to survive as long as possible while fighting off the zombies coming from all sides.

## Features

- **Player Movement**: The player can move up, down, left, and right using the W, A, S, D keys or the arrow keys.
- **Shooting**: The player can shoot bullets in the direction they are facing (up, down, left, right) by pressing the space bar.
- **Zombies**: Zombies will spawn at random locations and move towards the player. The player must shoot the zombies before they reach them.
- **Game Over**: If a zombie reaches the player, the game ends with a "Game Over" message.
- **Survival**: If all zombies are defeated, the player survives the wave, and more zombies can be spawned.

## Installation and Running the Game

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your system.
- A text editor or IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

### How to Run

1. **Clone or Download the Project**:
   - Clone the project using Git:
     ```bash
     git clone https://github.com/your-repository/zombie-survival-game.git
     ```
   - Alternatively, download the ZIP file from the repository and extract it.

2. **Compile and Run**:
   - Open a terminal or command prompt and navigate to the project folder.
   - Compile the game:
     ```bash
     javac ZombieSurvivalGameGUI.java
     ```
   - Run the game:
     ```bash
     java ZombieSurvivalGameGUI
     ```

3. **Run in an IDE**:
   - Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse).
   - Locate and run the `ZombieSurvivalGameGUI.java` file.

## Controls

- **Move**: Use the arrow keys or W, A, S, D to move the player.
- **Shoot**: Press the space bar to shoot in the direction the player is facing.
  - **Up**: Press space while moving up (W or Up Arrow).
  - **Down**: Press space while moving down (S or Down Arrow).
  - **Left**: Press space while moving left (A or Left Arrow).
  - **Right**: Press space while moving right (D or Right Arrow).

## Game Mechanics

- **Player**: 
  - The player is a blue square that can move around the screen.
  - The player can shoot bullets in four directions.
  - The game ends when a zombie reaches the player.
  
- **Zombies**: 
  - Zombies spawn randomly around the player and move toward the player's position.
  - Zombies are red squares, and they follow the player in every direction.
  - Zombies can be killed by shooting them with bullets.

- **Bullets**:
  - Bullets are small yellow circles that are fired by the player.
  - Bullets disappear after they leave the screen or collide with a zombie.

## Future Enhancements

- **Health System**: Add a health system where the player can take multiple hits before the game is over.
- **Waves**: Implement waves of increasing difficulty, with more zombies spawning in each wave.
- **Power-ups**: Add power-ups like health packs or weapon upgrades.
- **Zombie Variations**: Introduce different types of zombies with unique abilities.

## Screenshots

(Add screenshots of the game running if available)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
