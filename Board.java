import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Board {
	int numOfPlayer=0;
	private Player[] players;
	private static Square[] squares=new Square[40];
	private Piece[] pieces=new Piece[8];
	int[] array = new int[66]; 
	
	@SuppressWarnings("deprecation")
	public Board(int numOfPlayer) throws IOException{
		players=new Player[numOfPlayer];
	    FileInputStream fis = new FileInputStream(new File("C://Users//KIZILKİREN//Desktop//LESSONS//3. SINIF//OBJECT ORIENTED PROGRAMMING//PROJECTS//PROJECT#1//monopoly.xlsx"));
	    @SuppressWarnings("resource")
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);
	    FormulaEvaluator forEv = wb.getCreationHelper().createFormulaEvaluator();
	    double d;
	    int j = 0;
	    
	    for(Row row : sheet){
			for(Cell cell : row){
				switch(forEv.evaluateInCell(cell).getCellType()){
	    		   case Cell.CELL_TYPE_NUMERIC:
	    			   d = cell.getNumericCellValue();
	    			   array[j]=(int)d;
	    			   j++;
	    		   case Cell.CELL_TYPE_STRING:
	    			   break;
				}
			}
		}
	    j=0;
		for(int i=0;i<squares.length;i++){
			if(i==0){
				squares[i] = new GoSquare("GO!");
			}else if(i==4){
				squares[i] = new IncomeTaxSquare("INCOME TAX");
			}else if(i==5){
				squares[i] = new RailRoadSquare("RAILROAD1");
			}else if(i==10){
				squares[i] = new InJailSquare("IN JAIL");
			}else if(i==12){
				squares[i] = new UtilitySquare("ELECTRIC UTILITY");
			}else if(i==15){
				squares[i] = new RailRoadSquare("RAILROAD2");
			}else if(i==20){
				squares[i] = new FreeParkingSquare("FREE PARKING");
			}else if(i==25){
				squares[i] = new RailRoadSquare("RAILROAD3");
			}else if(i==28){
				squares[i] = new UtilitySquare("WATER UTILITY");
			}else if(i==30){
				squares[i] = new GoToJailSquare("GO TO JAIL");
			}else if(i==35){
				squares[i] = new RailRoadSquare("RAILROAD4");
			}else if(i==38){
				squares[i] = new LuxuryTaxSquare("LUXURY TAX");
			}
			else if(i==array[j]-1&&j<array.length/3){
				squares[i] = new LotSquare("Square " + i);
				squares[i].setPrice(array[j+1]);
				squares[i].setRent(array[j+2]);
				j=j+3;
			}else{
				squares[i] = new RegularSquare("Square " + i);
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
	
	public void moveIt(Player player, Piece piece, int dice){
		
		if(piece.getLocation().getSquareID()+dice > squares.length ||
				(piece.getLocation().getSquareID()+dice)%squares.length == 0){
			piece.turnCounter++;
		}
		if(player.getDieCounter()==3){
			piece.setLocation(getSquare(30));
		}else{
			int newLocation = (piece.getLocation().getSquareID()+dice)%squares.length;
			piece.setLocation(getSquare(newLocation));
		}
		
		if(piece.getLocation().getSquareID()!=10){
			piece.getLocation().act(player, this, dice);
		}else{
			System.out.println(player.getName() + " is just visiting the jail.");
		}
	} 
	
	public void moveIt(Player player, Piece piece){
		piece.getLocation().act(player, this, 0);
	}
	
	public void situation(Player player, Die die, Die die2){
		player.tossDice(die, die2);
		int total = die.getFaceValue()+die2.getFaceValue();
		System.out.println(player.getName() + " is on " + 
				player.getPlayerPiece().getLocation().getName() + 
				",\nface value of die1 is " + die.getFaceValue() +
				",\nface value of die2 is " + die2.getFaceValue() +
				", \nand total face value of dice is " + total);
		player.doubleCounter(die, die2);
		moveIt(player, player.getPlayerPiece(), total);
		if(player.isBankrupt()==false){
			System.out.println(player.getName() + " is now on " + 
					player.getPlayerPiece().getLocation().getName() + "\nand " + player.getName() +
					"'s turnCounter is " + player.getPlayerPiece().turnCounter + 
					"\ncash = $" + player.getCash() + "\n");	
		}else{
			System.out.println(player.getName() + " is now on " +player.getPlayerPiece().getLocation().getName() 
					+"\n" + player.getName() + " went bankrupt!\n");
		}
	}
	
}
