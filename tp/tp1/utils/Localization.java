package tp.tp1.utils;

public class Localization {
	private int f;  //La clase Localizacion consta de 2 atributos , las filas y las columnas.
	private int c;
	
	final int F_Lim=9;
	final int C_Lim=8;
	final int Cero=0;
	final int fueraDebajo=-1;
	final int fueraArriba=8;
	//Creamos dos constructores , uno en caso de meter como argumentos las filas y columnas y otro para meter como argumentos una localizacion
	public Localization(int fila, int col)
	{
		f=fila;
		c=col;
	}
	public Localization (Localization loc) {
		f = loc.getF();
		c = loc.getC();
	}
	
	public int getF()
	{
		return f;
	}
	public int getC()
	{
		return c;
	}
	//SetLoc me movera una objeto de acuerdo a una posicion que yo meta que sera (1,0), (0,1).... que definen los movimientos horizontales y verticales
	public void setLoc(Localization dir) {
		this.f+=dir.f;
		if(this.f>=F_Lim || this.f<Cero)
		{
			this.f-=dir.f;
		}
		this.c+=dir.c;
		if(this.c>C_Lim || this.c<Cero)
		{
			this.c-=dir.c;
		}
	}
	
	public boolean comprobar(Localization pos)
	{
		return (f==pos.f && c == pos.c);
	}
	
	//Comprobamos si en el tablero hay un objeto con movimiento horizontal/vertical de acuerdo a su direccion
	
	public boolean posLimiteHorizontal(Direction dir)
	{
		if(c==C_Lim && dir == Direction.RIGHT || c==Cero && dir == Direction.LEFT) return true;
		else return false;
	}
	public boolean posLimiteVertical(Direction dir)
	{
		if(f==fueraDebajo && dir == Direction.UP || f==fueraArriba && dir==Direction.DOWN) return true;
		else return false;
	}
	//Definimos el movimiento de los misiles que es diferente al de las naves
	public void movMisil(Localization dir)
	{
		this.f+=dir.f;
		this.c+=dir.c;
	}
}
