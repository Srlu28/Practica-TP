package tp.tp1;
import tp.tp1.control.*;
import tp.tp1.game.*;
import tp.tp1.utils.Level;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game;
		Controller control= new Controller();
		if (args.length  >= 1) {
			Level nivel=Level.conversor(args[0].toUpperCase());
	
			if(args.length == 1)  
				{
					game=new Game(nivel,java.lang.System.currentTimeMillis());
					control.run(game);
				}
			else 
				{
					game=new Game(nivel, Long.parseLong(args[1]));
					control.run(game);
				}
		}
		else 
			{
				System.out.println("Indique la dificultad");
				Scanner entrada= new Scanner(System.in);
				String level =entrada.nextLine();
				Level lvl = Level.conversor(level);
				game=new Game(lvl,java.lang.System.currentTimeMillis());
				control.run(game);
				
			}
	}

}
