package tp.tp1.game;

import tp.tp1.utils.*;
import tp.tp1.listas.*;

public class UCMShipLaser {
	private static int hit=1;
	private int damage;
	private String Sprite;
	private Localization pos;
	private boolean existe;
	
	public UCMShipLaser(Localization pos1)
	{
		damage=hit;
		Sprite= " oo ";
		pos=pos1;
		existe=true;
	}
	public static int devHit()
	{
		return hit;
	}
	public Localization getPos()
	{
		return pos;
	}
	public boolean existe()
	{
		return existe;
	}
	public void mover(Localization pos)
	{
		this.pos.movMisil(pos);
	}
	public String getSprite()
	{
		return Sprite;
	}
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	public boolean Limite()
	{
		return pos.posLimiteVertical(Direction.UP);
	}
}
