package com.ueb.vista;

import javax.swing.JFrame;

import com.ueb.controlador.Controller;

public class VentanaPrincipal extends JFrame
{
	
	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------

	private Panel panel;
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------

	public VentanaPrincipal(Controller pController, int pAncho, int pAlto)
	{
		this.panel = new Panel( pController);
		this.add( this.panel );
		
		this.setBounds(400, 100, pAncho, pAlto+29  );
		this.setTitle("BrickBreacker");
		
		this.setResizable( false );
		
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setVisible( true );
		
	}

	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	

}
