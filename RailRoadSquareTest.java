import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RailRoadSquareTest {

	@Test
	public final void testPayRent() throws IOException {
		Board board;
		board= new Board(3);
		Player player = new Player("test player");
		Player owner = new Player("test owner");
		Piece piece = new Piece("test piece");
		player.setPlayerPiece(piece);
		int dice = 6;
		player.setCash(200);
		int rent = 6*5+25;
		Square location = board.getSquare(5); // This is railroad1
		location.setOwner(owner);
		piece.setLocation(location);
		location.act(player, board, dice); //rent must be dice*5+25, players cash after paying rent must be $145
		int newCash = player.getCash();
		Assert.assertTrue("There is an error. Player could not pay rent correctly.", newCash==(200-rent));
	}

}
