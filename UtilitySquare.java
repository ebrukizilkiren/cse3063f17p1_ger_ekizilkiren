import java.util.Random;

public class UtilitySquare extends PropertySquare {
	
	public UtilitySquare(String name) {
		super(name);
		setPrice(150);
	}
	
	@Override
	public void act(Player player, Board board, int dice) {
		System.out.println(this.getName() + " belongs to " + this.getOwner().getName());
		Die die,die2;
		die = new Die();
		die2 = new Die();
		if(this.getOwner().getName()=="computer"){
			Random random = new Random();
			if(random.nextBoolean()==true){
				if(player.tossDice(die, die2)>4&&player.getCash()>this.getPrice()){
					player.reduceCash(this.getPrice());
					this.setOwner(player);
					System.out.println(player.getName() + " bought " + this.getName() + " and paid $" + 
							this.getPrice());
				}
			}
		}else{
			if(this.getOwner()!=player&&this.getOwner().getName()!="computer"){
				payRent(player, board, dice);
				System.out.println(player.getName() + " paid $" + this.getRent() + " to " 
						+ this.getOwner().getName());
			}else if(this.getOwner()==player){
				System.out.println(this.getName() + " belongs to " + player.getName());
			}
		}
	}

	@Override
	public void payRent(Player player, Board board, int dice) {
		int rent = dice*10;
		this.setRent(rent);
		if(player.getCash()<rent){
			player.setBankrupt(true);
			System.out.println(player.getName() + " has not enough cash to pay rent, so ");
		}else{
			player.reduceCash(rent);
			this.getOwner().addCash(rent);
		}
	}

}
