package repaso_java.Ejercicio7;

import java.util.*;

public class Principal {

	static ArrayList<Estudiante> Lista_Estudiantes = new ArrayList<Estudiante>();
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		boolean bucle = true;
		while (bucle) {
			System.out.println("---------------------------------------------"
					+ "\nBienvenido al programa de estudiantes" + "\n---------------------------------------------"
					+ "\n1.- Dar de alta un estudiante" + "\n2.- Dar de baja un estudiante"
					+ "\n3.- Modificar datos de un estudiante" + "\n4.- Consultar datos de un estudiante"
					+ "\n4.- Cambiar nota de un estudiante" + "\n5.- Listar estudiantes" + "\n6.- Salir"
					+ "\n---------------------------------------------");
			System.out.print("Introduce una opción:");
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1:
				Alta_Estudiante();
				break;
			case 2:
				Baja_Estudiante();
				break;
			case 3:
				Modificar_Estudiante();
				break;
			case 4:
				Consultar_Estudiante();
				break;
			case 5:
				Listar_Estudiantes();
				break;
			case 6:
				bucle = false;
				break;
			default:
				break;
			}
		}
	}

	public static void Alta_Estudiante() {

		System.out.println("Introduce el nombre:");
		String nombre = teclado.nextLine();
		System.out.println("Introduce la edad:");
		int edad = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el DNI:");
		String dni = teclado.nextLine();
		System.out.println("Introduce la nota:");
		float nota = teclado.nextFloat();
		teclado.nextLine();
		System.out.println("Introduce la clase:");
		String clase = teclado.nextLine();

		Estudiante estudiante = new Estudiante(nombre, edad, dni, nota, clase);
		Lista_Estudiantes.add(estudiante);

		System.out.println("Estudiante dado de alta correctamente");

	}

	public static void Baja_Estudiante() {
		System.out.println("¿Cuál es el nombre del estudiante a dar de baja?");
		String nombre = teclado.nextLine();

		Iterator iter = Lista_Estudiantes.iterator();
		Estudiante estudiante_aux;

		while (iter.hasNext()) {
			estudiante_aux = (Estudiante) iter.next();
			if (estudiante_aux.getNombre().equals(nombre)) {
				Lista_Estudiantes.remove(estudiante_aux);
				System.out.println("El estudiante: " + nombre + "ha sido borrado.");
			} else {
				System.out.println("No se encuentra el estudiante");
			}
			break;
		}
	}

	public static void Modificar_Estudiante() {

		System.out.println("Introduce el alumno que quieres modificar:");
		String nombre = teclado.nextLine();

		int opcion = 0;
		boolean bucle = true;
		while (bucle) {
			System.out.println("---------------------------------------------" + "\n¿Qué deseas modificar?"
					+ "\n---------------------------------------------" + "\n1.- Nombre" + "\n2.- Edad" + "\n3.- DNI"
					+ "\n4.- Nota" + "\n4.- Clase" + "\n5.- Salir" + "\n---------------------------------------------");
			System.out.print("Introduce una opción:");
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1:
				Iterator iter = Lista_Estudiantes.iterator();
				Estudiante estudiante_aux;

				while (iter.hasNext()) {
					estudiante_aux = (Estudiante) iter.next();
					if (estudiante_aux.getNombre().equals(nombre)) {
						System.out.println("¿Qué nombre deseas ponerle?");
						String nombre_nuevo = teclado.nextLine();
						estudiante_aux.setNombre(nombre_nuevo);
						System.out.println("El estudiante: " + nombre + "ha sido cambiado.");
					} else {
						System.out.println("No se encuentra el estudiante");
					}
				}
				break;
			case 2:
				Iterator iter1 = Lista_Estudiantes.iterator();
				Estudiante estudiante_aux1;

				while (iter1.hasNext()) {
					estudiante_aux1 = (Estudiante) iter1.next();
					if (estudiante_aux1.getNombre().equals(nombre)) {
						System.out.println("¿Qué nota deseas ponerle a " + nombre + "?");
						int nota_nueva = teclado.nextInt();
						teclado.nextLine();
						estudiante_aux1.setNota(nota_nueva);
						System.out.println("Se le ha cambiado la nota por un " + nota_nueva);
					} else {
						System.out.println("No se encuentra el estudiante");
					}
				}
				break;
			case 3:
				break;
			case 4:
				System.out.println("Esto se hace desde el menú principal");
				break;
			case 5:
				bucle = false;
				break;
			default:
				break;
			}
		}

	}

	public static void Consultar_Estudiante() {

	}

	public static void Listar_Estudiantes() {

		int contador = 1;

		Iterator iter = Lista_Estudiantes.iterator();
		Estudiante estudiante_aux;
		while (iter.hasNext()) {
			estudiante_aux = (Estudiante) iter.next();
			System.out.print(contador + " " + estudiante_aux.getNombre() + " " + estudiante_aux.getEdad() + " "
					+ estudiante_aux.getDNI() + " " + estudiante_aux.getNota() + " " + estudiante_aux.getClase()
					+ "\n");
		}
		if (Lista_Estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes");
		}
	}
}
