import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class capturarDatos extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private String nombre_bd="";
    private static Connection conexion  = null;
    private String usuarioBD;
    private String passwordBD;
    private String controlador;
    
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    
		controlador="net.ucanaccess.jdbc.UcanaccessDriver";
	    nombre_bd="C:\\progra2\\progra2.accdb";
	    usuarioBD="";
	    passwordBD="";
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
        String usuario = req.getParameter("Usuario");
        String clave = req.getParameter("Clave");

	        try {	        	
	            Class.forName(controlador);
	            conexion=DriverManager.getConnection("jdbc:ucanaccess://"+ nombre_bd, usuarioBD, passwordBD);
	            Statement stmt = conexion.createStatement();
	            String query = "select * from Usuario where usuario='"+usuario+"' and clave='"+clave+"'";
	            System.err.println(query);
	            ResultSet rs = stmt.executeQuery(query);
        		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
        		//pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
        		pw.println("<H2>Leyendo los datos de la tabla USUARIOS<H2><P>");
        		pw.println("<UL>\n");
	            while (rs.next())
	            {
	        		pw.println(rs.getString("Usuario"));
	        		pw.println(rs.getString("Clave"));
	            }          	
        		pw.println("</BODY></HTML>");
	         } catch (Exception e) {
	             e.printStackTrace();
	             System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
	         }

		pw.close();
	}
	
    public static Connection getConexion() {
        return conexion;
    }
} 