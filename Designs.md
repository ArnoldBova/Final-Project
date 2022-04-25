## Class Player  
**Instance Variables**  
// Indicates if the player has lost  
boolean hasLost  

// The player's pieces    
Array pieces    

// The board the player is playing on   
Array tiles  

// The timer that tracks how much time this player has used  
Timer timer

**Methods**  
// Returns true if the player has lost, and false otherwise   
public void hasLost()    

//Moves one of the player's pieces to a new location on the board   
// (This could just be a random piece, or we could make subclasses for different levels of difficulty)  
public void movePiece()


## Class Timer extends Thread  
**Instance Variables**  
// True if the timer is stopped (such as when the game has ended, and when it is the other player's turn)  
boolean stopped  

// True if the game has ended (determines when the thread should stop running)  
boolean gameOver

// The maximum amount of time that the timer can run (in seconds)  
int maxDuration

// The time that the timer will display (in seconds)  
int timeElapsed  

**Methods**  
// Keeps track of the current time, and updates the elapsed time every second  
public void run()   

// Paints the current time that has elapsed  
public void paint()  

// Resets the time that has elapsed to zero (useful when starting a new game)  
public void reset()


// Converts a time in seconds to its equivalent time in minutes and seconds (This is the format that the timer will actually display)  
public String convertToMinutes()





