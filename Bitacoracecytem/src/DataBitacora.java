import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
/****/
public class DataBitacora {
 
	private static String controlador ="com.mysql.cj.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:3306/bitcecytem";
	private static String user="root";
	private static String pass="";
	
	BitacoraCecytem var= new BitacoraCecytem();
	boolean resultado=false;
	static {
		try {
			Class.forName(controlador);
		}catch(ClassNotFoundException e) {
			System.out.print("Error en encontrar el controlador");
			e.printStackTrace();
		}
	}

/****/
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

/****/
public boolean registrarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null,ps2=null;
	ResultSet rs=null;
	
	try {
		cn=conexion.conectar();
		
		String query="INSERT INTO contactos(noControl, nombrePlantel, horaEntrada, horaSalida, fecha) VALUES(?,?,?,?,?)";
		ps=cn.prepareStatement(query);
		//ps.setString(1,BitacoraCecytem.id);
		ps.setString(1, BitacoraCecytem.noControl);
		ps.setString(2, BitacoraCecytem.nombrePlantel);
		ps.setString(3, BitacoraCecytem.horaEntrada);
		ps.setString(4, BitacoraCecytem.horaSalida);
		ps.setString(5, BitacoraCecytem.fecha);
	
		String id=BitacoraCecytem.noControl;
		String query2="SELECT * FROM contactos WHERE noControl=?";
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
		
	}catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Ocurrio un problema intentelo más tarde");
	}
	return resultado;
}

/****/
public boolean consultarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	try {
		cn=conexion.conectar();
		String id=JOptionPane.showInputDialog("Id a Buscar");
		String query="SELECT * FROM contactos WHERE noControl=?";
		ps=cn.prepareStatement(query);
		ps.setString(1, id);
		rs=ps.executeQuery();
		
		if(rs.next()==true) {
		 BitacoraCecytem.id=rs.getString(1);
		 BitacoraCecytem.noControl=rs.getString(2);
		 BitacoraCecytem.nombrePlantel=rs.getString(3);
		 BitacoraCecytem.horaEntrada=rs.getString(4);
		 BitacoraCecytem.horaSalida=rs.getString(5);
		 BitacoraCecytem.fecha=rs.getString(6);
		 resultado=true;
		}
		else {
			JOptionPane.showMessageDialog(null,"No se encontro el id");
		}
		
	}
	catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Ocurrio un problema intentelo más tarde");
	}
	return resultado;
	
}
/****/
public boolean actualizarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn=null;
	PreparedStatement ps=null,ps2=null;
	ResultSet rs=null;
	
  try {
   cn=conexion.conectar();
   final String id = BitacoraCecytem.id;
   final String noc = BitacoraCecytem.noControl;
   final String nom = BitacoraCecytem.nombrePlantel;
   final String he = BitacoraCecytem.horaEntrada;
   final String hs = BitacoraCecytem.horaSalida;
   final String fe = BitacoraCecytem.fecha;
   final String query = "UPDATE contactos SET idContacto = '"+id+"', noControl = '"+noc+"', nombrePlantel = '"+nom+"', horaEntrada= '"+he+"', horaSalida= '"+hs+"', fecha= '"+fe+"' WHERE noControl = '"+noc+"'";
   ps = cn.prepareStatement(query);
   final String query2= "SELECT * FROM contactos WHERE noControl= ?";
   ps2=cn.prepareStatement(query2);
   ps2.setString(1, noc);
   rs=ps2.executeQuery();
   if(rs.next()==true) {
      ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Contacto modificado correctamente");
          resultado=true;
              }else {
                 JOptionPane.showMessageDialog(null, "Error al modificar el contacto");
                   }
                 }catch(final SQLException e) {
                  e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema intentelo más tarde");
                 }
              return resultado;
             }


/****/
public boolean eliminarAlumno() {
	DataBitacora conexion=new DataBitacora();
	Connection cn= null;
	PreparedStatement ps=null;

	try{
		cn=conexion.conectar();
		String id=JOptionPane.showInputDialog("ID A ELIMINAR");
		String query= "DELETE FROM contactos WHERE noControl=?";
		ps=cn.prepareStatement(query);
		ps.setString(1,id);
		int cant=ps.executeUpdate();
		
		if (cant==1) {
		JOptionPane.showMessageDialog(null, "Contacto borrado");
		//devolver el estado
		resultado=true;
		} else {
		JOptionPane.showMessageDialog(null, "No existe el registro");
		}
	
		}catch(SQLException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Ocurrio un problema intentelo más tarde ");
		}

return resultado;

}

//public List<BitacoraCecytem> obtenerAlumnos() {
   // List<BitacoraCecytem> alumnos = new ArrayList<>();
    //Connection cn = null;
    //PreparedStatement ps = null;
    //ResultSet rs = null;
    
    //try {
        //cn = conectar();
        //String query = "SELECT * FROM contactos";
       // ps = cn.prepareStatement(query);
       // rs = ps.executeQuery();

        //while (rs.next()) {
           // BitacoraCecytem alumno = new BitacoraCecytem();  
         //   alumno.id = rs.getString(1);
        //    alumno.noControl = rs.getString(2);
        //    alumno.nombrePlantel = rs.getString(3);
          //  alumno.horaEntrada = rs.getString(4);
      //      alumno.horaSalida = rs.getString(5);
         //   alumno.fecha = rs.getString(6);
           // alumnos.add(alumno);
       // }
    //} catch (SQLException e) {
      //  e.printStackTrace();
   //     JOptionPane.showMessageDialog(null, "Ocurrió un problema, inténtelo más tarde");
  //  } finally {
       // try {
          //  if (rs != null) rs.close();
         //   if (ps != null) ps.close();
        //    if (cn != null) cn.close();
       // } catch (SQLException e) {
         //   e.printStackTrace();
       // }
    //}
  //  return alumnos;
//}
	
}









