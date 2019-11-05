import java.util.Random;

public class Die {
	private int faceValue;

	public int getFaceValue() {
		return faceValue;
	}
	
	public void roll(){
		Random random = new Random();
		this.faceValue = random.nextInt(6)+1;
	}
	
	
	
	
	/*
	
	public int getFaceValue() {
		Random random = new Random();
		int faceValue=random.nextInt(6)+1;
		return faceValue;
	} */
}
