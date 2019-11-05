public abstract class Square {
	private String name;
	private int squareID=-1;
	private int price=0, rent=0;
	private Player owner = new Player("computer");
	private boolean hasOwner=false;

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
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public boolean isHasOwner() {
		return hasOwner;
	}
	public void setHasOwner(boolean hasOwner) {
		this.hasOwner = hasOwner;
	}
	public abstract void act(Player player, Board board, int dice);
}

