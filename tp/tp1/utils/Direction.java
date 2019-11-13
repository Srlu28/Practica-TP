package tp.tp1.utils;

public enum Direction {
	LEFT(new Localization(0,-1)),
	RIGHT(new Localization(0,1)),
	UP(new Localization(-1,0)),
	DOWN(new Localization(1,0));

	private Localization coordenadas;
	
	private Direction(Localization pos)
	{
		coordenadas=pos;
	}
	
	public Localization getDir()
	{
		return coordenadas;
	}
	
	//Dada una direccion la cambia por su complementaria, lo usaremos para las naves enemigas.
	public static Direction swap(Direction dir) {
		if (dir == Direction.LEFT) return Direction.RIGHT;
		else return Direction.LEFT;
	}
	
	public static Direction conversor(String dir)
	{
		dir=dir.toUpperCase();
		if(dir.contentEquals("LEFT"))return LEFT;
		else if(dir.contentEquals("RIGHT")) return RIGHT;
		else if(dir.contentEquals("UP"))return UP;
		else if(dir.contentEquals("DOWN"))return DOWN;
		else return null;
	}
}
