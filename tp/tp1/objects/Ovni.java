package tp.tp1.objects;
import tp.tp1.utils.*;

public class Ovni {
	private static int vidaDefault=1;
	private static int puntos=25;
	private int vida;
	private Localization pos;
	
	public Ovni()
	{
		vida=vidaDefault;
		pos=new Localization(0,8);
	}
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	public String getSprite()
	{
		return "O[" + vida + "]";
	}
	public Localization getPos()
	{
		return pos;
	}
	public void mover(Direction dir)
	{
		pos.setLoc(dir.getDir());
	}
	public boolean estaLimite()
	{
		return pos.posLimiteHorizontal(Direction.LEFT);
	}
	public static int getPuntos()
	{
		return puntos;
	}
	public int getVida()
	{
		return vida;
	}
	public boolean impacto(Localization pos1)
	{
		return pos.comprobar(pos1);
	}
	public static int getVidaDefault()
	{
		return vidaDefault;
	}
}
