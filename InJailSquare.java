import java.util.Random;

public class InJailSquare extends Square {
    Die die = new Die();
    Die die2 = new Die();
    int count=1;
    
	public InJailSquare(String name) {
		super(name);
	}

	public void act(Player player, Board board, int dice){
	    Random random = new Random();
		if(player.getCash()>=50&&random.nextBoolean()==true){
			player.reduceCash(50);
			System.out.println(player.getName() + " paid $50 to get out of jail.");
			board.situation(player, die, die2);
		}else{
			if(count<=3){
				player.tossDice(die, die2);

				if(die.getFaceValue()==die2.getFaceValue()){
					System.out.println(player.getName() + " rolled double and can get out of the jail.");
					board.situation(player, die, die2);
				}else{
					System.out.println(player.getName() + " could not rolled double, so " + player.getName() 
					+ "is still on " + player.getPlayerPiece().getLocation().getName());
					player.getPlayerPiece().setLocation(this);
				}
				count++;
			}else{
				player.tossDice(die, die2);
				board.situation(player, die, die2);
			}
		}
	}
}
