package com.ueb.modelo;

public class Jugador 
{
	
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------

	private int ancho;
	private int alto;
	private int posicionX;
	private int posicionY;
	
	
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------

	public Jugador(int pAncho, int pAlto, int pPosX, int pPosY )
	{
		this.ancho = pAncho;
		this.alto = pAlto;
		this.posicionX = pPosX;
		this.posicionY = pPosY;
	}
	
	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	public void moverIzquierda(int pMovimiento)
	{
		if( this.posicionX - pMovimiento > 0)
		{
			this.posicionX = this.posicionX - pMovimiento;
		}
	}
	
	public void moverDerecha(int pMovi, int pAncho)
	{
		int limite = this.posicionX + this.ancho + pMovi;
		
		if( limite < pAncho )
		{
			this.posicionX = this.posicionX + pMovi;
		}
	}
	
	public void reiniciarJugador(int pAncho)
	{
	 	this.posicionX = (int)((pAncho - this.ancho)/2);
	}
	
	
	
	public int getAncho() 
	{
		return ancho;
	}
	
	public void setAncho(int ancho)
	{
		this.ancho = ancho;
	}
	
	public int getAlto() 
	{
		return alto;
	}
	
	public void setAlto(int alto) 
	{
		this.alto = alto;
	}
	
	public int getPosicionX()
	{
		return posicionX;
	}
	
	public void setPosicionX(int posicionX)
	{
		this.posicionX = posicionX;
	}
	
	public int getPosicionY() 
	{
		return posicionY;
	}
	
	public void setPosicionY(int posicionY)
	{
		this.posicionY = posicionY;
	}

}
