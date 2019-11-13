package Command;

import tp.tp1.game.Game;
import tp.tp1.control.*;

public class MoveCommand extends Command{
	private static String name="MOVE";
	private static String symbol="M";
	private static String help="move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\n";
	public MoveCommand()
	{
		super(name,symbol," ",help);
	}
	private MoveCommand(String details)
	{
		super(name,symbol,details,help);
	}
	public  boolean execute(Game game)
	{
		String args[]= details.split(" ");
		String direction= args[0]; 
		int cantidad= Integer.parseInt(args[1]);
		for(int i=0;i< Math.min(cantidad,2);i++)
			game.moverUCMShip(direction);
		return direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right");
 	}
	public  Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool=matchCommandName(commandWords[0]) && numArgs==3;
		Command comando;
		if(bool) 
		{
			comando=new MoveCommand(commandWords[1]+" "+ commandWords[2]);
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
