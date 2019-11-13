package Command;

import tp.tp1.control.Controller;
import tp.tp1.game.Game;

public class UpdateCommand extends Command {
	private static String name="NONE";
	private static String symbol="N";
	private static String help="[none]: Skips one cycle.\n";
	public UpdateCommand()
	{
		super(name,symbol," ",help);
	}
	public  boolean execute(Game game)
	{
		return true;
	}
	public  Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool=(matchCommandName(commandWords[0]) && numArgs==1) ||
				commandWords[0].contentEquals("");
		Command comando;
		if(bool)
		{
			comando=new UpdateCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
