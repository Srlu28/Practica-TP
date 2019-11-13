package tp.tp1.game;
import tp.tp1.game.UCMShipLaser;
import java.util.Random;
import tp.tp1.listas.*;

import tp.tp1.utils.*;
import tp.tp1.objects.*;
public class Game {
	
	private int ciclo;
	private Random generador;
	private BombList Lista_bombas;
	private DestroyerShipList Lista_Destructoras;
	private RegularShipList Lista_Comunes;
	private Ovni ovni;
	private long seed;
	private Level lvl;
	private UCMShip player;
	private UCMShipLaser laser;
	private Direction direccionActual;
	private Update status;
	
	public Game(Level level, long seed)
	{
		lvl = level;
		this.seed = seed;
		inicialize();
	}
	
	public void init(Level lvl)
	{
		if (lvl == Level.EASY)
		{
			for(int i=0;i<lvl.getNumCom();i++)
			{
				Localization pos=new Localization(1,i+3);
				RegularShip nave=new RegularShip(pos);
				Lista_Comunes.anadir(nave);
			}
			for(int i=0;i<lvl.getNumDestr();i++)
			{
				Localization pos = new Localization(2,i+4);
				DestroyerShip nave=new DestroyerShip(pos);
				Lista_Destructoras.anadir(nave);
			}
		}
		else if(lvl==Level.HARD)
		{
			for ( int j=0;j<2;j++)
			{
				for(int i=0;i<lvl.getNumCom()/2;i++)//Divido entre 2 porque son 8 pero 4 por columna
				{
					Localization pos=new Localization(j+1,i+3);
					RegularShip nave=new RegularShip(pos);
					Lista_Comunes.anadir(nave);
				}
			}
			
			for(int i=0;i<lvl.getNumDestr();i++)
			{
				Localization pos = new Localization(3,i+4);
				DestroyerShip nave=new DestroyerShip(pos);
				Lista_Destructoras.anadir(nave);
			}
		}
		else if(lvl==Level.INSANE)
		{
			for ( int j=0;j<2;j++)
			{
				for(int i=0;i<lvl.getNumCom()/2;i++)//Divido entre 2 porque son 8 pero 4 por columna
				{
					Localization pos=new Localization(j+1,i+3);
					RegularShip nave=new RegularShip(pos);
					Lista_Comunes.anadir(nave);
				}
			}
			
			for(int i=0;i<lvl.getNumDestr();i++)
			{
				Localization pos = new Localization(3,i+3);
				DestroyerShip nave=new DestroyerShip(pos);
				Lista_Destructoras.anadir(nave);
			}
		}
	}
	public void inicialize()
	{
		ovni =null;
		generador=new Random(seed);
		direccionActual=Direction.LEFT;
		ciclo=0;
		player=new UCMShip();
		Lista_Comunes=new RegularShipList();
		Lista_Destructoras=new DestroyerShipList();
		Lista_bombas=new BombList();
		init(lvl);
	}
	
	/*public void disparoDestructoras()
	{
		int cont=Lista_Destructoras.getCont();
		for(int i = 0;i < cont;i++)
		{
			if(probabilidad(lvl.getDisparos()))
				Lista_bombas.anadir(Lista_Destructoras.disparo(i));
					
		}
	}*/
	
	public void setStatus(Update newCondition) {
		status = newCondition;
	}
	
	public static void print(String text)
	{
		System.out.println(text);
	}
	public double devFrecDisparos()
	{
		return lvl.getDisparos();
	}
	public int devVidaPlayer()
	{
		return player.getVida();
	}
	
	public int devPuntosPlayer()
	{
		return player.getPuntos();
	}
	
	public int devNumAliens()
	{
		return Lista_Destructoras.getCont()+Lista_Comunes.getCont();
	}
	
	public String devShockwave()
	{
		if(!player.getShockwave()) return "NO";
		else return "YES";
	}
	
	private void moverLaser() {
		if (laser != null)
			laser.mover(Direction.UP.getDir());
	}
	
	private void comprobarImpacto() {
		if(laser !=null)//Avance en el laser.
		{
			if(Lista_bombas.impacto(laser.getPos()))
			{
				laser=null;
			}
			else if(Lista_Destructoras.impactoConLaser(laser.getPos(),player))
			{
				laser=null;
			}
			else if(Lista_Comunes.impactoConLaser(laser.getPos(),player))
			{
				laser=null;
			}
			else if(ovni!=null && ovni.impacto(laser.getPos()))
			{
				laser=null;
				player.addPoints(Ovni.getPuntos());
				ovni=null;
				player.earnShockwave();
				
			}
			else if(laser.Limite()) laser=null;
		}
	}
	
	private void moverBombas() {
		Lista_bombas.moverBombas(Direction.DOWN);
		if(Lista_bombas.impacto(player.getPos()))
		{
			player.reducirVida();
			
		}
	}
	
	private void moverOvni() {
		if(ovni != null)
		{

			if(!ovni.estaLimite())ovni.mover(Direction.LEFT);
			else 
				{
					ovni=null;
				}
		}
	}
	
	public Update update() {
		if (status == Update.SALIR) return status;
		moverLaser();
		comprobarImpacto();
		moverBombas();
		moverse();
		moverOvni();
		comprobarImpacto();
		
		computerAction();
		ciclo++;
		if (Lista_Destructoras.getCont() == 0 && Lista_Comunes.getCont()==0)
			status=Update.PLAYERWINS;
		else if(player.getVida()==0||Lista_Destructoras.llegoFin() || Lista_Comunes.llegoFin())
			status = Update.ALIENSWIN;
		else status=Update.CONTINUA;
		
		return status;
	}
	
	public int devCiclos()
	{
		return ciclo;
	}
	
	public void moverse()
	{
		if(Lista_Destructoras.limite(direccionActual) || Lista_Comunes.limite(direccionActual))
		{
			Lista_Destructoras.moverLista(Direction.DOWN.getDir());
			Lista_Comunes.moverLista(Direction.DOWN.getDir());
			direccionActual=Direction.swap(direccionActual);
		}
		else if(ciclo % lvl.getMovimiento()==0)
		{
			Lista_Destructoras.moverLista(direccionActual.getDir());
			Lista_Comunes.moverLista(direccionActual.getDir());
		}
	}
	
	public String characterAtToString(int i, int j)
	{//Comprobamos para naves, bombas , ucm ship y ucm ship laser y ovni)
		String simbolo=" ";
		Localization pos=new Localization(i,j);
		int x;
		if(Lista_Destructoras.compruebaPos(pos)!=-1)
		{
			x=Lista_Destructoras.compruebaPos(pos);
			simbolo=Lista_Destructoras.getSimbolo(x);
		}
		else if(Lista_Comunes.compruebaPos(pos)!=-1)
		{
			x=Lista_Comunes.compruebaPos(pos);
			simbolo=Lista_Comunes.getSimbolo(x);
		}
		else if(Lista_bombas.compruebaPos(pos)!=-1)
		{
			x=Lista_bombas.compruebaPos(pos);
			simbolo=Lista_bombas.getSimbolo(x);
		}
		else if(laser != null && laser.estaPos(pos))
		{
			simbolo=laser.getSprite();
		}
		else if(player != null && player.estaPos(pos))
		{
			simbolo=player.getSprite();
		}
		else if(ovni != null && ovni.estaPos(pos))
		{
			simbolo=ovni.getSprite();
		}
		return simbolo;
	}
	
	public void moverUCMShip(String dir)
	{
		Direction direct=Direction.conversor(dir);
		Localization coordenadas = new Localization(direct.getDir());
		player.mover(coordenadas);
	}
	
	public boolean Shockwave()
	{
		if(!player.getShockwave())
			return false;
		else
		{
			Lista_Destructoras.RestarVida();
			Lista_Comunes.RestarVida();
			Lista_Destructoras.borrarMuertos(player);
			Lista_Comunes.borrarMuertos(player);
			player.useShockwave();
			return true;
		}
	}
	
	public boolean dispara()
	{
		if(laser==null)
		{
			Localization pos1=new Localization(player.getPos());
			laser=new UCMShipLaser(pos1);
			return true;
		}
		else return false;
	}
	
	public void aumCiclo()
	{
		ciclo++;
	}
	
	public void list()
	{
		System.out.println("Comando lista: ");
		System.out.println("Nave [C]omun: Puntos: "+ RegularShip.devPuntos()+ " -Damage: "+"0"+" -Escudo: "+RegularShip.devDefaultVida());
		System.out.println("Nave [D]estructora: Puntos: "+ DestroyerShip.getPuntos()+ " -Damage: "
		+Bomb.devHit() + " - Escudo: "+ DestroyerShip.devVidaDefault());
		System.out.println("[O]vni: Puntos: "+ Ovni.getPuntos()+ " -Damage: 0"+ "- Escudo: "+Ovni.getVidaDefault());
		System.out.println(UCMShip.devIcono()+": Escudo : "+UCMShip.devVidaDefault()+" -Damage: "+UCMShipLaser.devHit());
	}
	
	public boolean probabilidad(double frec)
	{
		float num=generador.nextFloat();
		return num<frec;
	}
	
	public void computerAction()
	{
		Lista_Destructoras.disparoDestructoras(Lista_bombas,this);
		if(probabilidad(lvl.getFrecOvni()) && ovni ==null)
			ovni=new Ovni();
	}
	
	public Level getLevel()
	{
		return lvl;
	}
	public long getSeed()
	{
		return seed;
	}
}