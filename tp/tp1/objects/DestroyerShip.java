package tp.tp1.objects;
import tp.tp1.utils.*;

public class DestroyerShip {
	private static int defaultVida = 1;
	private static int puntos = 10;
	
	private int vida;
	private boolean bomba;
	private Localization pos;
	
	final int limite=7;
	
	public DestroyerShip(Localization pos1)
	{
		this.vida= defaultVida;
		this.pos=pos1;
		bomba=false;
	}
	
	public  String getSprite()
	{
		return "D[" + vida + "]";
	}
	public void move(Localization dir)
	{
		pos.setLoc(dir);
	}
	public boolean estaPos(Localization pos)
	{
		return this.pos.comprobar(pos);
	}
	public int getVida()
	{
		return vida;
	}
	public Localization getPos()
	{
		return this.pos;
	}
	public Bomb disparo()
	{//Te crea una bomba si no hay una bomba disparada por esta nave.
		Bomb newBomb;
		newBomb = bomba ? null : new Bomb(new Localization(pos),this);
		bomba = true;
		return newBomb;
	}
	public void bombaNoExiste() {
		bomba = false;
	}
	
	public boolean limite(Direction dir)
	{
		return pos.posLimiteHorizontal(dir);
	}
	
	public void mover(Localization pos)
	{
		this.pos.setLoc(pos);
	}
	public void restarVida()
	{
		vida--;
	}
	public boolean llegoFin()
	{
		return (pos.getF()==limite);
	}
	public static int getPuntos()
	{
		return puntos;
	}
	public static int devVidaDefault()
	{
		return defaultVida;
	}
	public boolean impacto(Localization pos1)
	{
		return pos.comprobar(pos1);
	}
}