package tp.tp1.listas;

import tp.tp1.objects.*;
import tp.tp1.utils.*;

public class BombList {
	private int contador;
	private int size=100;
	private Bomb array[];
	
	public BombList()
	{
		contador=0;
		array=new Bomb[size];
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
	
	public void anadir(Bomb bomba) 
	{
		if(bomba != null)
		{
			array[contador]=bomba;
			contador++;
		}
		
	}
	
	public void eliminarEn(int i)
	{
		for(int j = i; j < contador; j++)
			array[j] = array[j+1];
		contador--;
	}
	
	public int getCont()
	{
		return contador;
	}
	
	public boolean impacto(Localization pos)
	{
		boolean dev=false;
		int i=0;
		while(i<contador && !array[i].estaPos(pos))
		{
			i++;
		}
		if(i<contador)
		{
			dev=true;
			array[i].borrarBomba();
			eliminarEn(i);
		}
		return dev;
	}
	
	public void borrarBombas ()
	{
		int i = 0;
		while (i  < contador)
			if (array[i].Limite()) { 
				array[i].borrarBomba();
				eliminarEn(i);
			}
			else i++;
	}
	public void moverBombas(Direction dir)
	{
		for(int i=0;i<contador;i++)
			array[i].move(dir);
		borrarBombas();
	}
	public String getSimbolo(int pos)
	{
		return array[pos].getSprite();
	}
	
}