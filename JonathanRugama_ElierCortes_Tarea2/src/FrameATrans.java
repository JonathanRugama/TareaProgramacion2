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
		

			setLocationRelativeTo(null);
		
		super.btnEjecutar.setIcon(new ImageIcon(FrameTransaccion.class.getResource("/Imagenes/actualizar.png")));

	}

}
