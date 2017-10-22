public class Square {
	public String name;
	int squareID=0;
	
	public int getSquareID(){
		return squareID;
	}
	public void setSquareID(int squareID){
		this.squareID=squareID;
	}
	public Square(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		 this.name=name;
	}
	
}
