package ar.com.cdt.alumnosbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

	public static Connection getConnection() {
		 Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/inscripcion",
                    "root", "DeveL1143700p5!");
 
//            Statement statement;
//            statement = connection.createStatement();
//            ResultSet resultSet;
//            resultSet = statement.executeQuery("SELECT * FROM alumnos;");
//            
//            List<Alumno> alumnos = new ArrayList<Alumno>();
//            
//            while (resultSet.next()) {
//            	
//            	Alumno alumno = new Alumno();
//                alumno.setId(resultSet.getInt("id"));
//                alumno.setNombre(resultSet.getString("nombre"));
//                alumno.setApellido(resultSet.getString("apellido"));
//                alumno.setDni(resultSet.getLong("dni"));
//                alumno.setEdad(resultSet.getInt("edad"));
//                alumno.setActivo(resultSet.getInt("activo")); 
//                alumno.setRangoEdad(resultSet.getString("rangoEdad"));
//               
//                alumnos.add(alumno);
//                
//            }
//            
//            System.out.println("Alumnos: " + alumnos);
//            resultSet.close();
//            statement.close();
        //    connection.close();
        }
        
        catch (Exception exception) {
            System.out.println(exception);
        }
		return connection;
    } 

}
