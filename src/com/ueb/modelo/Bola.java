package com.ueb.modelo;

public class Bola 
{
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------

	
	private int ancho;
	private int alto;
	private int posicionX;
	private int posicionY;
	private int dirX;
	private int dirY;
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------	
	
	public Bola(int pAncho, int pAlto, int pPosX, int pPosY, int pDirX, int pDirY )
	{
		this.ancho = pAncho;
		this.alto = pAlto;
		this.posicionX = pPosX;
		this.posicionY = pPosY;
		this.dirX = pDirX;
		this.dirY = pDirY;
	}
	

	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	
	public boolean mover(int pAlto, int pAncho)
	{
		boolean rta = true;
		
		if( this.dirX > 0 && dirY < 0 )
		{
			if( this.posicionY + this.dirY < 0)
			{
				this.invertirY();
			}
			if( this.posicionX + this.dirX + this.ancho > pAncho )
			{
				this.invertirX();
			}
			
		}
		else if( this.dirX < 0 && dirY < 0 )
		{
			if( this.posicionY + this.dirY < 0 )
			{
				this.invertirY();
			}
			if( this.posicionX + this.dirX < 0 )
			{
				this.invertirX();
			}
		}
		else if( this.dirX < 0 && this.dirY > 0  )
		{
			if(this.posicionY + this.dirY > pAlto)
			{
				rta = false;
			}
			if( this.posicionX + this.dirX < 0 )
			{
				this.invertirX();
			}
		}
		else if(  this.dirX > 0 && this.dirY > 0)
		{
			if( this.posicionY + this.dirY + this.alto > pAlto )
			{
				rta = false;
			}
			if( this.posicionX + this.dirX + this.ancho > pAncho)
			{
				this.invertirX();
			}
		}
		
		this.posicionX = this.posicionX + this.dirX;
		this.posicionY = this.posicionY + this.dirY;
		
		return rta;
		
	}
	
	public void invertirX()
	{
		this.dirX = -(this.dirX);
	}
	
	public void invertirY()
	{
		this.dirY = -(this.dirY);
	}
	
	
	public int getAncho() 
	{
		return ancho;
	}

	public void setAncho(int ancho) {
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

	public int getDirX()
	{
		return dirX;
	}

	public void setDirX(int dirX) 
	{
		this.dirX = dirX;
	}

	public int getDirY() 
	{
		return dirY;
	}

	public void setDirY(int dirY)
	{
		this.dirY = dirY;
	}
	
	
	
	

}
