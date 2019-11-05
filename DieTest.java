import org.junit.Assert;
import org.junit.Test;

public class DieTest {

	@Test
	public void testRoll() {
		int result;
		Die die = new Die();
		die.roll();
		
		result=die.getFaceValue();
		
			Assert.assertTrue("There is an error. Value of die must be less than or"
					+ "equal to 6 and greater than or equal to 1", result>=1 && result<=6);
	}

}
