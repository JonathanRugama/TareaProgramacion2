import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameATarj extends FrameTarjeta{

	private JPanel contentPane;

	
	
	public FrameATarj() {
		super("ACTUALIZAR TARJETA", "Actualizar");
		lblImagen.setBounds(-13, -14, 503, 437);
		super.setBounds(100, 100, 496, 449);
	super.panel.setBounds(10, 11, 347, 398);
	super.btnRegresar.setBounds(367, 377, 113, 23);
	setLocationRelativeTo(null);
	super.lblImagen.setBounds(0, -14, 490, 437);
	super.btnIngresar.setIcon(new ImageIcon(FrameTarjeta.class.getResource("/Imagenes/actualizar.png")));

	
	}

}
