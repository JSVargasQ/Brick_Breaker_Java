package com.ueb.modelo;

public class Ladrillo 
{
	
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------
	private int ancho;
	private int alto;
	private int posicionX;
	private int posicionY;
	
	private boolean visible;
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------
	
	public Ladrillo(int pAncho, int pAlto, int pPosX, int pPosY)
	{
		this.ancho = pAncho;
		this.alto = pAlto;
		this.posicionX = pPosX;
		this.posicionY = pPosY;
		
		this.visible = true;
	}


	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	
	public void destruir()
	{
		
		this.visible = false;
		
	}
	
	public void reiniciar()
	{
		this.visible = true;
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


	public boolean isVisible() 
	{
		return visible;
	}


	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	
}
