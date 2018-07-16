import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * @author Elier CoBa
 * Clase para capturar los datos y hacer la comprobacion de 
 * que el usaurio existe
 *
 */
public class capturarDatos extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private String nombre_bd="";
    private static Connection conexion  = null;
    private String usuarioBD;
    private String passwordBD;
    private String controlador="";
    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest pregunta, javax.servlet.http.HttpServletResponse responde)
	 * Método para mostrar el contenido de la tabla usuario en caso de que el usuario y contraseña existan
	 */
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
	            String query = "select * from usuarios where usuario='"+usuario+"' and clave='"+clave+"';";
	            System.err.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            
	            if ( usuario.equals( "" ) ||clave.equals( "" ) ) {
	  	          pw.println( "<H3> Favor ingrese los datos que se le solicitan " +
	  	                          "<br>Algunos campos estan  " +
	  	                          " vacios.</H3>" +"\n<a href=http://localhost:8080/proyectoServlets/index.html>Regresar</a>");
	  	          pw.close();
	  	          return;
	  	       } 
	            
	            pw.println("<HTML><HEAD><TITLE>Tabla de usuarios</TITLE></HEAD>");
	            pw.println("<BODY>");
	            pw.println("<H2>Tabla usuario</H2>");
        		pw.println(" <table border=1 cellspacing=0 cellpadding=2 bordercolor='black'>");
        		pw.println(" <tr>");
        		pw.println("<td>usuario</td>");
        		pw.println("<td>contrasena</td>");
        		pw.println("</tr>");
        		pw.println("<tr>");
        		
	            while (rs.next())
	            {
	            	pw.println("<td>");
	        		pw.println(rs.getString("Usuario"));
	            	pw.println("</td>");
	            	pw.println("<td>");
	        		pw.println(rs.getString("Clave"));
	            	pw.println("</td>");

	            }
	            pw.println("</tr>");
        		pw.println("</table>");
        		pw.println("<br><a href=http://localhost:8080/proyectoServlets/> Regresar </a>");
        		pw.println("</BODY></HTML>");
	         } catch (Exception e) {
	             e.printStackTrace();
	             System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
	         }

		pw.close();
	}
	
    /**
     * @return conexion
     * Método que hace la conexion con la 
     * base de datos
     */
    public static Connection getConexion() {
        return conexion;
    }
} 