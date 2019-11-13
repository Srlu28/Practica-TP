package tp.tp1.control;
import Command.*;
import tp.tp1.game.Game;
import tp.tp1.game.GamePrinter;
import java.util.*;
import tp.tp1.utils.*;
public class Controller {
	private Game game;
	final int filas=8;
	final int col=9;
	public Controller()
	{}
	/*public void run(Game game)
	{
		
		String entradaLeida, comando=" ";
		Scanner entrada = new Scanner(System.in);
		boolean acaba=false;
		while(!comando.contentEquals("EXIT")&& !comando.contentEquals("E") && !acaba) 
		{
			draw(game);

			System.out.println(("Introduzca comando"));
			entradaLeida=entrada.nextLine();
			entradaLeida=entradaLeida.toUpperCase();
			String args[] = entradaLeida.split(" ");
			comando = args[0];
			if(comando.contentEquals("S")||comando.contentEquals("SHOOT"))
			{
				System.out.println("Comando Shoot");
				if(game.dispara())
				{
					System.out.println("Disparo realizado");
				}
				else System.out.println("No se puede realizar el disparo");
			}
			else if(comando.contentEquals("SHOCKWAVE")||comando.contentEquals("W"))
			{
				System.out.println("Comando Shockwave");
				Shockwave(game);
			}
			else if(comando.contentEquals("NONE")||comando.contentEquals("N")|| comando.contentEquals(""))
			{
				System.out.println("Comando None");
			}
			else if(comando.contentEquals("MOVE")||comando.contentEquals("M"))
			{
				if (args.length < 3) continue;
				System.out.println("Comando Move");	
				String direction= args[1]; 
				int cantidad= Integer.parseInt(args[2]);
				for(int i=0;i< Math.min(cantidad,2);i++)
					game.moverUCMShip(direction);
			}
			else if(comando.contentEquals("LIST")||comando.contentEquals("L"))
			{
				System.out.println("Comando List");
				game.list();
			}
			else if(comando.contentEquals("RESET")||comando.contentEquals("R"))
			{
				System.out.println("Comando Reset");
				Level lvl =game.getLevel();
				long seed=game.getSeed();
				game=new Game(lvl,seed);
				continue;
			}
			else if(comando.contentEquals("HELP")||comando.contentEquals("H"))
			{
				System.out.println("Command > help ");
				System.out.println("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.");
				System.out.println("shoot: UCM-Ship launches a missile."
						+ "shockwave:UCM-Ship releases a shockwave.\n"
						+ "list: Prints the list of avaible ships.\n"
						+ "reset: Starts a new game.\n"
						+ "help: Prints the help message.\n"
						+ "exit:Terminates the program.\n"
						+ "[none]: Skips one cycle.\n");
				
			}
			Update condition=game.update();
			if(condition==Update.ALIENSWIN || condition == Update.PLAYERWINS)
			{
				
				acaba=true;
				draw(game);
				String msg;
				if(condition == Update.ALIENSWIN) msg = "Aliens win";
				else msg = "Player wins";
				System.out.println(msg.toUpperCase());
			}
		}
		System.out.println("GAME OVER"); 
		
	}*/
	public void run(Game game)
	{
		String entradaLeida;
		Command comando;
		Scanner entrada = new Scanner(System.in);
		Update condition = Update.CONTINUA;
		boolean acaba=false;
		
		do {
			draw(game);
			System.out.println(("Introduzca comando"));
			String args[] = entrada.nextLine().toUpperCase().split(" ");
			comando=CommandGenerator.parseCommand(args);
			if(comando == null) continue;
			if(comando.execute(game)) condition=game.update();
		} while (condition == Update.CONTINUA);
		
		if(condition==Update.ALIENSWIN || condition == Update.PLAYERWINS)
		{
			
			draw(game);
			String msg = (condition == Update.ALIENSWIN) ? "Aliens win" : "Player wins";
			System.out.println(msg.toUpperCase());
		}
		/*
		Scanner intr=new Scanner(System.in);
		boolean acaba=false;
		while(!acaba)
		{
			System.out.println(" ");
			String[] words=intr.nextLine().toUpperCase().trim().split("\\s+");
			try {
				Command command=CommandGenerator.parseCommand(words);
				if(command!=null)
				{
					if(command.execute(game))
					{
						draw(game);
					}
				}
				else System.out.println("Error");
			}
		}*/
		
	}

	public static void imprimir(String mensaje)
	{
		System.out.println(mensaje);
	}
	
	public void draw(Game game)
	{
		System.out.println("Life: " + game.devVidaPlayer());
		System.out.println("Number of cycles: " + game.devCiclos());
		System.out.println("Points: "+ game.devPuntosPlayer());
		System.out.println("Remaining aliens: "+game.devNumAliens());
		System.out.println("Shockwave: "+ game.devShockwave());
		GamePrinter printer;
		printer = new GamePrinter(game,filas,col);
		System.out.println(printer.toString());
	}
	public void Shockwave(Game game)
	{
		if(game.Shockwave())System.out.println("Shockwave realizado");
		else System.out.println("Imposible realizar Shockwave");
	}
}