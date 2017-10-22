public class Player {
	
	Piece playerPiece;
	int playerID;
	String name;
	
	public Player(String name){
		this.name=name;
	}

	public int getPlayerID(){
		return playerID;
	}
	
	public void setPlayerID(int playerID){
		this.playerID=playerID;
	}
	
	public int tossDice(Die die, Die die2){
		int faceValue=die.getFaceValue()+die2.getFaceValue();
		return faceValue;
	}

	public String getName() {
		return name;
	}
		
}
