package tp.tp1.GameObject.sons;
import tp.tp1.GameObject.*;
import tp.tp1.game.*;
import tp.tp1.utils.*;
public abstract class Ships extends GameObject
{
	protected int puntos;
	protected int defaultLife;

	public Ships (Game game, Localization pos, int defaultLife, int puntos)
	{
		super(game,pos,defaultLife);
		this.puntos=puntos;
		
	}
	
	public void moverIzq()
	{
		
		pos.setLoc(Direction.LEFT.getDir());
	}
	
	public int devDefaultLife()
	{
		return this.defaultLife;
	}
	
	public int devPuntos() 
	{
		return this.puntos;
	}
}
