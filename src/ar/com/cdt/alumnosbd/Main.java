package ar.com.cdt.alumnosbd;

public class Main {

	public static void main(String[] args) {
		AlumnosMBA a = new AlumnosMBA();
		
		Alumno al = new Alumno();
		al.setNombre("Oriana");
		al.setApellido("Apellido");
		al.setDni(95777365);
		al.setEdad(26);
		a.inscripcion(al);
		
		System.out.println(a.listaDeAlumnos());
		System.out.println(al);
		}

}
