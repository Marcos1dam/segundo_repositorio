package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import clase.Empleade;

public class Programa {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		
		int opc=0;
		
		List<Empleade> empleades= new ArrayList<>();
		
		do {
			opc=menu(opc, teclado);
			if(empleades.isEmpty() && opc > 1 && opc < 11){
				System.out.println("ERROR: Tienes que ir a la opción 1");
			}else {
				switch (opc) {
				case 1:
					introducir_Empleades(empleades, teclado);
					break;
				case 2:
					listado_Empleades(empleades);
					break;
				case 3:
					listado_PorApellido(empleades, teclado);
					break;
				case 4:
					consultaModificacion_PorDni(empleades, teclado);
					break;
				case 5:
					borradoPorDni(empleades, teclado);
					break;
				case 6:
					listadoPorEdad(empleades);
					break;
				case 7:
					ListaPorFechaAlta(empleades);
					break;
				case 8:
					listadoPorAntiguedad(empleades);
					break;
				case 9:
					sorteoDiario(empleades);
					break;
				case 10:
					
					break;
				case 11:
					System.out.println("Hasta luego");
					break;
				}
			}
		}while(opc!=11);

	}

	private static void sorteoDiario(List<Empleade> empleades) {
		Random aleatorio= new Random();
		System.out.println("***********Sorteo Diario***********");
		int numsorteo= aleatorio.nextInt(100-1)+1;
		boolean hayGanador= false;
		
		do {
		for(int i=0; i < empleades.size();i++) {
			if(empleades.get(i).getNumAleatorio()== numsorteo ) {
				System.out.println("El empleade ganador es: "+empleades.get(i).getNombre());
				hayGanador= true;
			}
		}
		}while(!hayGanador);
		
		
	}

	private static void listadoPorAntiguedad(List<Empleade> empleades) {

		Empleade aux;
		
		for(int i=0; i < empleades.size();i++ ) {
			for(int j= i+1; j < empleades.size(); j++ ) {
				if(empleades.get(i).getFechaAlta().isAfter(empleades.get(j).getFechaAlta())) {
					aux= empleades.get(i);
					empleades.set(i, empleades.get(j));
					empleades.set(j, aux);
				}
			}
			System.out.println(empleades.get(i));
		}
		
	}

	private static void ListaPorFechaAlta(List<Empleade> empleades) {
		
		for(int i=0; i < empleades.size();i ++) {
			System.out.println(empleades.get(i).getNombre()+" Edad: "+empleades.get(i).calcularEdadDadoDeAlta()+" años.");
		}
		
	}

	private static void listadoPorEdad(List<Empleade> empleades) {
		Empleade aux;
		for(int i=0; i < empleades.size();i++) {
			for(int j=i+1; j < empleades.size();j++) {
				if(empleades.get(i).getFechaNacimiento().isAfter(empleades.get(j).getFechaNacimiento())) {
					aux= empleades.get(i);
					empleades.set(i, empleades.get(j));
					empleades.set(j, aux);
				}
			}
			
		}
		empleades.get(0).getDatos();
		empleades.getLast().getDatos();
		
	}

	private static void borradoPorDni(List<Empleade> empleades, Scanner teclado) {
		
		String dniaux;
		int encontrado;
		 System.out.println("Introduce DNI para buscar empleade");
		 dniaux= teclado.next();
		 encontrado= buscarDni(empleades, dniaux);
		 if(encontrado >= 0) {
			 empleades.remove(encontrado);
			 System.out.println("Empleade borrado correctamente");
		 }else {
			 System.out.println("No se ha encontrado ninugn empleade con ese DNI");
		 }
	}

	private static void consultaModificacion_PorDni(List<Empleade> empleades, Scanner teclado) {
		
		String resp;
		String dniaux;
		int encontrado;
		 System.out.println("Introduce DNI para buscar empleade");
		 dniaux= teclado.next();
		 encontrado= buscarDni(empleades, dniaux);
		 
		 if(encontrado>=0) {
			 System.out.println("Si desea consultar: c. Si desea modificar: m");
			 resp= teclado.next();
			 if(resp.equalsIgnoreCase("c")) {
				empleades.get(encontrado).getDatos();
			 }else {
				 empleades.get(encontrado).setDatos();
			 }
		 }else {
			 System.out.println("NO hay empleades con ese DNI");
		 }
	}

	private static int buscarDni(List<Empleade> empleades, String dniaux) {
		int encontrado= -1;
		for(int i =0; i < empleades.size() && encontrado==-1; i++) {
			if (empleades.get(i).getDni().equalsIgnoreCase(dniaux)) {
				encontrado = i;
			}
		}
		
		return encontrado;
	}

	private static void listado_PorApellido(List<Empleade> empleades, Scanner teclado) {
		
		Collections.sort(empleades);
		listado_Empleades(empleades);
		
	}

	private static void listado_Empleades(List<Empleade> empleades) {
		
		System.out.println("***********Empleades*************");
		for(Empleade empl : empleades) {
			empl.getDatos();
		}
		
	}

	private static void introducir_Empleades(List<Empleade> empleades, Scanner teclado) {
		String resp="si";
		Empleade emp;
		do {
			emp= new Empleade();
			emp.setDatos();
			empleades.add(emp);
			
			System.out.println("¿Deseas introducir otro empleade?");
			resp= teclado.next();
		}while(resp.equalsIgnoreCase("si"));
		
	}

	private static int menu(int opc, Scanner teclado) {
		
		System.out.println("1. Introducir empleade");
		System.out.println("2. Listtado de empleades");
		System.out.println("3. Listado de empleades ordenados por apellido");
		System.out.println("4. Consultar/Modificar datos de empleade a partir del DNI");
		System.out.println("5. Borrado de empleade apartir de DNI");
		System.out.println("6. lista de empleades indicando el mas joven y el mayor");
		System.out.println("7. Listado de la edad de los empleades en el momento que entraron a la empresa");
		System.out.println("8. Listado ordenado en desendente de la antiguedad de los empleades");
		System.out.println("9. Sorteo diario");
		System.out.println("10. Estadisticas");
		System.out.println("11. Salir");
		opc= teclado.nextInt();
		return opc;
		
		
	}

}
