package Command;

import tp.tp1.control.Controller;
import tp.tp1.game.Game;

public class ListCommand extends Command{
	private static String name="LIST";
	private static String shortcut="L";
	private static String help="list: Prints the list of avaible ships.\\n";
	public  ListCommand()
	{
		super(name,shortcut," ",help);
	}
	public  boolean execute(Game game)
	{
		game.list();
		return true;
	}
	public  Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool=matchCommandName(commandWords[0]) && numArgs==1;
		Command comando;
		if(bool) 
		{
			comando=new ListCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
