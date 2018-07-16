import java.io.*;

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
	            String query = "SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave='"+clave+"';";
	            System.err.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            
	            if ( usuario.equals( "" ) ||clave.equals( "" ) ) {
	  	          pw.println( "<H3> Favor ingrese los datos que se le solicitan " +
	  	                          "<br>Algunos campos estan  " +
	  	                          " vacios.</H3>" +"\n<a href=http://localhost:8080/proyectoServlets/index.html>Regresar</a>");
	  	          pw.close();
	  	          return;
	  	       } 
	             pw.println( "<html>  \n" +
        		"<head>  \n" +
        		"<TITLE>Tabla Usuarios.</TITLE>  \n" +
        		"</head>  \n" +
        		"\n" +
        		"<body>  \n" +
        		"<div align='center'>  \n" +
                 "<H2> Tabla de Usuarios:<H2 \n"+
        		 
                 "<br> \n" +
                 getTable()+
        		"</div>  \n" +
        		"</body>  \n" +
        		"\n" +
        		"</html> ");
	           
	          
	            		          
	            
	           
	         } catch (Exception e) {
	             e.printStackTrace();
	             System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
	         }

		pw.close();
		return;
	}
	
	 /**
	 * Método usado para cargar los datos de la tabla
	 * de la base de datos a la página html
	 */
	private String getTable()
	   {
	      Statement statement;
	      ResultSet rs;
	      int cont = 0;
	      String str = "";
	      try {
	    	
	         String query = "SELECT clave, usuario from usuarios;";
	         System.out.println("SELECT clave, usuario from usuarios");
	         statement = conexion.createStatement();
	         rs = statement.executeQuery(query );
	          str = "<br> <table align= 'center' border=1><tr><th>Clave</th><th>Usuarios</th></tr>";
	         
	         while (rs.next()) {
	    		  cont++;
	    			str += "<tr><td>" +rs.getString(1)+"</td><td>" +rs.getString(2);
	    	  }
	         
	         System.out.println("Número de datos ingresados: " + cont);
	        
	     
	         str+="</table>" 
	         + "\n <br> <a  href=http://localhost:8080/proyectoServlets/index.html>Regresar</a> \n";
	        
	         
	      }
	      catch ( SQLException sqlex ) {
	         sqlex.printStackTrace();
	      }
		return str;
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
 