import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class UtilitySquareTest {

	@Test
	public void TestPayRent() throws IOException{
		Board board;
		board= new Board(3);
		Player player = new Player("test player");
		Player owner = new Player("test owner");
		Piece piece = new Piece("test piece");
		player.setPlayerPiece(piece);
		int dice = 5;
		player.setCash(200);
		int rent = 5*10;
		Square location = board.getSquare(12); // This is electric utility
		location.setOwner(owner);
		piece.setLocation(location);
		location.act(player, board, dice); //rent must be dice*10, players cash after paying rent must be $150
		int newCash = player.getCash();
		Assert.assertTrue("There is an error. Player could not pay rent correctly.", newCash==(200-rent));
		
	}
	

}
