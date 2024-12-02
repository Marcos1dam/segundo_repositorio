package utilidades;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {
	
	public static String introduceCadena(String mensaje) {
		Scanner teclado = new Scanner(System.in);
		String cadena = null;
		
		
		System.out.println(mensaje);
		try {
			cadena= teclado.next();
		} catch (NoSuchElementException e) {
			System.out.println("Error al introducir la cadena ");
		}
		
		return cadena;
		
	}
	
	public static int introducirNumero(String mensaje) {
		int numero = 0;
		String cadena;
		boolean correcto= true;
		do {
			cadena= introduceCadena(mensaje);
			try {
				numero= Integer.parseInt(cadena);
			} catch (NumberFormatException e) {
				System.out.println("Esto no es un numero entero");
				correcto= false;
			}
		}while(!correcto);
		
		
		return numero;
		
	}
	
	public static float introducirSueldo(String mensaje) {
		float sueldo = 0;
		String cadena;
		boolean correcto= true;
		do {
		cadena= introduceCadena(mensaje);
		try {
			sueldo= Float.parseFloat(cadena);
		} catch (InputMismatchException e) {
			System.out.println("Error el numero introducido no cumple el formato");
			correcto= false;
		}
		}while(!correcto);
		
		return sueldo;
		
	}
	public static LocalDate introducirFecha(String mensaje) {
		boolean correcto= true;
		String cadena;
		LocalDate fecha = null;
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/mm/yyyy");
		
		do {
			cadena= introduceCadena(mensaje);
			try {
				fecha= LocalDate.parse(cadena, formato);
			} catch (DateTimeException e) {
				System.out.println("Esto no es una fecha correcta");
				correcto= false;
			}
		}while(!correcto);
		
		return fecha;
	}

}
