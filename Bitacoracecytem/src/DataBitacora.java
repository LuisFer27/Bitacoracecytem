/**
 * Nombre del proyecto:Bitacoracecytem
 * Descripción:Aplicación para llevar un control de registro de alumnos que estan en un área especifica 
 * Fecha:04/07/2024
 * Autor:Luis Fernando Mendez Barrera
 * Versión 1.0.0
 */
// importaciones
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**Clase DataBitacora:clase donde se almacenan los controlaodres que se emplearan en la aplicación.**/
public class DataBitacora {
    //controlador para la conexión a mysql
	private static String controlador ="com.mysql.cj.jdbc.Driver";
	//nombre del enlace a conectarse y base 
	private static String url ="jdbc:mysql://localhost:3306/bitcecytem";
	//usuario
	private static String user="root";
	//contraseña
	private static String pass="";
	//inicia la clase de los valores que son get y set
	BitacoraCecytem var= new BitacoraCecytem();
	//resultado
	boolean resultado=false;
	static {
		try {
			Class.forName(controlador);
		}catch(ClassNotFoundException e) {
			System.out.print("Error en encontrar el controlador");
			e.printStackTrace();
		}
	}

/****función que permite la conexión a la base de datos ****/
public Connection conectar() {
	Connection conexion=null;
	try {
		conexion=DriverManager.getConnection(url,user,pass);
		System.out.print("Conectado a la base de datos");
	}catch(SQLException e) {
		System.out.print("No conectado");
		e.printStackTrace();
	}
	return conexion;
}

/****Función para registrar alumno ******/
public boolean registrarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null,ps2=null;
	ResultSet rs=null;
	
	try {
		// variable que almacena la conexion a la  base de datos
		cn=conexion.conectar();
		//consulta para realizar la inserción de datos no se emplea el id ya que es autoincremental
		String query="INSERT INTO contactos(noControl, nombrePlantel, horaEntrada, horaSalida, fecha) VALUES(?,?,?,?,?)";
		ps=cn.prepareStatement(query);
		//valores que se van a insertar al escribir en la interfaz gráfica
		ps.setString(1, BitacoraCecytem.noControl);
		ps.setString(2, BitacoraCecytem.nombrePlantel);
		ps.setString(3, BitacoraCecytem.horaEntrada);
		ps.setString(4, BitacoraCecytem.horaSalida);
		ps.setString(5, BitacoraCecytem.fecha);
	    //identificador que se obtiene a partir del número de control
		String id=BitacoraCecytem.noControl;
		// consulta que se empleara para evitar la duplicación a partir del número de control
		String query2="SELECT * FROM contactos WHERE noControl=?";
		//conexión a la consulta para evitar la duplicación
		ps2=cn.prepareStatement(query2);
		ps2.setString(1,id);
		rs=ps2.executeQuery();
		if(rs.next() !=true) {
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Registro Guardado");
            resultado=true;
		}else {
			JOptionPane.showMessageDialog(null,"Registro no realizado");
		}
		
	}
    // si no existe la base de datos o no hay conexión al servidor MySql devuelve un mensaje de error de conexión
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Ocurrio un problema intentelo más tarde");
	}
	return resultado;
}

/****Función para consultar alumno ******/
public boolean consultarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	try {
		// variable que almacena la conexion a la  base de datos
		cn=conexion.conectar();
		//muestra un dialogo para realizar la busqueda mediante el número de control
		String id=JOptionPane.showInputDialog("Número de control a Buscar");
		//consulta para realizar la consulta mediante un número de control
		String query="SELECT * FROM contactos WHERE noControl=?";
		//devuelve la conexión de la consulta 
		ps=cn.prepareStatement(query);
		ps.setString(1, id);
		rs=ps.executeQuery();
		   //valores que se van a mostrar en la interfaz gráfica
		if(rs.next()==true) {
		 BitacoraCecytem.id=rs.getString(1);
		 BitacoraCecytem.noControl=rs.getString(2);
		 BitacoraCecytem.nombrePlantel=rs.getString(3);
		 BitacoraCecytem.horaEntrada=rs.getString(4);
		 BitacoraCecytem.horaSalida=rs.getString(5);
		 BitacoraCecytem.fecha=rs.getString(6);
		 //devuelve el resultado
		 resultado=true;
		}
		//si el id no existe o no se ha ingresado un número de control devolvera un mensaje que no encuentra el id que es el numero de control
		else {
			JOptionPane.showMessageDialog(null,"No se encontro el número de control");
		}
		
	}
    // si no existe la base de datos o no hay conexión al servidor MySql devuelve un mensaje de error de conexión
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Ocurrio un problema intentelo más tarde");
	}
	//devuelve la conexión 
	return resultado;
	
}
/****función para actualizar alumno****/
public boolean actualizarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null,ps2=null;
	ResultSet rs=null;
	
  try {
	// variable que almacena la conexion a la  base de datos
   cn=conexion.conectar();
   //valores que se van a modificar al escribir en la interfaz gráfica
   final String id = BitacoraCecytem.id;
   final String noc = BitacoraCecytem.noControl;
   final String nom = BitacoraCecytem.nombrePlantel;
   final String he = BitacoraCecytem.horaEntrada;
   final String hs = BitacoraCecytem.horaSalida;
   final String fe = BitacoraCecytem.fecha;
   //consulta para actualizar 
   final String query = "UPDATE contactos SET idContacto = '"+id+"', noControl = '"+noc+"', nombrePlantel = '"+nom+"', horaEntrada= '"+he+"', horaSalida= '"+hs+"', fecha= '"+fe+"' WHERE noControl = '"+noc+"'";
   //conexion de la consulta 1 actualizar
   ps = cn.prepareStatement(query);
   //consulta que impide la duplicación ya que valida si el dato existe que en este caso es el numero de control 
   final String query2= "SELECT * FROM contactos WHERE noControl= ?";
   //conexion a la consultta 2 para validar 
   ps2=cn.prepareStatement(query2);
   //configura la consulta 
   ps2.setString(1, noc);
   rs=ps2.executeQuery();
   if(rs.next()==true) {
      ps.executeUpdate();
		//mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Contacto modificado correctamente");
          resultado=true;
              }else {
            	  //si el contacto no se consulto o los datos estan incorrectos impide la modificación
                 JOptionPane.showMessageDialog(null, "Error al modificar el contacto");
                   }
                 }
  // si no existe la base de datos o no hay conexión al servidor MySql devuelve un mensaje de error de conexión
            catch(final SQLException e) {
                  e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema intentelo más tarde");
                 }
  //devuelve la conexión
              return resultado;
             }


/***Función para eliminar el alumno****/
public boolean eliminarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn= null;
	PreparedStatement ps=null;

	try{
		cn=conexion.conectar();
		//Mensaje que permite escribir el id guardado para su eliminación en caso de que se escriban mal los datos 
		String id=JOptionPane.showInputDialog("NÚMERO DE CONTROL A ELIMINAR");
		//consulta en MySql para eliminar los datos mediante el número de control se puede cambiar a id 
		String query= "DELETE FROM contactos WHERE noControl=?";
		ps=cn.prepareStatement(query);
		ps.setString(1,id);
		int cant=ps.executeUpdate();
		// si existe un contacto permite la eliminación
		if (cant==1) {
		JOptionPane.showMessageDialog(null, "Contacto borrado");
		//devolver el estado
		resultado=true;
		}
		//si el contacto no existe o no se escribe devuelve el mensaje que no existe 
		else {
		JOptionPane.showMessageDialog(null, "No existe el registro");
		}
	
		}
	    // si no existe la base de datos o no hay conexión al servidor MySql devuelve un mensaje de error de conexión
	    catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Ocurrio un problema intentelo más tarde");
		}
// devuelve los resultados 
return resultado;

}
}









