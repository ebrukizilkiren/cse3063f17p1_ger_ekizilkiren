public class GoSquare extends Square {
	public GoSquare(String name) {
		super(name);
	}	
	public void act(Player player, Board board){
		player.addCash(200);
		System.out.println(player.getName() + " is on Go square, so gain $200.");
	}
}
