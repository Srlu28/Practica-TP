package Command;

import tp.tp1.control.Controller;
import tp.tp1.game.Game;

public class ShockwaveCommand extends Command {
	private static String name="SHOCKWAVE";
	private static String symbol="W";
	private static String help="Shockwave:UCM-Ship releases a shockwave.\n";
	public ShockwaveCommand()
	{
		super(name,symbol," ",help);
	}
	public  boolean execute(Game game)
	{
		return game.Shockwave();
	}
	public  Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool=matchCommandName(commandWords[0]) && numArgs==1;
		Command comando;
		if(bool) 
		{
			comando=new ShockwaveCommand();
		}
		else comando=null;
		return comando;
		
	}
	public String helpText()
	{
		return help;
	}
	
}
