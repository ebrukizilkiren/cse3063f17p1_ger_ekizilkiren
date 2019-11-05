import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testTossDice() {
		int result;
		Player player = new Player("temp player");
		Die die = new Die();
		Die die2 = new Die();
		
		/*We tested the method roll before and we sure that it works perfectly.
		We want to know that can tossDice method
		add rolled facevalues of die and die2 truly.  
		*/
		
		result=die.getFaceValue()+die2.getFaceValue(); // result should be 0 because initial facevalues of
		//dice are both 0
		int res = player.tossDice(die,die2);
		
		//if res and result have same values, it means that there is an error.
		Assert.assertTrue("There is an error.", result!=res);
		
	}

}
