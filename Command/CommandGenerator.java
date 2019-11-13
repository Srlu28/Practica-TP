package Command;
//Cada comando con su ayuda.
public class CommandGenerator {
	private static Command[] avaibleCommands= {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand()
	};
	public static String commandHelp()
	{
		String msg=" ";
		for(int i=0;i<avaibleCommands.length;i++)
		{
			msg+=avaibleCommands[i].helpText();
		}
		return msg;
	}
	public static Command parseCommand(String[] commandWords)
	{
		Command comando=null;
		int i=0;
		while(i<avaibleCommands.length && comando == null)
		{
			comando=avaibleCommands[i].parse(commandWords);
			i++;
		}
		return comando;
	}
	
}
