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
import javax.swing.JTextField;

public class frmPrincipal extends JFrame {

	//Indicador de valor numerico de la primera imagen
	public static final int IndicePrimeraImagen = 1;	
	public static final int reinicioContadorFuerza= -1;
	public static final char [] palabra = {'B', 'L','A','C','K','_','C','A','T'}; //8 posiciones
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
	public int indiceJugadorALlenar= 0;
	
	public int contadorFuerza= -1;
	
	Random aleeatorio = new Random();
	Timer timer ;
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JTextField txtJugador3;
	private JTextField txtJugador4;
	private JTextField txtJugador5;
	private JTextField txtJugador6;
	private JTextField txtJugador7;
	private JTextField txtJugador8;
	
	private int contJugador1 = 1;
	private int contJugador2=1;
	private int contJugador3=1;
	private int contJugador4=1;
	private int contJugador5=1;
	private int contJugador6=1;
	private int contJugador7= 1;
	private int contJugador8=1;
	
  private PuntuacionJugadores puntuacion = new PuntuacionJugadores();
	
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
		setBounds(100, 100, 785, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelImagen = new JPanel();
			
				
		panelImagen.setBounds(114, 59, 335, 292);
							
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
		btnGirarBotella.setBounds(615, 11, 100, 23);
		panel.add(btnGirarBotella);
		
		JLabel lblJugador1 = new JLabel("Jugador1");
		lblJugador1.setBounds(249, 15, 78, 14);
		panel.add(lblJugador1);
		
		JLabel lblJugador3 = new JLabel("Jugador3");
		lblJugador3.setBounds(475, 182, 59, 14);
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
		lblJugador4.setBounds(464, 337, 70, 14);
		panel.add(lblJugador4);
		
		JLabel lblJugador6 = new JLabel("Jugador6");
		lblJugador6.setBounds(57, 337, 70, 14);
		panel.add(lblJugador6);
		
		JLabel lblJugador8 = new JLabel("Jugador8");
		lblJugador8.setBounds(69, 34, 70, 14);
		panel.add(lblJugador8);			
		
		JLabel lblJugador = new JLabel("Jugador1: ");
		lblJugador.setBounds(574, 125, 67, 14);
		panel.add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador 2:");
		lblJugador_1.setBounds(574, 165, 67, 14);
		panel.add(lblJugador_1);
		
		JLabel lblJugador_2 = new JLabel("Jugador 3:");
		lblJugador_2.setBounds(574, 201, 67, 14);
		panel.add(lblJugador_2);
		
		JLabel lblJugador_3 = new JLabel("Jugador 4:");
		lblJugador_3.setBounds(574, 238, 67, 14);
		panel.add(lblJugador_3);
		
		JLabel lblJugador_4 = new JLabel("Jugador 5:");
		lblJugador_4.setBounds(574, 272, 67, 14);
		panel.add(lblJugador_4);
		
		JLabel lblJugador_5 = new JLabel("Jugador 6:");
		lblJugador_5.setBounds(574, 307, 67, 14);
		panel.add(lblJugador_5);
		
		JLabel lblJugador_6 = new JLabel("Jugador 7:");
		lblJugador_6.setBounds(574, 337, 67, 14);
		panel.add(lblJugador_6);
		
		JLabel lblJugador_7 = new JLabel("Jugador 8:");
		lblJugador_7.setBounds(574, 373, 67, 14);
		panel.add(lblJugador_7);
		
		txtJugador1 = new JTextField();
		txtJugador1.setBounds(642, 122, 86, 20);
		panel.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		txtJugador2 = new JTextField();
		txtJugador2.setBounds(642, 162, 86, 20);
		panel.add(txtJugador2);
		txtJugador2.setColumns(10);
		
		txtJugador3 = new JTextField();
		txtJugador3.setBounds(642, 198, 86, 20);
		panel.add(txtJugador3);
		txtJugador3.setColumns(10);
		
		txtJugador4 = new JTextField();
		txtJugador4.setBounds(642, 235, 86, 20);
		panel.add(txtJugador4);
		txtJugador4.setColumns(10);
		
		txtJugador5 = new JTextField();
		txtJugador5.setBounds(642, 269, 86, 20);
		panel.add(txtJugador5);
		txtJugador5.setColumns(10);
		
		txtJugador6 = new JTextField();
		txtJugador6.setBounds(642, 304, 86, 20);
		panel.add(txtJugador6);
		txtJugador6.setColumns(10);
		
		txtJugador7 = new JTextField();
		txtJugador7.setBounds(642, 334, 86, 20);
		panel.add(txtJugador7);
		txtJugador7.setColumns(10);
		
		txtJugador8 = new JTextField();
		txtJugador8.setBounds(642, 370, 86, 20);
		panel.add(txtJugador8);
		txtJugador8.setColumns(10);
		
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
		   			indiceJugadorALlenar++;
		         contadorFuerza= reinicioContadorFuerza;
		         contJugador2++; //posición de la palabra a llenar
		         
		         txtJugador2.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
		        
		   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 
		   		 }
		   		return ;		
			case 2:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha3.png") ));	
		   		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
   			puntuacion.llenadoJugadores(indiceImagen, contJugador3, palabra);
   		   txtJugador3.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		   		 return ;
			case 3:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha4.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
   			puntuacion.llenadoJugadores(indiceImagen, contJugador4, palabra);
   		   txtJugador4.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			case 4:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha5.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
   			puntuacion.llenadoJugadores(indiceImagen, contJugador5, palabra);
   		   txtJugador5.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			case 5:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha6.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
   			puntuacion.llenadoJugadores(indiceImagen, contJugador6, palabra);
   		   txtJugador6.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		return ;
			case 6:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha7.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
   			puntuacion.llenadoJugadores(indiceImagen, contJugador7, palabra);
   		   txtJugador7.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		return ;
			case 7:
				 labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Flecha8.png") ));	
		  		 indiceImagen++;
		 		 contadorFuerza++;
		   		 System.out.println("LA fuerza es: " +contadorFuerza);
   		 if (fuerza==contadorFuerza) {
   			indiceJugadorALlenar++;
   			contadorFuerza= reinicioContadorFuerza;
			puntuacion.llenadoJugadores(indiceImagen, contJugador8, palabra);
			   txtJugador8.setText(puntuacion.llenadoJugadores(indiceImagen, contJugador2, palabra));
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
   			 indiceJugadorALlenar++;
   			
   			contadorFuerza= reinicioContadorFuerza;
   		
   			puntuacion.llenadoJugadores(indiceImagen, contJugador1, palabra);
   		 indiceJugadorALlenar =reinicioContadorFuerza;
	   		 iniciaDetiene_AnimacionImagen(verificacion);
		   		 }
		  		 return ;
			default:														
		}
	
   	
	}
}
