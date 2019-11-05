import org.junit.Assert;
import org.junit.Test;

public class LuxuryTaxSquareTest {
	Board board;
	Player player = new Player("test player");
	Piece piece = new Piece("test piece");
	Square location = new LuxuryTaxSquare("Luxury tax");
	int dice = 0;
	@Test
	public final void test() {
		player.setCash(100);
		//Luxury tax is 70
		int newCash = 30; 
		player.setPlayerPiece(piece);
		piece.setLocation(location);
		location.act(player, board , dice);
		Assert.assertTrue("There is an error. Player's piece did not moved.", newCash==player.getCash());
	}

}
