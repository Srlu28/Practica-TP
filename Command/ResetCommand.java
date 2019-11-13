package Command;

import tp.tp1.control.Controller;
import tp.tp1.game.Game;

public class ResetCommand extends Command{
	private static String name="RESET";
	private static String symbol="R";
	private static String help="reset: Starts a new game.\n";
	public ResetCommand()
	{
		super(name,symbol," ",help);
	}
	public  boolean execute(Game game)
	{
		System.out.println("Reseteando\n");
		game.inicialize();
		return false;
		}
	
	public  Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool=(matchCommandName(commandWords[0]) && numArgs==1);
		Command comando;
		if(bool)
		{
			comando=new ResetCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
