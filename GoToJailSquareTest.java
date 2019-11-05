import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class GoToJailSquareTest {
	
	@Test
	public final void testAct() throws IOException {
		Board board;
		board= new Board(3);
		Player player = new Player("test player");
		Piece piece = new Piece("test piece");
		Square location = board.getSquare(30);
		Square newLocation = board.getSquare(10);
		int dice = 0;
 		player.setPlayerPiece(piece);
		piece.setLocation(location);
		location.act(player, board , dice);
		Assert.assertTrue("There is an error. Player's piece did not go to jail", newLocation==piece.getLocation());
	}
}
