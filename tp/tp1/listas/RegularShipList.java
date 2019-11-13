package tp.tp1.listas;


import tp.tp1.objects.RegularShip;
import tp.tp1.objects.UCMShip;
import tp.tp1.utils.*;
public class RegularShipList {
	private int size=100;
	private int contador;
	private RegularShip array[];
	
	public RegularShipList()
	{
		array=new RegularShip[size];
		contador=0;
	}
	
	public int compruebaPos(Localization pos)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !dev)
			if (!array[i].estaPos(pos)) i++;
			else dev = true;
		return dev ? i : -1;
	}
	
	public void anadir(RegularShip nave) 
	{
		array[contador]=nave;
		contador++;
	}
	
	public void eliminarEn(int i)
	{
		for(int j = i; j < contador; j++)
			array[j] = array[j+1];
		contador--;
	}
	
	public void borrarMuertos (UCMShip nave)
	{
		int i = 0;
		while (i  < contador)
			if (array[i].getVida() <= 0)
				{
					nave.anadirPuntos(RegularShip.devPuntos());
					eliminarEn(i);
					
				}
			else i++;
	}
	
	public boolean limite(Direction dir)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !array[i].limite(dir))
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
			array[i].mover(pos);
		}
	}
	
	public boolean impactoConLaser(Localization pos1, UCMShip nave)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !array[i].impacto(pos1))
		{
			i++;
		}
		if(i<contador)
		{
			dev=true;
			array[i].restarVida();
			borrarMuertos(nave);
		}
		return dev;
	}
	
	public void RestarVida()
	{
		for(int i=0;i<contador;i++)
		{
			array[i].restarVida();
		}
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
			dev = dev || array[i].llegoFin();
		}
		return dev;
	}
	
	public String getSimbolo(int pos)
	{
		return array[pos].getSprite();
	}
}
