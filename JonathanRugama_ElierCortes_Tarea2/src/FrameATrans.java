import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameATrans extends FrameTransaccion {





	public FrameATrans() {
		
		super("ACTUALIZAR TRANSACCION", "Actualizar",true);
		
		JButton  btnBuscar = new JButton("Buscar");
		 btnBuscar.setBounds(260, 18, 80, 23);
			setLocationRelativeTo(null);
	
		super.panel.add(btnBuscar);
		
		super.btnEjecutar.setIcon(new ImageIcon(FrameTransaccion.class.getResource("/Imagenes/actualizar.png")));

	}

}
