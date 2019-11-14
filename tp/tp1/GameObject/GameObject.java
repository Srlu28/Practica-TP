package tp.tp1.GameObject;
import tp.tp1.utils.*;
import tp.tp1.game.*;

public abstract class GameObject 
{
	protected Localization pos;
	protected int life;
	protected Game game;
	
	
	public GameObject (Game game, Localization pos, int life)
	{
		this.game = game;
		this.pos = pos;
		this.life = life;
	}
	
	public Localization getPos()
	{
		return pos;
	}
	
	public int getX()
	{
		return pos.getF();
	}
	public int getY()
	{
		return pos.getC();
	}
	public boolean isAlive()
	{
		return this.life>0;
	}
	public int getLife()
	{
		return this.life;
	}
	public boolean isOnPosition(Localization dir)
	{
		return pos.comprobar(dir);
	}
	public void getDamae (int damage)
	{
		this.life = damage >= this.life ? 0: this.life - damage;
	}
	public boolean isOut()
	{
		return !game.isOnBoard(pos);
	}
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	
}
