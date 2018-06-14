import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;



public class Interfaz extends JFrame implements Runnable {
	//definicion de objetos y atributos
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextArea txtDireccion;
	private JScrollPane ScrollDireccion;
	private JTextField txtTelefono;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JMenuBar menuBar;
	private JTextField txtActualizarCliente;
	private JTextField txtEliminarCliente;
	public FrameTransaccion frameIngresarT;
	public FrameTransaccion frameActualizarT;
	public FrameATrans frameTA;
	public FrameTarjeta frameIngresarTarj;
	public FrameATarj frameTarjA;
	private Timer timer;
	private JTextField txtActualizarTrans;
	private JTextField txtEliminar;
	private JTextField txtActualizar;
	private JTextField txtEliminarTarj;
	private String hora, minutos, segundos, ampm;
	private Calendar calendario;
	private String reloj;
	private JLabel lblReloj = new JLabel("");
	private Thread h1;
	
	
	
	public Interfaz() throws InterruptedException {
		h1 = new Thread(this);//se crea el hilo
		h1.start();//se inicia el hilo
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/Imagenes/usuario.png")));//se agrega el icono al Frame
		setTitle("Clientes");//se le da el titulo al Frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//se añade al contenido del panel
		setBounds(100, 100, 992, 608);//selecciona la ubicacion
		setLocationRelativeTo(null);//se posiciona en el centro
		setResizable(false);//evita que se modifique
		contentPane.setLayout(null);//permite colocar los botones en cualquier posicion
		
		menuBar = new JMenuBar();//se crea la barra de menu
		setJMenuBar(menuBar);//se envia la barra
		
		JMenu mnACercaDe = new JMenu("Acerca de");//se crea la barra de acerca de
		mnACercaDe.setToolTipText("Brinda informaci\u00F3n sobre el programa y autores");//texto informativo de la barra
		menuBar.add(mnACercaDe);//se añade a la barra de menu
		
		JMenuItem mntmPrograma = new JMenuItem("Programa");//se crea el menú item
		mntmPrograma.setToolTipText("Brinda informaci\u00F3n acerca de la aplicaci\u00F3n");//texto informativo
		mnACercaDe.add(mntmPrograma);//se añade añ menú a cerca de
		
		JMenuItem mntmAutores = new JMenuItem("Autores");//se crea el menu item
		mntmAutores.setToolTipText("Brinda informaci\u00F3n acerca de los creadores de la aplicaci\u00F3n");//texto informativo
		mntmAutores.addActionListener(new ActionListener() {//evento del menu item
			public void actionPerformed(ActionEvent e) {
				//muesta un mensaje con los nombres de los autores
				JOptionPane.showMessageDialog(null, "Cortés Baltodano Elier B72410 \nRugama Obando Jonathan B56367", "INFORMACIÓN DE LOS AUTORES", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnACercaDe.add(mntmAutores);//se añade al menu 
		
		btnSalir = new JButton("Salir");//se crea el boton de salir
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));//se define el tipo de letra 
		btnSalir.addActionListener(new ActionListener() {//evento del boton
			public void actionPerformed(ActionEvent e) {
				
				//condicional que pregunta que se desea salir
				if (JOptionPane.showConfirmDialog(null,
						"¿DESEA FINALIZAR?", "FINALIZAR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION  ) {
					JOptionPane.showMessageDialog(null,"PROGRAMA FINALIZADO");	
					System.exit(0);
			}
			}
		});
		btnSalir.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/salida.png")));//se le añade imagen al boton
		btnSalir.setToolTipText("Salir del Sistema de forma definitiva");//texto informativo
		btnSalir.setBounds(502, 506, 110, 32);//se define la posicion
		contentPane.add(btnSalir);//se añade al Frame
		
		JPanel panelTransaccion = new JPanel();//se crea el panel
		panelTransaccion.setLayout(null);//
		panelTransaccion.setOpaque(false);//se pone opaco
		panelTransaccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));//se le define el tipo de borde
		panelTransaccion.setBounds(344, 170, 268, 157);//se le añade la posicion
		contentPane.add(panelTransaccion);//se agraga el panel
		
		
		//se crea el boton de eliminar y se le añaden sus propiedades, luego se añade al frame
		JButton btnEliminarTrans = new JButton("Eliminar");
		btnEliminarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		btnEliminarTrans.setToolTipText("Eliminar las transacciones realizadas");
		btnEliminarTrans.setBounds(127, 108, 111, 25);
		panelTransaccion.add(btnEliminarTrans);
		
		//boton actualizafr con sus propiedades y un eventp
		JButton btnActualizarTrans = new JButton("Actualizar");
		btnActualizarTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frameTA = new FrameATrans();//se crea un objeto de frame
					
					frameTA.setVisible(true);//se hace visible el objeto
			}
		});
		btnActualizarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		btnActualizarTrans.setToolTipText("Actualiza las transacciones que \r\nse encuentran en la base de datos");
		btnActualizarTrans.setBounds(127, 73, 111, 23);
		panelTransaccion.add(btnActualizarTrans);
		
		//label que sirve como titulo de transaccion con sus respectivas propiedades
		JLabel lblTransaccion = new JLabel("Transacci\u00F3n:");
		lblTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransaccion.setBounds(10, 37, 111, 14);
		panelTransaccion.add(lblTransaccion);
		
		//se crea el campo de texto con sus propiedades y se añade al frame
		txtActualizarTrans = new JTextField();
		txtActualizarTrans.setToolTipText("Ingrese el n\u00FAmero de transacci\u00F3n a actualizar");
		txtActualizarTrans.setColumns(10);
		txtActualizarTrans.setBounds(10, 74, 86, 20);
		panelTransaccion.add(txtActualizarTrans);
		
		txtEliminar = new JTextField();
		txtEliminar.setToolTipText("Ingrese el n\u00FAmero de transacci\u00F3n a eliminar");
		txtEliminar.setColumns(10);
		txtEliminar.setBounds(10, 110, 86, 20);
		panelTransaccion.add(txtEliminar);
		
		//se crea el boton para ingresar transacciones con sus respectivas propiedades
		JButton btnIngresarTrans = new JButton("Ingresar");
		btnIngresarTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//creacion del evento donde se crea un objeto de frame y lo hace visible, enviandole como
				 frameIngresarT = new FrameTransaccion("INGRESAR TRANSACCION", "Ingresar", false);//parametros el titulo del frame y de un boton
				 frameIngresarT.setVisible(true);//lo hace visible
			}
		});
		btnIngresarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/ingresar.png")));
		btnIngresarTrans.setToolTipText("Ingresar una transacci\u00F3n a la base de datos");
		btnIngresarTrans.setBounds(128, 35, 110, 23);
		panelTransaccion.add(btnIngresarTrans);
		//se crea un nuevo panel, defiendo sus propiedades y añadiendolo al frame
		JPanel panelCliente = new JPanel();
		panelCliente.setOpaque(false);
		panelCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCliente.setBounds(344, 30, 268, 122);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		//se crea un boton eliminar con sus respectivas propiedades
		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setBounds(106, 72, 130, 25);
		panelCliente.add(btnEliminarCliente);
		btnEliminarCliente.setToolTipText("Eliminar los datos del cliente");
		btnEliminarCliente.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		
		//se crea el boton para actualizar los datos del cliente, con sus propiedades
		JButton btnActualizarCliente = new JButton("Actualizar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizarCliente.setBounds(106, 37, 130, 23);
		panelCliente.add(btnActualizarCliente);
		btnActualizarCliente.setToolTipText("Genera una acci\u00F3n para poder actualizar los datos del cliente");
		btnActualizarCliente.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		
		//label como titulo 
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(10, 11, 89, 14);
		panelCliente.add(lblCliente);
		//campo de texto para enviar el nuemro de cedula del cliente a actualizar
		txtActualizarCliente = new JTextField();
		txtActualizarCliente.setBounds(10, 38, 86, 20);
		panelCliente.add(txtActualizarCliente);
		txtActualizarCliente.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del clienta a actualizar");
		txtActualizarCliente.setColumns(10);
		//campo de texto para enviar el nuemro de cedula del cliente a eliminar
		txtEliminarCliente = new JTextField();
		txtEliminarCliente.setBounds(10, 74, 86, 20);
		panelCliente.add(txtEliminarCliente);
		txtEliminarCliente.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtEliminarCliente.setColumns(10);
		
		//se crea un nuevo panel, para ingresar clientes
		JPanel ingresarCliente = new JPanel();
		ingresarCliente.setBackground(new Color(153, 153, 153));
		ingresarCliente.setOpaque(false);
		ingresarCliente.setForeground(new Color(30, 144, 255));
		ingresarCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ingresarCliente.setBounds(10, 30, 319, 465);
		contentPane.add(ingresarCliente);
		ingresarCliente.setLayout(null);
		//se crea un nuevo boton y se le definen sus propiedades
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(22, 408, 110, 25);
		ingresarCliente.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/login.png")));
		btnIngresar.setToolTipText("Ingresa los datos a la base de datos");
		//se crea un conjunto de etiquetas que representan los datos solicitados al cliente
		JLabel lblFechaNacimiento = new JLabel("Fecha de "+"\nnacimiento:");
		lblFechaNacimiento.setBounds(23, 346, 110, 14);
		ingresarCliente.add(lblFechaNacimiento);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(22, 298, 82, 14);
		ingresarCliente.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(127, 296, 86, 20);
		ingresarCliente.add(txtTelefono);
		txtTelefono.setToolTipText("N\u00FAmero de tel\u00E9fono del cliente");
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(22, 212, 110, 14);
		ingresarCliente.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//se crea un scroll y un textArea para el ingreso de la direccion del cliente
		ScrollDireccion = new JScrollPane((Component) null);
		ScrollDireccion.setBounds(127, 207, 175, 65);
		ingresarCliente.add(ScrollDireccion);
		ScrollDireccion.setEnabled(false);
		ScrollDireccion.setPreferredSize(new Dimension(0, 0));
		
		txtDireccion = new JTextArea();
		txtDireccion.setToolTipText("Direcci\u00F3n del cliente");
		ScrollDireccion.setViewportView(txtDireccion);
		
		JLabel lblApellido2 = new JLabel("Segundo apellido:");
		lblApellido2.setBounds(22, 170, 110, 14);
		ingresarCliente.add(lblApellido2);
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(127, 168, 86, 20);
		ingresarCliente.add(txtApellido2);
		txtApellido2.setToolTipText("Segundo apellido del cliente");
		txtApellido2.setColumns(10);
		
		JLabel lblApellido1 = new JLabel("Primer apellido:");
		lblApellido1.setBounds(22, 134, 82, 14);
		ingresarCliente.add(lblApellido1);
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtApellido1 = new JTextField();
		txtApellido1.setBounds(127, 132, 86, 20);
		ingresarCliente.add(txtApellido1);
		txtApellido1.setToolTipText("Primer apellido del cliente");
		txtApellido1.setColumns(10);
		
			
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(22, 96, 61, 14);
			ingresarCliente.add(lblNombre);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			txtNombre = new JTextField();
			txtNombre.setBounds(127, 94, 86, 20);
			ingresarCliente.add(txtNombre);
			txtNombre.setToolTipText("Nombre completo del cliente");
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("C\u00E9dula:");
			lblCedula.setBounds(22, 55, 46, 14);
			ingresarCliente.add(lblCedula);
			lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			txtCedula = new JTextField();
			txtCedula.setBounds(127, 53, 86, 20);
			ingresarCliente.add(txtCedula);
			txtCedula.setToolTipText("Ingresa el n\u00FAmero de c\u00E9dula del cliente");
			txtCedula.setColumns(10);
			
			JLabel lblIngresarCliente = new JLabel("Ingresar Cliente:");
			lblIngresarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblIngresarCliente.setBounds(22, 11, 158, 14);
			ingresarCliente.add(lblIngresarCliente);
			//se crea un calendario para seleccionar la fecha de nacimiento del cliente
			JDateChooser dcCalendario = new JDateChooser();
			dcCalendario.setToolTipText("Seleccione la fecha de nacimiento del cliente");
			dcCalendario.setDateFormatString("dd/MMM/yyyy");
			dcCalendario.setBounds(127, 340, 95, 20);
			ingresarCliente.add(dcCalendario);
		
		
		//se crea ub nuevo panel
		JPanel panelTablaTarj = new JPanel();
		panelTablaTarj.setLayout(null);
		panelTablaTarj.setOpaque(false);
		panelTablaTarj.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTablaTarj.setBounds(622, 338, 354, 157);
		contentPane.add(panelTablaTarj);
		//label para tabla tarjera con sus respectivas propiedades
		JLabel lblTablaTarjeta = new JLabel("Tabla Tarjeta:");
		lblTablaTarjeta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTablaTarjeta.setBounds(10, 11, 145, 14);
		panelTablaTarj.add(lblTablaTarjeta);
		//panel y sus propiedades
		JPanel panelTablaTrans = new JPanel();
		panelTablaTrans.setLayout(null);
		panelTablaTrans.setOpaque(false);
		panelTablaTrans.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTablaTrans.setBounds(622, 170, 354, 157);
		contentPane.add(panelTablaTrans);
		
		JLabel lblTablaTransaccion = new JLabel("Tabla Transacci\u00F3n:");
		lblTablaTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTablaTransaccion.setBounds(10, 11, 145, 14);
		panelTablaTrans.add(lblTablaTransaccion);
		
		JPanel panelTablaCliente = new JPanel();
		panelTablaCliente.setLayout(null);
		panelTablaCliente.setOpaque(false);
		panelTablaCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTablaCliente.setBounds(622, 30, 354, 122);
		contentPane.add(panelTablaCliente);
		
		JLabel lblTablaCliente = new JLabel("Tabla Cliente:");
		lblTablaCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTablaCliente.setBounds(10, 11, 95, 14);
		panelTablaCliente.add(lblTablaCliente);
		
		JPanel panelTarjeta = new JPanel();
		panelTarjeta.setLayout(null);
		panelTarjeta.setOpaque(false);
		panelTarjeta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTarjeta.setBounds(344, 338, 268, 157);
		contentPane.add(panelTarjeta);
		//se crea un nuevo boton para eliminar tarjetas y se le definen sus propiedades
		JButton btnEliminarTarj = new JButton("Eliminar");
		btnEliminarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		btnEliminarTarj.setToolTipText("Seg\u00FAn el n\u00FAmero de tarjeta seleccionado, se podra eliminar");
		btnEliminarTarj.setBounds(127, 102, 111, 25);
		panelTarjeta.add(btnEliminarTarj);
		//se crea un boton para actualizar los datos de la tarjeta
		JButton btnActualizarTarj = new JButton("Actualizar");
		btnActualizarTarj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//genera un evento donde crea un objeto frame y lo hace visible
				
				 frameTarjA= new FrameATarj();
					frameTarjA.setVisible(true);
			}
		});
		btnActualizarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		btnActualizarTarj.setToolTipText("Seg\u00FAn el n\u00FAmero de tarjeta seleccionado de la tabla, se podra actualizar");
		btnActualizarTarj.setBounds(127, 67, 111, 23);
		panelTarjeta.add(btnActualizarTarj);
		
		JLabel lblTarjeta = new JLabel("Tarjeta:");
		lblTarjeta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarjeta.setBounds(10, 31, 111, 14);
		panelTarjeta.add(lblTarjeta);
		
		txtActualizar = new JTextField();
		txtActualizar.setToolTipText("Ingrese el n\u00FAmero de la tarjeta a actualizar");
		txtActualizar.setColumns(10);
		txtActualizar.setBounds(10, 68, 86, 20);
		panelTarjeta.add(txtActualizar);
		
		txtEliminarTarj = new JTextField();
		txtEliminarTarj.setToolTipText("Ingrese el n\u00FAmero de la tarjeta a eliminar");
		txtEliminarTarj.setColumns(10);
		txtEliminarTarj.setBounds(10, 104, 86, 20);
		panelTarjeta.add(txtEliminarTarj);
		//nuevo boton para ingresar con sus respecitvas propiedades
		JButton btnIngresarTarj = new JButton("Ingresar");
		btnIngresarTarj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameIngresarTarj = new FrameTarjeta ("INGRESAR TARJETA", "Ingresar");
				frameIngresarTarj.setVisible(true);
			}
		});
		btnIngresarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/ingresar.png")));
		btnIngresarTarj.setToolTipText("Ingresa los datos de tarjeta");
		btnIngresarTarj.setBounds(128, 29, 110, 23);
		panelTarjeta.add(btnIngresarTarj);
		
		//panel que sirvirá como una barra de estado
		JPanel barraEstado = new JPanel();
		barraEstado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		barraEstado.setBounds(6, 508, 486, 30);
		barraEstado.setOpaque(false);
		contentPane.add(barraEstado);
		barraEstado.add(lblReloj);

		JLabel lblImagenFondo = new JLabel("New label");
		lblImagenFondo.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/FondoFrame.jpg")));
		lblImagenFondo.setBounds(0, 0, 986, 561);
		contentPane.add(lblImagenFondo);
		
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//evita que se cierre la principal al cerrar otro frame con la x
		
	
	}


	public void run() {
	
		Thread ct = Thread.currentThread();

		while (ct==Thread.currentThread()) {
		
			calcula ();

			lblReloj.setText((hora+ ":" + minutos+ ":" +segundos+ " " +ampm + "PROGRAMACION II - UCR"));
			revalidate();
			try {
				
				Thread.sleep(1000);
				
			}catch (InterruptedException e) {}
		}
	}
	
	public void calcula() {
	    Calendar calendario = new GregorianCalendar();
	    Date fechaHoraActual = new Date();
	    
	    calendario.setTime(fechaHoraActual);
	    ampm = calendario.get(Calendar.AM_PM) ==Calendar.AM? "AM" : "PM";
		if (ampm.equals("PM")) {   //Verifica si la hora es AM o PM... si es PM, resta 12 horas
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora = h>9?  " "+ h:  "0" + h;
			
		} else {
			                                                                                               /*Si la horaes mayor a 9 no se agrega nada , pero sino, nos agrega un 0 antes de la hora.*/
			hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY): "0" +calendario.get(Calendar.HOUR_OF_DAY);
		}
		  /*Lo mismo aplica para minutos.*/
		minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE) : "0"+ calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND)>9? "" +calendario.get(Calendar.SECOND): "0"+calendario.get(Calendar.SECOND);
	}
}
