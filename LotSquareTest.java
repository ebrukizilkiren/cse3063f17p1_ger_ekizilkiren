import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class LotSquareTest {

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
		Square location = board.getSquare(2); // This is square 2
		int rent = location.getRent();
		location.setOwner(owner);
		piece.setLocation(location);
		location.act(player, board, dice); //players cash after paying rent must be 200-rent
		int newCash = player.getCash();
		Assert.assertTrue("There is an error. Player could not pay rent correctly.", newCash==(200-rent));
	}

}
