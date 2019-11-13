package tp.tp1.objects;

import tp.tp1.utils.*;

public class UCMShip {
	private Localization pos;
	private int vida;
	private int dano;
	private int puntos;
	private String sprite;
	private boolean Shockwave;
	private static int vidaDefault=3;
	private static String icono=" ^__^ ";
	
	public UCMShip()
	{
		puntos=0;
		pos=new Localization(7,4);
		vida=vidaDefault;
		dano=1;
		sprite=icono;
		Shockwave = true;
	}
	public static String devIcono()
	{
		return icono;
	}
	public static int devVidaDefault()
	{
		return vidaDefault;
	}
	public void earnShockwave()
	{
		if(!Shockwave)
			Shockwave = true;
	}
	public void useShockwave()
	{
		Shockwave=false;
	}
	public boolean getShockwave()
	{
		return Shockwave;
	}
	public void addPoints(int points)
	{
		puntos+=points;
	}
	public int getPuntos()
	{
		return puntos;
	}
	public void mover(Localization dir)
	{
		pos.setLoc(dir);
	}
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	public String getSprite()
	{
		if(vida==0) sprite=" !xx! ";
		return sprite;
	}
	public Localization getPos()
	{
		return pos;
	}
	public void reducirVida()
	{
		vida--;
	}
	public int getVida()
	{
		return vida;
	}
	public int getDamage()
	{
		return dano;
	}
	public void anadirPuntos(int ptos)
	{
		this.puntos+=ptos;
	}
}