import java.util.Random;
public class Player {
	private int totalMoves;
	private int totalScore;
	int maxScore = 40;
	BoardSpace currSpace = null;
	//creates a player with empty parameters
	public Player(){
		this.totalMoves = 0;
		this.totalScore =0;
	}
	public int getTotalScore(){
		return totalScore;
	}
	public int getTotalMoves(){
		return totalMoves;
	}
	public void increaseScoreBy(int value){
		totalScore = totalScore + value;
	}
	public void addMove(){
		totalMoves+=1;
	}
	//generate a random number from 1 to 6
	public int rollADie(){
		Random r = new Random();
		return r.nextInt(6)+1; 
	}
	public int makeAmove(){
		addMove();
		int points = rollADie();
		increaseScoreBy(points);
		return points;
	}
	public boolean isWin(){
		return totalScore >= maxScore;
	}
}
