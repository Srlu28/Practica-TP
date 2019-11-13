package tp.tp1.objects;

import tp.tp1.utils.*;

public class Bomb {
	private int damage;
	private static int hit=1;
	private String Sprite;
	private Localization pos;
	private DestroyerShip nave;
	
	public Bomb(Localization pos1,DestroyerShip nave)
	{
		damage=hit;
		Sprite=" . ";
		pos=pos1;
		this.nave=nave;
	}
	public static int devHit()
	{
		return hit;
	}
	public Localization getPos()
	{
		return pos;
	}
	
	public DestroyerShip getNave()
	{
		return nave;
	}
	
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	
	public int getFila()
	{
		return pos.getF();
	}
	
	public void move(Direction dir)
	{
		pos.movMisil(dir.getDir());
	}
	
	public String getSprite()
	{
		return Sprite;
	}
	public int getDamage()
	{
		return damage;
	}
	
	public boolean Limite()
	{
		return pos.posLimiteVertical(Direction.DOWN);
	}
	public void borrarBomba()
	{
		nave.bombaNoExiste();
	}
}
