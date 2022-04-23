import java.util.List;
public class Bishop extends Thread{
    protected int moves;
    protected boolean captured;
    protected List[] movements;
    protected TIle position;

    public Pawn(int moves, boolean captured, List[] movements, Tile position){
        this.moves = moves;
        this.movements = movements;
        this.captured = captured;
        this.position = position;
    }
    public int getMoves(){
        return moves;
    }
    public list getMovements(int moves){
        if(moves > 0) {
            movemnts.remove(0);
            return movements;
        }else{
            return moves;
        }
    }

    public boolean getCaptured(){
        return captured;
    
    }

    public Tile getPostion(){
        return position;
    }

    

    public void setCaptured(){
        captured = true;
    }
    public void moveTo(Tile end){
        position = end;
    }

}
