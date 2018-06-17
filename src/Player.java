
public class Player {
    int playerScore;
    int playerMoves;
    public Player(){
    	this.playerScore = 0;
    	this.playerMoves = 0;
    }
    public int increaseMoves(){
    	this.playerMoves++;
    	return playerMoves;
    }
    public int increasePlayerScore(int value){
    	this.playerScore += value;
    	return playerScore;
    }
}
