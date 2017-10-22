public class Board {
	int numOfPlayer=0;
	private Player[] players;
	private Square[] squares=new Square[40];
	private Piece[] pieces=new Piece[8];
	
	public Board(int numOfPlayer){
		players=new Player[numOfPlayer];
		
		for(int i=0;i<squares.length;i++){
			if(i==0){
			squares[i]=new Square("Start!");
			}else{
			squares[i]=new Square("Square " + (i));
			}
			squares[i].setSquareID(i);
		}
		
		for(int i=0;i<players.length;i++){
			players[i]=new Player("Player " + (i+1));
			players[i].setPlayerID(i+1);
			pieces[i]=new Piece("Piece " + (i+1));
			players[i].setPlayerPiece(pieces[i]);
			players[i].getPlayerPiece().setLocation(squares[0]);
		}
	}
	
	public Player[] getPlayers(){
		return players;
	}
	
	public Player getPlayer(int playerID){
		return players[playerID];
	}
	
	public Square[] getSquares(){
		return squares;
	}
	
	public Square getSquare(int squareID){
		return squares[squareID];
	}

}
