package com.ueb.controlador;

import com.ueb.modelo.Juego;
import com.ueb.vista.VentanaPrincipal;

public class Controller 
{
	
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------
	
	private Juego juego;
	private VentanaPrincipal ventana;
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------

	public Controller()
	{
		this.juego = new Juego();
		this.ventana = new VentanaPrincipal(this, this.juego.getANCHO(), this.juego.getALTO());
	}
	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	
	public Juego getJuego()
	{
		return this.juego;
	}
	
	
}
