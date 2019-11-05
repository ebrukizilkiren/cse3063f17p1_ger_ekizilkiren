import org.junit.Assert;
import org.junit.Test;

public class GoSquareTest {
	Board board;
	Player player = new Player("test player");
	Piece piece = new Piece("test piece");
	Square location = new GoSquare("go");
	int dice = 0;
	@Test
	public final void testAct() {
		player.setCash(100);
		player.setPlayerPiece(piece);
		piece.setLocation(location);
		int newCash = 300;
		location.act(player, board , dice);
		Assert.assertTrue("There is an error. Player could not gain $200.", newCash==player.getCash());
	}

}
