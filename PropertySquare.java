
public abstract class PropertySquare extends Square{
	public PropertySquare(String name) {
		super(name);
	}

	@Override
	public void act(Player player, Board board, int dice) {
		
	}
	public abstract void payRent(Player player, Board board, int dice);
}
