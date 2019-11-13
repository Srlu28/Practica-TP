package Command;

import tp.tp1.control.Controller;
import tp.tp1.game.Game;
import tp.tp1.utils.Update;

public class ExitCommand extends Command{
	private static String name="EXIT";
	private static String symbol="E";
	private static String help="exit:Terminates the program.\n";
	public ExitCommand()
	{
		super(name,symbol," ",help);
	}
	public  boolean execute(Game game)
	{
		game.setStatus(Update.SALIR);
		game.print("Fin de juego");
		return true;
	}
	public  Command parse(String[] commandWords)
	{
		
		int numArgs=commandWords.length;
		boolean bool=(matchCommandName(commandWords[0]) && numArgs==1);
		Command comando;
		if(bool)
		{
			comando=new ExitCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
