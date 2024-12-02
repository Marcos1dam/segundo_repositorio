package clase;

import java.util.Random;

import utilidades.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Empleade implements Comparable<Empleade>{
	
	Random aleatorio= new Random();
	
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private LocalDate fechaAlta;
	private int numAleatorio;
	
	public Empleade() {
		this.numAleatorio= aleatorio.nextInt(100-1)+1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getNumAleatorio() {
		return numAleatorio;
	}

	public void setNumAleatorio(int numAleatorio) {
		this.numAleatorio = numAleatorio;
	}
	public void setDatos() {
		String resp="si";
		
		
		
		nombre= Utilidades.introduceCadena("Introduce nombre del empleade");
		
		apellido= Utilidades.introduceCadena("Introduce apellido del empleade");
		
		dni= Utilidades.introduceCadena("Introduce DNI del empleade");
		
		fechaNacimiento= Utilidades.introducirFecha("Introduce la fecha de nacimiento dd/mm/yyyy");
		
		resp= Utilidades.introduceCadena("¿Quieres introducir la fecha de alta?");
		if(resp.equalsIgnoreCase("si")) {
		
			fechaAlta= Utilidades.introducirFecha("Introduce la fecha de alta del empleade");
		}else {
			fechaAlta= LocalDate.now();
		}
	}
	public void getDatos(){
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("DNI: "+dni);
		System.out.println("Fecha de nacimiento: "+fechaNacimiento);
		System.out.println("Fecha de alta: "+fechaAlta);
	}
	

	@Override
	public int compareTo(Empleade otroEmpleade) {
		
		return apellido.compareTo(otroEmpleade.getApellido());
	}
	
	public int calcularEdadDadoDeAlta() {
		int anioNacimiento= fechaNacimiento.getYear();
		int anioAlta= fechaAlta.getYear();
		return anioAlta - anioNacimiento;
		
	}
	
}
