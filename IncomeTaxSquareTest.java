import org.junit.Assert;
import org.junit.Test;

public class IncomeTaxSquareTest {
	Board board;
	Player player = new Player("test player");
	Piece piece = new Piece("test piece");
	Square location = new IncomeTaxSquare("income tax");
	int dice = 0;
	@Test
	public final void testAct() {
		player.setCash(100);
		int incomeTax = 10; //100*10/100 is income tax of the player
		int newCash = player.getCash()-incomeTax;
		player.setPlayerPiece(piece);
		piece.setLocation(location);
		location.act(player, board , dice);
		Assert.assertTrue("There is an error. Player's piece did not moved.", newCash==player.getCash());
	}

}
