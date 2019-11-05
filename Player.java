public class Player {
	
	private Piece playerPiece;
	private int playerID;
	private String name;
	private int cash = 200;
	private int dieCounter = 0;
	private boolean bankrupt = false;
	
	public Player(String name){
		this.name=name;
	}

	public int getPlayerID(){
		return playerID;
	}
	
	public void setPlayerID(int playerID){
		this.playerID=playerID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public Piece getPlayerPiece() {
		return playerPiece;
	}

	public void setPlayerPiece(Piece playerPiece) {
		this.playerPiece = playerPiece;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public void addCash(int cash){
		this.setCash(this.getCash()+cash);
	}
	
	public void reduceCash(int cash){
		this.setCash(this.getCash()-cash);
	}

	public int getDieCounter() {
		return dieCounter;
	}

	public void setDieCounter(int dieCounter) {
		this.dieCounter = dieCounter;
	}
	
	public int tossDice(Die die, Die die2){
		die.roll();
		die2.roll();
		int faceValue=die.getFaceValue()+die2.getFaceValue();
		return faceValue;
	}
	
	public void doubleCounter(Die die, Die die2){
		if(die.getFaceValue()==die2.getFaceValue()){
			dieCounter++;
		}else if(dieCounter>3||die.getFaceValue()!=die2.getFaceValue()){
			dieCounter=0;
		}
	}

	public boolean isBankrupt() {
		return bankrupt;
	}

	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}
}
