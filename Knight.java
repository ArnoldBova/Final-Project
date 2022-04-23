import java.util.List;

class Knight extends Thread{
    protected boolean captured;
    protected Tile position;
    

    public Knight(boolean captured, Tile position){
        this.position = position;
        this.captured = captured;
    }
    //to set the piece for removal from the board
    public Boolean setCaptured(){
        captured = true;
        return true;
    }
    //To help in determining if a move will end up being valid
    public Tile getPosition(){
        return position;
    }
    //To determine the validity of a move and to move the piece to 
    //said tile. 
    public Tile moveTo(Tile end){
        
    }



}