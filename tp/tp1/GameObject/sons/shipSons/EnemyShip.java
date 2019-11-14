package tp.tp1.GameObject.sons.shipSons;
import tp.tp1.GameObject.sons.*;
import tp.tp1.GameObject.*;
import tp.tp1.utils.*;
import tp.tp1.game.*;

public abstract class EnemyShip extends Ships
{
	protected String id;
	
	public EnemyShip (Game game, Localization pos, int defaultLife, int puntos, String id)
	{
		super (game, pos, defaultLife, puntos);
		this.id=id;
	}
	
	public String toString ()
	{
		return id+"["+life+"]";
	}
	
}
