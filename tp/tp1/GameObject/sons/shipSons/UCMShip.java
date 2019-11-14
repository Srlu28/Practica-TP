package tp.tp1.GameObject.sons.shipSons;
import tp.tp1.GameObject.sons.*;
import tp.tp1.utils.Localization;

public abstract class UCMShip extends Ships
{
	private static Localization pos = new Localization (7,4);
	private static int defaultLife = 3;
	private static int damage = 1;
	private static int puntos = 0;
	private boolean Shockwave;
	private String icon;
	private static String sprite = "^__^";
	
	public UCMShip (Game game)
	{
		super (game, pos, defaultLife, puntos);
		icon = sprite;
	}
	
	public String toString()
	{
		if(UCMShip.this.isAlive())
		{
			return icon;
		}
		else
		{
			return "!xx!";
		}
	}
	
	
}
