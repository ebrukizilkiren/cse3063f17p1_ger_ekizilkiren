import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MonopolyGame {
	static ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();
	static Board board;
	static Die die,die2;
	static int round = 1;
	static int initialCash = 0;
	static int bankruptCounter = 0;
	static int numOfPlayer = 0;
	static int squareCounter = 0;
	
	public static void main(String [] args) throws IOException{

		System.out.println("MONOPOLY SIMULATION");
		Scanner inputPlayer = new Scanner(System.in);
		Scanner inputInitialCash = new Scanner(System.in);

		while(numOfPlayer<2 || numOfPlayer>8){
		
			System.out.println("How many players?");
			numOfPlayer=inputPlayer.nextInt();
		
			if(numOfPlayer<2){
				System.out.println("Player number must be greater than or equal to 2");
			}else if(numOfPlayer>8){
				System.out.println("Player number must be smaller than or equal to 8");
			}
		}
		
		board=new Board(numOfPlayer);
		die=new Die();
		die2=new Die();

		
		for(int i = 0; i< numOfPlayer; i++){
			System.out.println("Enter the player " + (i+1) + "'s name");
			board.getPlayer(i).setName(inputPlayer.next());
		}

		System.out.println("What is the initial cash of the players?");
		initialCash = inputInitialCash.nextInt();
		for(Player player : board.getPlayers()){
			player.setCash(initialCash);
		}
		
		inputPlayer.close();
		inputInitialCash.close();
		
		startGame();
		

	}
	
	public static void startGame() throws FileNotFoundException{
		capturer.start();
		System.out.println("GAME STARTED!\n******");
		while(true){
			System.out.println("Round " + round + "\n------");
			for(Player player : board.getPlayers()){
				
				for(Player p : board.getPlayers()){
					if(p.isBankrupt()==true){
						bankruptCounter++;
					}
				}
				
				if(numOfPlayer-bankruptCounter==1&&player.isBankrupt()==false){
					System.out.println(player.getName() + " is winner, has $" + player.getCash() + " and owns\n");
					for(Square square : board.getSquares()){
						if(square.getOwner()==player){
							System.out.println(++squareCounter +") "+ square.getName() +"\n");
						}
					}
					
					capturer.stop();
					
					System.exit(1);
				}

				if(player.isBankrupt()==true){
					System.out.println(player.getName() + " went bankrupt!\n");
					bankruptCounter=0;
					continue;
				}
				
				if(player.getPlayerPiece().getLocation().getSquareID()==10){
					board.moveIt(player, player.getPlayerPiece());
				}else{
					board.situation(player, die, die2);							
				}
				bankruptCounter=0;
			}
			round++;
		}
	}
}
