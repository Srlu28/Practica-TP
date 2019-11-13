package tp.tp1.utils;

public enum Level {
	EASY(4,2,0.1,3,0.5),
	HARD(8,2,0.3,2,0.2),
	INSANE(8,4,0.5,1,0.1);
	
	private int numComunes;
	private int numDestr;
	private double frecDisp;
	private int movimiento;
	private double frecOvni;
	
	private Level(int numRegular,int numDestroy,double frecShoot, int frecMove,double frecOvni)
	{
		numComunes=numRegular;
		numDestr=numDestroy;
		frecDisp=frecShoot;
		movimiento=frecMove;
		this.frecOvni=frecOvni;
	}
	
	public int getNumCom()
	{
		return numComunes;
	}
	public int getNumDestr()
	{
		return numDestr;
	}
	
	public static Level conversor(String nivel)
	{
		nivel=nivel.toUpperCase();
		if(nivel.contentEquals("EASY")) return EASY;
		else if(nivel.contentEquals("HARD")) return HARD;
		else if(nivel.contentEquals("INSANE"))return INSANE;
		else return null;
	}
	
	public int getMovimiento()
	{
		return movimiento;
	}
	public double getFrecOvni()
	{
		return frecOvni;
	}
	public double getDisparos()
	{
		return frecDisp;
	}
	
}