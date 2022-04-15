### Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland

# Game Idea: Chess

## Game Mechanics

# The Board Structure

The `Board` will be an object constructed of `Tile` Objects. Each will be able to store its color, current piece and position relative to other pieces.

- ## Tile

  - Store the piece thats on the tile
  - Color of the tile
  - all pieces around the tile in the main cardinal directions
  - getters and setters

- ## Board
  - ArrayList of all of the tiles
  - Some way to paint them, along with the pieces on the JPanel

# Pieces Structure

General `Piece` class that each individual type of piece will extend.

```java
public class Knight extends Piece
```

- ## Piece
  - Abstract class
  - Extends Thread to animate the piece moving around the board
  - Reference to the tile that its on.
  - Color of the piece
  - Move method
  - Capture method to Capture Pieces
