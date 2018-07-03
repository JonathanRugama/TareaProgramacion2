import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Canvas;
import java.util.Random;

//Librerias Añadidas

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPrincipal extends JFrame {

	//Indicador de valor numerico de la primera imagen
	public static final int IndicePrimeraImagen = 1;	
	public static final int reinicioContadorFuerza= 0;
	private JPanel contentPane;	
	// Panel que contiene Imagen
	public JPanel panelImagen;
	// Label que contiene la Imagen de flecha
	public JLabel labelImagen;
	// Bandera que indica si la animacion giro de la botella esta activo
	public Boolean esGirando;
	// Clase que implenta tarea del timer
	public TimerTask timerTask ;
	
	public int indiceImagen=0;
	
	public int contadorFuerza= 0;
	
	Random aleeatorio = new Random();
	Timer timer ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la Clase Inerfaz Princial
	 */
	public frmPrincipal() {
		//Inicializa Variables 
		esGirando = false;
		indiceImagen=IndicePrimeraImagen;
		
		
		//Inicializa Componentes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelImagen = new JPanel();
			
				
		panelImagen.setBounds(113, 55, 335, 292);
							
		panel.add(panelImagen);
			
		//panelImagen.add(canvasImagen);
		labelImagen = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Flecha1.png")));
		panelImagen.add(labelImagen);				
		
		JButton btnGirarBotella = new JButton("GirarBotella");
		btnGirarBotella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciaDetiene_AnimacionImagen(true);				
			}
		});
		btnGirarBotella.setBounds(0, 0, 100, 23);
		panel.add(btnGirarBotella);
		
		JLabel lblJugador1 = new JLabel("Jugador1");
		lblJugador1.setBounds(249, 15, 78, 14);
		panel.add(lblJugador1);
		
		JLabel lblJugador3 = new JLabel("Jugador3");
		lblJugador3.setBounds(458, 182, 59, 14);
		panel.add(lblJugador3);
		
		JLabel lblJugador5 = new JLabel("Jugador5");
		lblJugador5.setBounds(249, 358, 78, 14);
		panel.add(lblJugador5);
		
		JLabel lblJugador7 = new JLabel("Jugador7");
		lblJugador7.setBounds(22, 182, 67, 14);
		panel.add(lblJugador7);
		
		JLabel lblJugador2 = new JLabel("Jugador2");
		lblJugador2.setBounds(434, 34, 70, 14);
		panel.add(lblJugador2);
		
		JLabel lblJugador4 = new JLabel("Jugador4");
		lblJugador4.setBounds(447, 333, 70, 14);
		panel.add(lblJugador4);
		
		JLabel lblJugador6 = new JLabel("Jugador6");
		lblJugador6.setBounds(69, 333, 70, 14);
		panel.add(lblJugador6);
		
		JLabel lblJugador8 = new JLabel("Jugador8");
		lblJugador8.setBounds(69, 34, 70, 14);
		panel.add(lblJugador8);			
		
		timer = new Timer();
	}
	/** Metodo encarcago de controlar la animacion  
	    esGirando = false Inicia Animacion
	   esGirando = true  Detiene Animacion */	
	public void iniciaDetiene_AnimacionImagen(boolean verificacion)
	{
		int fuerza = aleeatorio.nextInt(25);
		if(!esGirando) //es decir, si no gira es igual false
		{			  
		
			System.out.println("La fuerza es de "+fuerza);
			 TimerTask tiempo = new TimerTask(){ 
		         public void run()  
		         { 
		        	 logicaTimer(fuerza);	             
		         } 
		     };
		                             
			  timer.scheduleAtFixedRate(tiempo, 0, 125);  //task,Retraso,Intervalo ciclo milisegundos	 			
			  esGirando = verificacion;
		}else
		{
			timer.cancel();
			timer.purge();
			timer = new Timer();
			esGirando = verificacion;
		}
	}
	/** Acciones del timer en cada ciclo, controla el cambio de imagen de acuerdo el  indiceImagen    */
	public void logicaTimer(int fuerza)

	{
		boolean verificacion = false;
		switch(indiceImagen)
		{
			case 1:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha2.png") ));	
		   		 indiceImagen++;
		   		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
		   		 if (fuerza==contadorFuerza) {
		         contadorFuerza= reinicioContadorFuerza;
		   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		   		return ;		
			case 2:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha3.png") ));	
		   		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		   		 return ;
			case 3:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha4.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			case 4:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha5.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			case 5:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha6.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		return ;
			case 6:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha7.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		return ;
			case 7:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha8.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
		  		 //Ultima iteracion reinicia el indice
			case 8: 
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha1.png") ));					
				 indiceImagen=IndicePrimeraImagen;
				 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   		
   			contadorFuerza= reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			default:														
		}
	
   	
	}
}
