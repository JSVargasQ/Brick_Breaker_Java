package com.ueb.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.ueb.controlador.Controller;
import com.ueb.modelo.Bola;
import com.ueb.modelo.Juego;
import com.ueb.modelo.Jugador;

public class Panel extends JPanel implements KeyListener, ActionListener
{

	//-------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------

	private Controller control;
	private Timer tiempo;
	private int delay;
	private boolean estado;
	
	private boolean pausa;
	private boolean iniciado;

	private int velocidadPlayer;
	
	private String rutaAssets;
	
	
	//-------------------------------------------------
	//CONSTRUCTOR
	//-------------------------------------------------

	public Panel(Controller pControl)
	{
		this.rutaAssets = "./assets/";
		
		this.control = pControl;
		this.delay = 8;
		this.tiempo = new Timer(this.delay, this);
		this.estado = true;
		this.pausa = false;
		this.iniciado = false;
		
		this.velocidadPlayer = 10;
		
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	
	//-------------------------------------------------
	//METODOS
	//-------------------------------------------------

	public void paint(Graphics g)
	{
		Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen;
        
        
		Juego juego = this.control.getJuego();
		
		int cantLadrillos = juego.getMAX_COL_LADRILLOS()*juego.getMAX_FIL_LADRILLOS();
		
		Bola bola = juego.getBola();
		Jugador jugador = juego.getJugador();
		
		if( juego.getPuntuacion() >= cantLadrillos )
		{
			g.setColor(Color.black);
			g.fillRect(0,  0, 500, 500);
			
			g.setColor(Color.yellow);
			g.setFont( new Font( "Arial", Font.BOLD, 30 ) );
			g.drawString("¡¡Has Ganado!!.", (this.getWidth()/2)-100, (getHeight()/2)-140 );
			
			g.setFont( new Font( "Arial", Font.BOLD, 20 ) );
			g.drawString("Puntuación final: " + juego.getPuntuacion(),(this.getWidth()/2)-85 , (getHeight()/2)-20);
			g.drawString("Presiona la tecla R,", (this.getWidth()/2)-85 , (getHeight()/2)+100);
			g.drawString("para jugar de nuevo.", (this.getWidth()/2)-85 , (getHeight()/2)+140);
			
			this.velocidadPlayer = 10;
		}
		else if( this.estado == false )
		{
			g.setColor(Color.black);
			g.fillRect(0,  0, 500, 500);
			
			g.setColor(Color.white);
			g.setFont( new Font( "Arial", Font.BOLD, 30 ) );
			g.drawString("Has perdido.", (this.getWidth()/2)-85, (getHeight()/2)-140 );
			
			g.setFont( new Font( "Arial", Font.BOLD, 20 ) );
			g.drawString("Puntuación final: " + juego.getPuntuacion(),(this.getWidth()/2)-85 , (getHeight()/2)-20);
			g.drawString("Presiona la tecla R,", (this.getWidth()/2)-85 , (getHeight()/2)+100);
			g.drawString("para jugar de nuevo.", (this.getWidth()/2)-85 , (getHeight()/2)+140);
			
			this.velocidadPlayer = 10;
		}
		else if( this.iniciado == false )
		{
			//Bienvenida
			
			imagen = t.getImage( this.rutaAssets + "fondo.png");
			g.drawImage(imagen, 0, 0 , this);
			
			g.setColor(Color.black);
			g.setFont( new Font( "Arial", Font.BOLD, 20 ) );
			
			g.drawString("Bienvenido a Brick Breaker" , 120 , 80 );
			
			int x = 150;
			
			int y = 120;
			int distanciaY = 40;
			
			g.drawString("Instrucciones" , x , y+=distanciaY );
			
			g.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
			
			x = x + 10;
			
			g.drawString("Space - Empezar a jugar" , x , y+=distanciaY );
			g.drawString("P - Pausa" , x , y+=distanciaY );
			g.drawString("Right - Derecha" , x , y+=distanciaY );
			g.drawString("Left - Izquierda" , x , y+=distanciaY );
			g.drawString("Up - Subir nivel" , x , y+=distanciaY );
			g.drawString("Down - Bajar nivel" , x , y+=distanciaY );
			
			
		}
		else
		{
			//Fondo
			g.setColor( new Color(141, 179,58) );
			g.fillRect(0,  0, 500, 500);
			
			   
			g.setColor(Color.black);
						
			//Bola
			imagen = t.getImage( this.rutaAssets + "bolaBrick.png");
			g.drawImage(imagen, bola.getPosicionX(), bola.getPosicionY(), this);
			
			//Jugador
			imagen = t.getImage( this.rutaAssets + "jugadorBrick.png");
			g.drawImage(imagen, jugador.getPosicionX(), jugador.getPosicionY(), this);
			
			
			Rectangle rectangleJugador = new Rectangle(jugador.getPosicionX(), jugador.getPosicionY(), jugador.getAncho(), jugador.getAlto());
			Rectangle rectangleBola = new Rectangle(bola.getPosicionX(), bola.getPosicionY(), bola.getAncho(), bola.getAlto());

			if( rectangleBola.intersects( rectangleJugador ) )
			{
				bola.invertirY();
				
				if( jugador.getPosicionX() + (jugador.getAncho()/2) > bola.getPosicionX() )
				{
					if( bola.getDirX() > 0 )
					{
						bola.invertirX();
					}
				}
				else
				{
					if( bola.getDirX() < 0  )
					{
						bola.invertirX();

					}
				}	
			}
			//Ladrillos
			imagen = t.getImage( this.rutaAssets + "ladrilloBrick.png");
			
			for (int i = 0; i < this.control.getJuego().getMAX_FIL_LADRILLOS() ; i++) 
			{
				for (int j = 0; j < this.control.getJuego().getMAX_COL_LADRILLOS(); j++) 
				{
					
					int x = juego.getLadrillos()[i][j].getPosicionX();
					int y = juego.getLadrillos()[i][j].getPosicionY();
					int ancho = juego.getLadrillos()[i][j].getAncho();
					int alto = juego.getLadrillos()[i][j].getAlto();
					
					if(juego.getLadrillos()[i][j].isVisible())
					{
						g.drawImage(imagen, x, y, this);
						Rectangle ladrillo  = new Rectangle(x, y, ancho, alto);
						
						if( ladrillo.intersects(rectangleBola) )
						{
							juego.getLadrillos()[i][j].setVisible(false);
							
							bola.invertirY();
							juego.setPuntuacion( juego.getPuntuacion() + 1 );
						}
					}
				}
			}
			
			//Puntaje
			g.setColor(Color.black);
			g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
			g.drawString("Puntuación: " + juego.getPuntuacion(), 380 , 27 );
			
			
			//Dificultad
			g.drawString("Dificultad: " + juego.getDificultad(), 20 , 27 );
			
			//Pausa
			if( this.pausa == true)
			{
				g.drawString("Juego pausado", 200 , 380 );
			}

			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if( e.getKeyCode() == KeyEvent.VK_SPACE && this.estado==true && this.pausa==false )
		{
			this.tiempo.start();
			this.iniciado = true;
		}
		else if( e.getKeyCode() == KeyEvent.VK_RIGHT && this.estado==true )
		{
			this.control.getJuego().getJugador().moverDerecha(this.velocidadPlayer, this.getWidth());
		}
		else if( e.getKeyCode() == KeyEvent.VK_LEFT && this.estado==true )
		{
			this.control.getJuego().getJugador().moverIzquierda(this.velocidadPlayer);
		}
		else if(e.getKeyCode() == KeyEvent.VK_R && this.estado==false)
		{
			this.control.getJuego().reiniciar();
		}
		else if(e.getKeyCode() == KeyEvent.VK_P && this.estado==true && this.iniciado==true  )
		{
			if(this.pausa == false)
			{
				this.tiempo.stop();
				this.pausa = true;
				this.repaint();
			}
			else
			{
				this.tiempo.start();
				this.pausa = false;
			}
		}
		else if( e.getKeyCode() == KeyEvent.VK_UP )
		{
			this.control.getJuego().subirDificultad();
			this.velocidadPlayer = this.velocidadPlayer*2;
			this.repaint();
		}
		else if( e.getKeyCode() == KeyEvent.VK_DOWN && this.control.getJuego().getDificultad() > 1 )
		{
			this.control.getJuego().bajarDificultad();
			this.velocidadPlayer = this.velocidadPlayer/2;
			this.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		this.tiempo.start();
		this.repaint();
		this.estado = this.control.getJuego().getBola().mover(getWidth(), getHeight());
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
}
