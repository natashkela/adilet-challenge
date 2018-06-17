public class BoardGame {
	int spaceNumber = 20; 
	int playerNum = 1; 
	DoublyLinkedList<BoardSpace> board;
	public BoardGame(int playerNum){
		if(playerNum<=1){
			this.playerNum = 1;
			this.board = createBoardForOnePlayer();
		}
		else{
			this.playerNum = playerNum;
		}
	}
	public DoublyLinkedList<BoardSpace> createBoardForOnePlayer(){
		Player player1 = new Player();
		DoublyLinkedList<BoardSpace> board = new DoublyLinkedList<BoardSpace>();
		BoardSpace endspace = new BoardSpace();
		endspace.setType("E");
		board.addFirst(endspace);
		BoardSpace newBoardSpace = new BoardSpace();
		//initialize the space numbers on the board
		for(int i=0;i<spaceNumber;i++){
			newBoardSpace = new BoardSpace();
			newBoardSpace.setType("R");
			board.addFirst(newBoardSpace);
		}
		//add starting point in the beginning
		BoardSpace startSpace = new BoardSpace();
		if(startSpace.setType("S")){
			board.addFirst(startSpace);
		}
		//player rolls a die
		int value = player1.makeAmove();
		newBoardSpace = board.first();
		while(!newBoardSpace.getType().equals("E")){
			//if it is unoccupied, then the current player adds the number on the square
			if(newBoardSpace.getValue()==0){
				newBoardSpace = board.nextSpace(newBoardSpace, value);
				newBoardSpace.setValue(value);
			}
			else{
				
			}
		}
		return board;
	}
	
}
