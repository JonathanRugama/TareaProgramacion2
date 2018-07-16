import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * @author Elier CoBa
 * Clase para poder añadir un nuevo usuario a la tabla
 *
 */
public class Ingresar extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private String nombre_bd="";
    private static Connection conexion  = null;
    private String usuarioBD;
    private String passwordBD;
    private String controlador="";
    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * Método que añade un nuevo usuario y contraseña a la tabla
	 */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    
		controlador="net.ucanaccess.jdbc.UcanaccessDriver";
	    nombre_bd="C:\\progra2\\progra2.accdb";
	    usuarioBD="";
	    passwordBD="";
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
        String usuario = req.getParameter("usuario");
        String clave = req.getParameter("clave");
	        try {	        	
	            Class.forName(controlador);
	            conexion=DriverManager.getConnection("jdbc:ucanaccess://"+ nombre_bd, usuarioBD, passwordBD);
	
	            if ( usuario.equals( "" ) ||clave.equals( "" ) ) {
	          pw.println( "<H3> LLene los campos por favor " +
	                          "Algunos campos estan  " +
	                          " vacios.</H3>" +"\n<a href=http://localhost:8080/proyectoServlets/formulario.html>Regresar al formulario</a>");
	          pw.close();
	          return;
	       } 
	            
	            boolean success;//mada la consulta
	            success = insertIntoDB("INSERT INTO usuarios(" +
	                    "usuario, clave" +
	                    ") VALUES ('" +                              
	                     usuario + "','" + 
	                    clave +  "');") ;    
	           
	            if ( success ) 
	                pw.print( "<H2>Se ha registrado el usuario: " + usuario +
	                              "  </H2>"+"\n<a href=http://localhost:8080/proyectoServlets/formulario.html>Regresar al Formulario</a>" );
	             else
	                pw.print( "<H2>Ha ocurrido un error. " +
	                              "Por favor intente mas tarde.</H2>"+"\n<a href=http://localhost:8080/proyectoServlets/formulario.html>Regresar a Formulario</a>" );

	             pw.close();
	            
	            
	           
	         } catch (Exception e) {
	             e.printStackTrace();
	             System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
	         }

		pw.close();
	}

	private boolean insertIntoDB( String stringtoinsert ) //Hace la consukta
{
   try {
       Statement statement = conexion.createStatement();
       
      statement.executeUpdate( stringtoinsert) ;
      
      statement.close();
   }
   catch ( SQLException sqlex ) {
          //System.err.println("ERROR: Problemas al insertar el nuevo  usuario"+"\n<a href=registro.html>Volver a registro</a>" );
      sqlex.printStackTrace();
      return false;
   }

   return true;
}
	
    /**
     * Método que permite la conexion con la base de datos
     * @return conexion
     */
    public static Connection getConexion() {
        return conexion;
    }

	

}  