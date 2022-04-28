package src.pieces;

import java.util.ArrayList;
import src.game.Tile;
import src.structures.Piece;

public class Queen extends Piece {

  public Queen(Tile tile, boolean isWhite) {
    super(tile, isWhite);
  }

  @Override
  public ArrayList<Tile> getValidMoves() {
    ArrayList<Tile> outcomes = new ArrayList<>();
    boolean white = this.isWhite();
    Tile up = this.getTile().up();
    Tile down = this.getTile().down();
    Tile left = this.getTile().left();
    Tile right = this.getTile().right();
    Tile upLeft = this.getTile().up().left();
    Tile upRight = this.getTile().up().right();
    Tile downLeft = this.getTile().down().left();
    Tile downRight = this.getTile().down().right();
    boolean loopDone = false;
    
      while (!loopDone) {
        if (up.hasPiece()) {
          if (up.piece().isWhite() != white) {
            outcomes.add(up);
          }
          loopDone = true;
        } else {
            outcomes.add(up);
            up = up.up();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (down.hasPiece()) {
          if (down.piece().isWhite() != white) {
            outcomes.add(down);
          }
          loopDone = true;
        } else {
            outcomes.add(down);
            down = down.down();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (right.hasPiece()) {
          if (right.piece().isWhite() != white) {
            outcomes.add(right);
          }
          loopDone = true;
        } else {
            outcomes.add(right);
            right = right.right();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (left.hasPiece()) {
          if (left.piece().isWhite() != white) {
            outcomes.add(left);
          }
          loopDone = true;
        } else {
            outcomes.add(left);
            left = left.left();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (upLeft.hasPiece()) {
          if (upLeft.piece().isWhite() != white) {
            outcomes.add(upLeft);
          }
          loopDone = true;
        } else {
            outcomes.add(upLeft);
            upLeft = upLeft.up().left();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (upRight.hasPiece()) {
          if (upRight.piece().isWhite() != white) {
            outcomes.add(upRight);
          }
          loopDone = true;
        } else {
            outcomes.add(upRight);
            upRight = upRight.up().right();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (downLeft.hasPiece()) {
          if (downLeft.piece().isWhite() != white) {
            outcomes.add(downLeft);
          }
          loopDone = true;
        } else {
            outcomes.add(downLeft);
            downLeft = downLeft.down().left();
        }
      }
      loopDone = false;
      while (!loopDone) {
        if (downRight.hasPiece()) {
          if (downRight.piece().isWhite() != white) {
            outcomes.add(downRight);
          }
          loopDone = true;
        } else {
            outcomes.add(downRight);
            downRight = downRight.down().right();
        }
      }

    return outcomes;
  }

  @Override
  public void run() {}
  //
  //    public int getMoves() {
  //        return moves;
  //    }
  //
  //    public list getMovements(int moves) {
  //        if (moves > 0) {
  //            movemnts.remove(0);
  //            return movements;
  //        } else {
  //            return moves;
  //        }
  //    }
  //
  //    public boolean getCaptured() {
  //        return captured;
  //
  //    }
  //
  //    public Tile getPostion() {
  //        return position;
  //    }
  //
  //    public void setCaptured() {
  //        captured = true;
  //    }
  //
  //    public void moveTo(Tile end) {
  //        position = end;
  //    }

}
