# SnakeGame2D

A simple 2D snake game made in java. The user controlls the snake, trying to collect as much food as possible.
With each bite of food the snake's length increases. The goal is to achieve the highest score possible.
The game ends once the snake's head hits it's own body. Top five high scores are memorized.

## Getting started
Run the Main class from the main_module package or run the 'SnakeGame.jar' file.

Select the desired difficulty, and click on 'START GAME'.

User arrow keys for movement.

## Implementation
- The terrain, snake and food are drawn using Graphics2D in java.
- The food is represented as a red rectangle. It's position randomly changes every time it's eaten.
The snake moves by 10px, so I made the food positions dividable by 10 to align the food and the snake.
- The snake is represented as an array of white rectangles. The head is fully colored in white, while the body only has it's borders colored.
The snake's body has to follow the head, so I've added a list of turn directions to each of the body elements. Once the turn has been made, the
direction is removed from the list.
- Collision detection checks whether the rectangle bounds of the head intersect the rectangle bounds of the food or the rest of the body.
- The ScheduledThreadPoolExecutor is used to repaint the window in order to visualize movement. Depending on the selected difficulty it
repaints every 30ms, 50ms and 70ms. Once the game window is closed, the executor shuts down.

**Note:** To make life easier, none of the windows are resizable.
