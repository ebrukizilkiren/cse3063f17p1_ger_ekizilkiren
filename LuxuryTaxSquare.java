public class LuxuryTaxSquare extends Square {
	public LuxuryTaxSquare(String name) {
		super(name);
	}
	public void act(Player player, Board board, int dice){
		if(player.getCash()<70){
			player.setBankrupt(true);
			System.out.println(player.getName() + " has not enough cash to pay tax, so ");
		}else{
			player.reduceCash(70);
			System.out.println(player.getName() + " paid $70 luxury tax.");
		}
	}
}
