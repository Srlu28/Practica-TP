package tp.tp1.listas;
import tp.tp1.game.*;
import tp.tp1.objects.DestroyerShip;
import tp.tp1.listas.*;
import tp.tp1.utils.*;
import tp.tp1.objects.*;
public class DestroyerShipList {
	private DestroyerShip Array[];
	private int size=100;
	private int contador;
	public DestroyerShipList()
	{
		Array=new DestroyerShip[size];
		contador=0;
	}
	public Bomb disparo(int pos)
	{
		return Array[pos].disparo();
	}
	public void RestarVida()
	{
		for(int i=0;i<contador;i++)
		{
			Array[i].restarVida();
		}
	}
	public int compruebaPos(Localization pos)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !dev)
			if (!Array[i].estaPos(pos)) i++;
			else dev = true;
		return dev ? i : -1;
	}
	public void anadir(DestroyerShip nave) 
	{
		Array[contador]=nave;
		contador++;
	}
	public void eliminarEn(int i)
	{
		for(int j = i; j < contador; j++)
			Array[j] = Array[j+1];
		contador--;
	}
	
	public void disparoDestructoras(BombList Lista_bombas, Game game)
	{
		for(int i = 0;i < contador;i++)
		{
			if(game.probabilidad(game.devFrecDisparos()))
				Lista_bombas.anadir(disparo(i));
					
		}
	}
	
	public void borrarMuertos (UCMShip nave)
	{
		int i = 0;
		while (i  < contador)
			if (Array[i].getVida() <= 0)
				{
					nave.anadirPuntos(DestroyerShip.getPuntos());
					eliminarEn(i);
					
				}
			else i++;
	}
	public boolean limite(Direction dir)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !Array[i].limite(dir))
		{
			i++;
		}
		if(i<contador)dev=true;
		return dev;
	}
	public void moverLista(Localization pos)
	{
		for(int i=0;i<contador;i++)
		{
			Array[i].mover(pos);
		}
	}
	public boolean impactoConLaser(Localization pos1, UCMShip nave)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !Array[i].impacto(pos1))
		{
			i++;
		}
		if(i<contador)
		{
			dev=true;
			Array[i].restarVida();
			borrarMuertos(nave);
		}
		return dev;
	}
	
	public int getCont()
	{
		return contador;
	}
	
	public boolean llegoFin()
	{
		boolean dev=false;
		for(int i=0;i<contador;i++)
		{
			dev = dev || Array[i].llegoFin();
		}
		return dev;
	}
	
	public String getSimbolo(int pos)
	{
		return Array[pos].getSprite();
	}
	
}