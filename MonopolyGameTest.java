import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MonopolyGameTest {
	static Board board;
	static Die die,die2;

	@Test
	public void testMoveIt() throws IOException {
		board=new Board(5);
		die = new Die();
		die2 = new Die();
		Player testPlayer = board.getPlayer(1);
		Piece testPiece = testPlayer.getPlayerPiece();
		int initialLocation = testPiece.getLocation().getSquareID();
		int finalLocation;
		
		int distance=testPlayer.tossDice(die, die2);
		
		moveIt(testPlayer, testPiece,distance);
		
		finalLocation = testPiece.getLocation().getSquareID();
		
		/*We want to know that the method moveIt works or not.
		  So we get initial location and compare it with final location.
		  If they are same, it means that piece could not moved. here we can catch the error.
		  */
		Assert.assertTrue("There is an error. Player's piece did not moved.", initialLocation!=finalLocation);

	}
	
	public static void moveIt(Player player, Piece piece, int dice){
		if(piece.getLocation().getSquareID()+dice > board.getSquares().length ||
				(piece.getLocation().getSquareID()+dice)%board.getSquares().length == 0){
			piece.turnCounter++;
		}
		int newLocation = (piece.getLocation().getSquareID()+dice)%board.getSquares().length;
		piece.setLocation(board.getSquare(newLocation));
		piece.getLocation().act(player,board,dice);
	}



}
