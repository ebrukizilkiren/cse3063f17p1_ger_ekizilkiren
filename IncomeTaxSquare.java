public class IncomeTaxSquare extends Square {
	public IncomeTaxSquare(String name) {
		super(name);
	}	
	public void act(Player player, Board board){
		int incomeTax= (player.getCash()*10)/100;
		player.reduceCash(incomeTax);
		System.out.println(player.getName() + " paid $" + incomeTax + " for income tax.");
	}
}
