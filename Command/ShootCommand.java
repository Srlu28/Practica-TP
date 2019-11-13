package Command;

import tp.tp1.game.Game;

public class ShootCommand extends Command{
	private static String help="shoot: Disparo de la nave.\n";
	private static String name="SHOOT";
	private static String symbol="S";
	public ShootCommand () {
		super(name, symbol, " ",help);
	}
	
	public boolean execute(Game game ) {
		if(game.dispara())
		{
			game.print("Disparo realizado");
		}return true;
	}
	public Command parse(String[] commandWords)
	{
		int numArgs=commandWords.length;
		boolean bool = (numArgs==1 && matchCommandName(commandWords[0]));
		Command comando;
		if (bool)
		{
			comando=new ShootCommand();
		}
		else comando=null;
		return comando;
	}
	public String helpText()
	{
		return help;
	}
}
