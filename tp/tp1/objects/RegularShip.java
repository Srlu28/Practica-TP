package tp.tp1.objects;

import tp.tp1.utils.*;

public class RegularShip {
	private static int defaultVida= 2;
	private int vida;
	private static int puntos=5;
	private Localization pos;
	
	final int limite=7;
	
	public RegularShip(Localization pos1)
	{
		this.vida=defaultVida;
		this.pos=pos1;
	}
	
	public String getSprite()
	{
		return "C[" + vida + "]";
	}
	public void mover(Localization dir)
	{
		pos.setLoc(dir);
	}
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	public static int devDefaultVida()
	{
		return defaultVida;
	}
	public static int devPuntos()
	{
		return puntos;
	}
	public Localization getPos()
	{
		return pos;
	}
	public int getVida()
	{
		return this.vida;
	}
	public boolean limite(Direction dir)
	{
		return pos.posLimiteHorizontal(dir);
	}
	public void restarVida()
	{
		vida--;
	}
	public boolean llegoFin()
	{
		return (pos.getF()==limite);
	}
	public boolean impacto(Localization pos1)
	{
		return pos.comprobar(pos1);
	}
}