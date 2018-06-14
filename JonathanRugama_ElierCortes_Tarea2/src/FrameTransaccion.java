import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrameTransaccion extends JFrame {

	protected JPanel contentPane;
	private JTextField txtNumeroTransaccion;
	private JTextField txtNumeroTarjeta;
	private JTextField txtMonto;
protected	JButton btnBuscar;
protected JButton btnEjecutar;
	JPanel panelTransaccion;
	private JTextField txtFecha;
	private Date fecha = new Date ();
	private DateFormat hourDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FrameTransaccion(String tituloFrame, String tituloBoton, Boolean editable) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameTransaccion.class.getResource("/Imagenes/transaccion.png")));
		setTitle(tituloFrame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
	 
	 JButton btnRegresar = new JButton("Regresar");
	 btnRegresar.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent arg0) {
	 		dispose();
	 	}
	 });
	 btnRegresar.setIcon(new ImageIcon(FrameTransaccion.class.getResource("/Imagenes/back.png")));
	 btnRegresar.setBounds(326, 329, 107, 23);
	 contentPane.add(btnRegresar);
	
		
		 
	 panelTransaccion= new JPanel();
	 panelTransaccion.setOpaque(false);
	 panelTransaccion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	 panelTransaccion.setBounds(10, 24, 306, 352);
	 contentPane.add(panelTransaccion);
	 panelTransaccion.setLayout(null);
	 
	 txtFecha = new JTextField();
	 txtFecha.setBounds(158, 257, 86, 20);
	 panelTransaccion.add(txtFecha);
	 txtFecha.setColumns(10);
	 txtFecha.setText(hourDateFormat.format(fecha));
	 
	 JRadioButton rdbtnDeposito = new JRadioButton("Deposito");
	 rdbtnDeposito.setBounds(86, 164, 93, 23);
	 panelTransaccion.add(rdbtnDeposito);
	 rdbtnDeposito.setOpaque(false);
	 
	 JRadioButton rdbtnRetiro = new JRadioButton("Retiro");
	 rdbtnRetiro.setBounds(177, 164, 109, 23);
	 panelTransaccion.add(rdbtnRetiro);
	 rdbtnRetiro.setOpaque(false);
	 
	 ButtonGroup tipo = new ButtonGroup();
	 tipo.add(rdbtnRetiro);
	 tipo.add(rdbtnDeposito);
	 
	 JRadioButton rdbtnDlares = new JRadioButton("D\u00F3lares");
	 rdbtnDlares.setBounds(177, 205, 109, 23);
	 panelTransaccion.add(rdbtnDlares);
	 rdbtnDlares.setOpaque(false);
	 
	 JRadioButton rdbtnColones = new JRadioButton("Colones");
	 rdbtnColones.setBounds(86, 205, 93, 23);
	 panelTransaccion.add(rdbtnColones);
	 rdbtnColones.setOpaque(false);
	 
	 ButtonGroup monedas= new ButtonGroup();
	 monedas.add(rdbtnDlares);
	 monedas.add(rdbtnColones);
	 
	 txtMonto = new JTextField();
	 txtMonto.setBounds(158, 118, 86, 20);
	 panelTransaccion.add(txtMonto);
	 txtMonto.setColumns(10);
	 
	 JLabel lblMonto = new JLabel("Monto:");
	 lblMonto.setBounds(24, 121, 57, 14);
	 panelTransaccion.add(lblMonto);
	 
	 txtNumeroTarjeta = new JTextField();
	 txtNumeroTarjeta.setBounds(158, 65, 86, 20);
	 panelTransaccion.add(txtNumeroTarjeta);
	 txtNumeroTarjeta.setColumns(10);
	 
	 JLabel lblNmeroDeTarjeta = new JLabel("N\u00FAmero de Tarjeta:");
	 lblNmeroDeTarjeta.setBounds(24, 68, 110, 14);
	 panelTransaccion.add(lblNmeroDeTarjeta);
	 
	 JLabel lblNewLabel = new JLabel("N\u00B0 de Transacci\u00F3n:");
	 lblNewLabel.setBounds(24, 23, 134, 14);
	 panelTransaccion.add(lblNewLabel);
	 
	 txtNumeroTransaccion = new JTextField();
	 txtNumeroTransaccion.setBounds(158, 20, 86, 20);
	 panelTransaccion.add(txtNumeroTransaccion);
	 txtNumeroTransaccion.setEditable(editable);
	 txtNumeroTransaccion.setColumns(10);
	 
	  btnEjecutar = new JButton(tituloBoton);
	  btnEjecutar.setBounds(24, 305, 120, 23);
	  panelTransaccion.add(btnEjecutar);
	  btnEjecutar.setIcon(new ImageIcon(FrameTransaccion.class.getResource("/Imagenes/ingresar.png")));
	  
	  JLabel lblTipo = new JLabel("Tipo:");
	  lblTipo.setBounds(24, 168, 46, 14);
	  panelTransaccion.add(lblTipo);
	  
	  JLabel lblMoneda = new JLabel("Moneda:");
	  lblMoneda.setBounds(24, 209, 62, 14);
	  panelTransaccion.add(lblMoneda);
	  
	  JLabel lblFecha = new JLabel("Fecha: ");
	  lblFecha.setBounds(24, 260, 46, 14);
	  panelTransaccion.add(lblFecha);
	 
	btnBuscar = new JButton("Buscar");
	 btnBuscar.setBounds(260, 21, 65, 23);

	 
	
		
		 JLabel label = new JLabel("");
		 label.setIcon(new ImageIcon(FrameTransaccion.class.getResource("/Imagenes/FondoFrame.jpg")));
		 label.setBounds(0, 0, 443, 387);
		 contentPane.add(label);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
	}
}
