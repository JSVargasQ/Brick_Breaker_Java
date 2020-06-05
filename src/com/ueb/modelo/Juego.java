package com.ueb.modelo;

public class Juego 
{

	
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------
	
	private int MAX_COL_LADRILLOS;
	private int MAX_FIL_LADRILLOS;

	private int ANCHO;
	private int ALTO;
	
	private int puntuacion;
	private boolean estado;
	
	private Ladrillo[][] ladrillos;
	private Bola bola;
	
	private Jugador jugador;
	
	private int dificultad;
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------

	public Juego()
	{
		this.MAX_COL_LADRILLOS = 6;
		this.MAX_FIL_LADRILLOS = 3;
		
		this.ANCHO = 500;
		this.ALTO = 500;
		
		this.estado = true;
		
		this.ladrillos = new Ladrillo[this.MAX_FIL_LADRILLOS][this.MAX_COL_LADRILLOS];

		this.jugador = new Jugador(100, 15, 170, 480);
		
		this.iniciarBola();
		this.inicializarLadrillos();
		
		this.puntuacion = 0;
		this.dificultad = 1;
		
		
	}
	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	public void inicializarLadrillos()
	{
		for (int i = 0; i < this.MAX_FIL_LADRILLOS; i++) 
		{
			for (int j = 0; j < this.MAX_COL_LADRILLOS; j++) 
			{
				this.ladrillos[i][j] = new Ladrillo(40, 30, (j*60)+80, (i*70)+60);
			}
		}
	}
	
	public void reiniciar()
	{
		this.inicializarLadrillos();
		
		this.iniciarBola();
		
		this.puntuacion = 0;
		this.dificultad = 1;
	}
	
	public void iniciarBola()
	{
		this.bola = new Bola(20, 20, 240, 325, 1, -2);
	}
	
	public void subirDificultad()
	{
		
		this.bola.setDirX( this.bola.getDirX()*2 ); 
		this.bola.setDirY( this.bola.getDirY()*2 );
		
		this.dificultad = this.dificultad + 1;
		
	}
	
	public void bajarDificultad()
	{
		this.bola.setDirX( this.bola.getDirX()/2 ); 
		this.bola.setDirY( this.bola.getDirY()/2 );
		
		this.dificultad = this.dificultad - 1;
		
	}
	

	public int getMAX_COL_LADRILLOS() 
	{
		return MAX_COL_LADRILLOS;
	}

	public void setMAX_COL_LADRILLOS(int mAX_COL_LADRILLOS) 
	{
		MAX_COL_LADRILLOS = mAX_COL_LADRILLOS;
	}

	public int getMAX_FIL_LADRILLOS() 
	{
		return MAX_FIL_LADRILLOS;
	}

	public void setMAX_FIL_LADRILLOS(int mAX_FIL_LADRILLOS) 
	{
		MAX_FIL_LADRILLOS = mAX_FIL_LADRILLOS;
	}

	public int getANCHO()
	{
		return ANCHO;
	}

	public void setANCHO(int aNCHO)
	{
		ANCHO = aNCHO;
	}

	public int getALTO()
	{
		return ALTO;
	}

	public void setALTO(int aLTO)
	{
		ALTO = aLTO;
	}

	public int getPuntuacion()
	{
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
	}

	public boolean isEstado() 
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	public Ladrillo[][] getLadrillos() 
	{
		return ladrillos;
	}

	public void setLadrillos(Ladrillo[][] ladrillos)
	{
		this.ladrillos = ladrillos;
	}

	public Bola getBola() 
	{
		return bola;
	}

	public void setBola(Bola bola) 
	{
		this.bola = bola;
	}

	public Jugador getJugador() 
	{
		return jugador;
	}

	public void setJugador(Jugador jugador)
	{
		this.jugador = jugador;
	}

	public int getDificultad()
	{
		return dificultad;
	}

	public void setDificultad(int dificultad) 
	{
		this.dificultad = dificultad;
	}
	
	
	
	
}
