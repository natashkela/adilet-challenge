
public class BoardSpace {
    int row;
    int col;
    int value;
    String type;
    // "R" for regular  "E" for end node of the Board
    public String toString() {
    	return "(" + row + "," + col + ")-" + value ;
    }
}
