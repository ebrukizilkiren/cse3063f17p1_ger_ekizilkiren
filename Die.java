import java.util.Random;

public class Die {
	public int getFaceValue() {
		Random random = new Random();
		int faceValue=random.nextInt(6)+1;
		return faceValue;
	}
}
