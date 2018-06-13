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



public class Interfaz extends JFrame implements Runnable {

	/**
	 * 
	 */
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
		h1 = new Thread(this);
		h1.start();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/Imagenes/usuario.png")));
		setTitle("Clientes");
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 950, 608);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane.setLayout(null);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnACercaDe = new JMenu("Acerca de");
		menuBar.add(mnACercaDe);
		
		JMenuItem mntmPrograma = new JMenuItem("Programa");
		mnACercaDe.add(mntmPrograma);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Cortés Baltodano Elier B72410 \nRugama Obando Jonathan B56367", "INFORMACIÓN DE LOS AUTORES", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnACercaDe.add(mntmAutores);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"¿DESEA FINALIZAR?", "FINALIZAR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION  ) {
					JOptionPane.showMessageDialog(null,"PROGRAMA FINALIZADO");	
					System.exit(0);
			}
			}
		});
		btnSalir.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/salida.png")));
		btnSalir.setToolTipText("Salir del Sistema de forma definitiva");
		btnSalir.setBounds(502, 506, 110, 32);
		contentPane.add(btnSalir);
		
		JPanel panelTransaccion = new JPanel();
		panelTransaccion.setLayout(null);
		panelTransaccion.setOpaque(false);
		panelTransaccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTransaccion.setBounds(344, 170, 268, 157);
		contentPane.add(panelTransaccion);
		
		JButton btnEliminarTrans = new JButton("Eliminar");
		btnEliminarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		btnEliminarTrans.setToolTipText("Eliminar los datos del cliente");
		btnEliminarTrans.setBounds(127, 108, 111, 25);
		panelTransaccion.add(btnEliminarTrans);
		
		JButton btnActualizarTrans = new JButton("Actualizar");
		btnActualizarTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frameTA = new FrameATrans();
					
					frameTA.setVisible(true);
			}
		});
		btnActualizarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		btnActualizarTrans.setToolTipText("Genera una acci\u00F3n para poder actualizar los datos del cliente");
		btnActualizarTrans.setBounds(127, 73, 111, 23);
		panelTransaccion.add(btnActualizarTrans);
		
		JLabel lblTransaccion = new JLabel("Transacci\u00F3n:");
		lblTransaccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransaccion.setBounds(10, 37, 111, 14);
		panelTransaccion.add(lblTransaccion);
		
		txtActualizarTrans = new JTextField();
		txtActualizarTrans.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtActualizarTrans.setColumns(10);
		txtActualizarTrans.setBounds(10, 74, 86, 20);
		panelTransaccion.add(txtActualizarTrans);
		
		txtEliminar = new JTextField();
		txtEliminar.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtEliminar.setColumns(10);
		txtEliminar.setBounds(10, 110, 86, 20);
		panelTransaccion.add(txtEliminar);
		
		JButton btnIngresarTrans = new JButton("Ingresar");
		btnIngresarTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frameIngresarT = new FrameTransaccion("INGRESAR TRANSACCION", "Ingresar", false);
				 frameIngresarT.setVisible(true);
			}
		});
		btnIngresarTrans.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/ingresar.png")));
		btnIngresarTrans.setToolTipText("Ingresa los datos a la base de datos");
		btnIngresarTrans.setBounds(128, 35, 110, 23);
		panelTransaccion.add(btnIngresarTrans);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setOpaque(false);
		panelCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCliente.setBounds(344, 30, 268, 122);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setBounds(127, 72, 109, 25);
		panelCliente.add(btnEliminarCliente);
		btnEliminarCliente.setToolTipText("Eliminar los datos del cliente");
		btnEliminarCliente.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		
		JButton btnActualizarCliente = new JButton("Actualizar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarCliente.setBounds(127, 37, 109, 23);
		panelCliente.add(btnActualizarCliente);
		btnActualizarCliente.setToolTipText("Genera una acci\u00F3n para poder actualizar los datos del cliente");
		btnActualizarCliente.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(10, 11, 89, 14);
		panelCliente.add(lblCliente);
		
		txtActualizarCliente = new JTextField();
		txtActualizarCliente.setBounds(10, 38, 86, 20);
		panelCliente.add(txtActualizarCliente);
		txtActualizarCliente.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del clienta a actualizar");
		txtActualizarCliente.setColumns(10);
		
		txtEliminarCliente = new JTextField();
		txtEliminarCliente.setBounds(10, 74, 86, 20);
		panelCliente.add(txtEliminarCliente);
		txtEliminarCliente.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtEliminarCliente.setColumns(10);
		
		JPanel ingresarCliente = new JPanel();
		ingresarCliente.setBackground(new Color(153, 153, 153));
		ingresarCliente.setOpaque(false);
		ingresarCliente.setForeground(new Color(30, 144, 255));
		ingresarCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ingresarCliente.setBounds(10, 30, 319, 465);
		contentPane.add(ingresarCliente);
		ingresarCliente.setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(22, 408, 93, 25);
		ingresarCliente.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/login.png")));
		btnIngresar.setToolTipText("Ingresa los datos a la base de datos");
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setBounds(23, 346, 125, 14);
		ingresarCliente.add(lblFechaNacimiento);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy\n HH:mm:ss ");
		
		JPanel panelTarjeta = new JPanel();
		panelTarjeta.setLayout(null);
		panelTarjeta.setOpaque(false);
		panelTarjeta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTarjeta.setBounds(344, 338, 268, 157);
		contentPane.add(panelTarjeta);
		
		JButton btnEliminarTarj = new JButton("Eliminar");
		btnEliminarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		btnEliminarTarj.setToolTipText("Eliminar los datos del cliente");
		btnEliminarTarj.setBounds(127, 102, 111, 25);
		panelTarjeta.add(btnEliminarTarj);
		
		JButton btnActualizarTarj = new JButton("Actualizar");
		btnActualizarTarj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frameTarjA= new FrameATarj();
					frameTarjA.setVisible(true);
			}
		});
		btnActualizarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		btnActualizarTarj.setToolTipText("Genera una acci\u00F3n para poder actualizar los datos del cliente");
		btnActualizarTarj.setBounds(127, 67, 111, 23);
		panelTarjeta.add(btnActualizarTarj);
		
		JLabel lblTarjeta = new JLabel("Tarjeta:");
		lblTarjeta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarjeta.setBounds(10, 31, 111, 14);
		panelTarjeta.add(lblTarjeta);
		
		txtActualizar = new JTextField();
		txtActualizar.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtActualizar.setColumns(10);
		txtActualizar.setBounds(10, 68, 86, 20);
		panelTarjeta.add(txtActualizar);
		
		txtEliminarTarj = new JTextField();
		txtEliminarTarj.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtEliminarTarj.setColumns(10);
		txtEliminarTarj.setBounds(10, 104, 86, 20);
		panelTarjeta.add(txtEliminarTarj);
		
		JButton btnIngresarTarj = new JButton("Ingresar");
		btnIngresarTarj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameIngresarTarj = new FrameTarjeta ("INGRESAR TARJETA", "Ingresar");
				frameIngresarTarj.setVisible(true);
			}
		});
		btnIngresarTarj.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/ingresar.png")));
		btnIngresarTarj.setToolTipText("Ingresa los datos a la base de datos");
		btnIngresarTarj.setBounds(128, 29, 110, 23);
		panelTarjeta.add(btnIngresarTarj);
		
		JPanel barraEstado = new JPanel();
		barraEstado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		barraEstado.setBounds(6, 508, 486, 30);
		barraEstado.setOpaque(false);
		contentPane.add(barraEstado);
		

	
		
	
		barraEstado.add(lblReloj);
		
		
		JLabel lblImagenFondo = new JLabel("New label");
		lblImagenFondo.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/FondoFrame.jpg")));
		lblImagenFondo.setBounds(0, 0, 944, 561);
		contentPane.add(lblImagenFondo);
		
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	
	}




	@Override
	public void run() {
	
Thread ct = Thread.currentThread();

		while (ct==Thread.currentThread()) {
		
			calcula ();

			lblReloj.setText((hora+ ":" + minutos+ ":" +segundos+ " " +ampm));
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
