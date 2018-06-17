public class BoardSpace {
	private int value;
	private int index;
	private Player player;
	private String type;
	public BoardSpace(){
		player = null;
	}
	public BoardSpace(Player player){
		this.player = player;
	}
	public int getValue(){
		if(value>0){
			return value;
		}
		else{
			return 0;
		}
	}
	public void setValue(int value){
		this.value = value;
	}
	public int getIndex(){
		return index;
	}
	public void setIndex(int newIndex){
		this.index = newIndex;
	}
	public Player getPlayer(){
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}
	public String getType(){
		return type;
	}
	public boolean setType(String type){
		if(type.equals("E")||type.equals("R")||type.equals("S")){
			this.type=type;
			return true;
		}
		else{
			return false;
		}
	}
	
}
