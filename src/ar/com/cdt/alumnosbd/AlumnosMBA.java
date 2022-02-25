package ar.com.cdt.alumnosbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnosMBA {
	
	public void inscripcion(Alumno alumno) {
		Connection connection = Conexion.getConnection();
		String query = "INSERT INTO alumnos (id,nombre,apellido,dni,edad,rangoEdad,activo) VALUES (11,?,?,?,?,?,?);";
		if(!existe(alumno.getDni())) {
			System.out.println(alumno.toString());
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, alumno.getNombre());
				ps.setString(2, alumno.getApellido());
				ps.setLong(3, alumno.getDni());
				ps.setInt(4, alumno.getEdad());
				
				if(alumno.getEdad() >= 20 && alumno.getEdad() <= 30) {
					ps.setString(5, "a");
				}else if (alumno.getEdad() >= 31 && alumno.getEdad() <= 45) {
					ps.setString(5, "b");
				}else {
					ps.setString(5, "c");
				}
				
				ps.setInt(6, 1);
				ps.execute();
				ps.close();
				
				}catch (SQLException e) {
					System.out.println(e);
				}
			}else {
				System.out.println("Activo");
			}
	}
	
	public int calcularCantBebidas() {
		Connection connection = Conexion.getConnection();
		int bebidas = 0;
		String query = "SELECT count (rangoEdad) FROM alumnos where activos = 1 + rangoEdad ";
		
		return bebidas;
	}
	
	public boolean estaActivo(long dni) {
		Connection connection = Conexion.getConnection();
		boolean activo = false;
		try {
			Statement st;
			st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery("SELECT count(DNI) FROM alumnos where dni = " + dni +" and activo = 1");
			
			while(resultSet.next()) {
				if(resultSet.getInt(1) > 0) {
					activo = true;
				}
			}
			st.close();
			connection.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		return activo;
	}

	public List<Alumno> listaDeAlumnos(){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Connection connection = Conexion.getConnection();
		Statement st;
		try {
			st =connection.createStatement();
			
			ResultSet resultSet;
			resultSet = st.executeQuery("SELECT nombre, apellido, dni, edad FROM alumnos where activo =1");
			while(resultSet.next() ) {
				
				Alumno alumno = new Alumno();
				alumno.setNombre(resultSet.getString("nombre"));
				alumno.setApellido(resultSet.getString("apellido"));
				alumno.setDni(resultSet.getLong("dni"));
				alumno.setEdad(resultSet.getInt("edad"));
				alumnos.add(alumno);//NO OLVIDAR
			}
			System.out.println("alumnos = " + alumnos);
			
			resultSet.close();
			st.close();
			connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error de carga");
		}
		return alumnos;
		
	}
	
	public void modificacion(Alumno alumno) {
		Connection connection = Conexion.getConnection();
		String query = ("update alumnos set nombre = ?, apellido = ?, dni = ?, edad = ?, rangoEdad = ?, activo = ? where dni = ?");
		if(existe(alumno.getDni())) {
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, alumno.getNombre());
				ps.setString(2, alumno.getApellido());
				ps.setLong(3, alumno.getDni());
				ps.setInt(4, alumno.getEdad());
				ps.setString(5, alumno.getRangoEdad());//preguntar a hernan
				if(alumno.getEdad()>=20 && alumno.getEdad() <= 30){
					ps.setString(5, "a");
				}else if(alumno.getEdad() > 30 && alumno.getEdad() < 45){
					ps.setString(5, "b");
				}else {
					ps.setString(5, "c");
				}
				ps.setInt(6, alumno.getActivo());
				ps.setLong(7, alumno.getDni());
			}catch (SQLException e) {
				System.out.println(e);
			}
			}else {
			System.out.println();
			}
			
	}
	
	public boolean existe(long dni) {
		Connection connection = Conexion.getConnection();
		boolean activo = false;
		try {
			Statement st;
			st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery("SELECT count(DNI) FROM alumnos where dni = " + dni );
			
			while(resultSet.next()) {
				if(resultSet.getInt(1) > 0) {
					activo = true;
				}
			}
			st.close();
			connection.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(activo);
		return activo;
	}
}


