public class GoToJailSquare extends Square{
	public GoToJailSquare(String name) {
		super(name);
	}
	public void act(Player player, Board board){
		System.out.println(player.getName() + " is on " + 
				player.getPlayerPiece().getLocation().getName() + " and " + player.getName() + 
				" has to go to jail");
		player.getPlayerPiece().setLocation(board.getSquare(10));
	}
}
