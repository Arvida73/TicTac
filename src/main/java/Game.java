import java.util.Scanner;


public class Game {

    private final Board board; // keeps track of the player's moves and the game's status
    private boolean turn; // true if it's X's turn, false if it's O's turn

    public Game() {
    	board = new Board();
    	turn = true;
    }

    public void print() {
    	for (int y = 0; y < 3; ++y) {
    		System.out.println("+-+-+-+");
    		for (int x = 0; x < 3; ++x) {
    			System.out.print("|");
    			switch (board.getSpace(x, y)) {
					case EMPTY: System.out.print(" ");
    				break;
    			case X: System.out.print("X");
    				break;
    			case O: System.out.print("O");
    				break;
    			}
    		}
    		System.out.println("|");
    	}
    	System.out.println("+-+-+-+");
    }

    public void runGame() {
    	Board.Status status = Board.Status.STATUS;
    	
    	Result();
    	while (status == Board.Status.STATUS) {
    		print();
        	promptMove();
        	status = Result();
    	}
    	print();
        System.out.println("Q (to exit)");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void promptMove() {
    	System.out.println("Enter an (x,y) coordinate for your next move (0,0) -> (2,2)");
    	Scanner scan = new Scanner(System.in);
    	scan.useDelimiter("[,()]? *");
    	
    	int x = scan.nextInt();
    	int y = scan.nextInt();
    	
    	if (x > 2 || x < 0 || y > 2 || y < 0 || board.getSpace(x,y) != Board.Space.EMPTY) {
    		System.out.println("Invalid coordinates");
    		promptMove();
    	}
    	else
    	{
    		board.setSpace(x,y, turn ? Board.Space.X : Board.Space.O);
    		turn = !turn;
    	}
    }

    public Board.Status Result() {
    	String result = "";
    	Board.Status status =  board.getStatus();
    	
    	switch (status) {
    	case DRAW: result = "The game has come to a draw.";
    		break;
    	case O_WON: result = "O has won the game.";
    		break;
    	case STATUS: result = "Play on" + (turn ? "; X's turn" : "; O's turn");
    		break;
    	case X_WON: result = "X has won the game.";
    		break;
    	}
    	
    	System.out.println(result);
    	return status;
    }

}
