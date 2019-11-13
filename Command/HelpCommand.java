package Command;
import tp.tp1.game.*;
import tp.tp1.control.*;


public class HelpCommand extends Command {
	private static String help="help: Prints the help message.\n";
	private static String name="HELP";
	private static String symbol="H";
	public HelpCommand () {
		super(name, symbol, " ",help);
	}
	
	public boolean execute(Game game ) {
		String text=CommandGenerator.commandHelp();
		game.print(text);
		return true;
	}
	//Para luego recoger todo el mensaje help.
	public Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool = (numArgs==1 && matchCommandName(commandWords[0]));
		Command comando;
		if (bool)
		{
			comando=new HelpCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
	

}
