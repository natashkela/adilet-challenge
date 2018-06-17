import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		System.out.println("What is the game number you want to display?");
		int gameNumberToDisplay = read.nextInt();
		System.out.println("How many players are playing the game?");
		int numOfPlayers = read.nextInt();
		System.out.println("How many moves are made in the game in total?");
		int movesMadeSoFar = read.nextInt();
		
		BoardGame board = new BoardGame(numOfPlayers);
		
		
	}
}
