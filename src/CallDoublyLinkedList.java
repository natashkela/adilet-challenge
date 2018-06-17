import java.util.Random;
import java.util.Scanner;

public class CallDoublyLinkedList {
	public static void main(String[] args) {
	     Scanner read = new Scanner(System.in);
	     System.out.println("How many players are playing the game?");
	     int numOfPlayers = read.nextInt();
		 BoardSpace space = null ;
		 Random r = new Random();
	     DoublyLinkedList<BoardSpace> mylist = new DoublyLinkedList<BoardSpace>();
	     space = new BoardSpace();
    	 space.type = "End";
    	 mylist.addFirst(space);
	     for (int i = 0;  i<20; i++) {
	    	 space = new BoardSpace();
	    	 space.row = i/5;
	    	 space.col = i%5;
	    	 space.type = "Regular";
	    	 space.value = 0;
	    	 mylist.addFirst(space);
	     }
	     if(numOfPlayers==1){
		     Player player = new Player();
		     while (!space.type.equals("End")&&player.playerScore<40) {
		    	 if(space.type.equals("End")){
		    		 space = mylist.first();
		    	 }
		    	 player.increaseMoves();
		    	 int value = r.nextInt(6)+1;
		    	 space.value = value;
		    	 player.increasePlayerScore(value);
		    	 System.out.println(player.playerScore + "-" + player.playerMoves);
		    	 int jumpdistance = value;
		    	 space = mylist.nextSpace(space, jumpdistance);
		    	 if(player.playerScore%4==0){
		    		 space = mylist.first();
		    	 }
		    	 if(player.playerScore>=40){
		    		 break;
		    	 }
		     }
		     System.out.println(mylist.toString());
		     System.out.println("Final Stats: " + player.playerScore + "-" + player.playerMoves);
	     }
	}

}
