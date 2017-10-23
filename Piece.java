public class Piece {
	 private Square location;
	 private String name;
	 
	 public Piece(String name){
		 this.setName(name);
	 }
	 public Piece(Square location){
		 this.location=location;
	 }
	 
	 public Square getLocation() {
		return location;
	 }
	 
	 public void setLocation(Square location) {
		this.location = location;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
