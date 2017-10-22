import java.util.Scanner;

public class MonopolyGame {
	static Board board;
	static Die die,die2;
	public static void main(String [] args){
		System.out.println("MONOPOLY SIMULATION");
		Scanner inputPlayer=new Scanner(System.in);
		int numOfPlayer=0;
		
		while(numOfPlayer<2 || numOfPlayer>8){
		
			System.out.println("How many players?");
			numOfPlayer=inputPlayer.nextInt();
		
			if(numOfPlayer<2){
				System.out.println("Player number must be greater than or equal to 2");
			}else if(numOfPlayer>8){
				System.out.println("Player number must be smaller than or equal to 8");
			}
		}
		inputPlayer.close();
		
		board=new Board(numOfPlayer);
		die=new Die();
		die2=new Die();
		
		startGame();
	}
	
	public static void startGame(){
		System.out.println("GAME STARTED!\n******");
		for(int round=0; round<10; round++){
			for(Player player : board.getPlayers()){
				int total = player.tossDice(die, die2);
				
				System.out.println(player.getName() + " is on " + 
						player.playerPiece.getLocation().getName() + 
						" and face value of dice is " + total);
								
				moveIt(player.playerPiece, total);
				
				System.out.println(player.getName() + " is now on " + 
						player.playerPiece.getLocation().getName() + "\n");			
			}						
		}
		System.out.println("******    \nGame Over!");
	}
	
	public static void moveIt(Piece piece, int dice){
		int newLocation = (piece.getLocation().getSquareID()+dice)%board.getSquares().length;
		piece.setLocation(board.getSquare(newLocation));		
	}	
}
