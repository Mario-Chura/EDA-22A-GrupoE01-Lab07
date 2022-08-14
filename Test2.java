import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {
	private static final int size = 11;
	static Hash<String, Integer> hash = new Hash<>(size);
	static Scanner scan = new Scanner(System.in); 

    public static void Menu() {
		StringBuilder str = new StringBuilder();
		str.append("\n1. Agregar entrada a la tabla\n");
		str.append("2. Borrar entrada de la tabla\n");
		str.append("3. Mostrar informacion de la tabla\n");
		str.append("4. Contiene clave/valor\n");
		str.append("5. Salir");

		System.out.println(str.toString());
	}
	public static String ingresarClave() {
		String key = "";
		while(true) {
			System.out.print("\nIngresa la clave: ");
			try {
				key = scan.next();
			}catch (Exception e) {
				System.err.println(e);
				scan.nextLine();
			}
			if(!key.equals("")){
				break;
			}
		}
		return key;
	}
	public static int ingresarNumero(String label) {
		int value = 0;
		while(true) {
			System.out.print(label + ": ");
			try {
				value = scan.nextInt();
			}catch (Exception e) {
				System.err.println(e);
				scan.nextLine();
			}
			if(value != 0){
				break;
			}
		}
		return value;
	}

	public static void agregar() {
		String key = ingresarClave();
		int value = ingresarNumero("Ingresa el valor (entero)");
		hash.put(key, value);
		System.out.println("<"+ key +", " + value+ "> Si fue agregado" );
	}

	public static void borrar() {
		String key = ingresarClave();
		Object a = null;
		try {
			a = hash.remove(key);
		}catch (Exception e){
			System.err.println(e);
		}
		if(a == null) {
			System.out.println("No se realizo borrado");
		}else{
			System.out.println("La entrada <" + key +", "+ a +"> se borro de la tabla");
		}
	}

	public static void mostrar() {
		System.out.println(hash);
	}

	public static void buscarClave() {
		String key = ingresarClave();
		String rpta = "";

		if(hash.containsKey(key))
			rpta = "SI";
		else
			rpta = "NO";

		System.out.println("La tabla " + rpta +" contiene la clave: "+key);
	}

	public static void buscarValor() {
		int valor = ingresarNumero("Ingresa el valor a buscar (entero): ");
		String rpta = "";

		if(hash.containsValue(valor))
			rpta = "SI";
		else
			rpta = "NO";

		System.out.println("La tabla " + rpta +" contiene el valor: "+valor);
	}

	public static void contieneValor() {
		int seleccion = 0;
		System.out.println("\nEscoge una opcion");
		while(seleccion != -1) {
			System.out.println("\t1. ¿Contiene la clave?");
			System.out.println("\t2. ¿Contiene el valor?");
			System.out.println("\t3. Atras");
			seleccion = ingresarNumero("Ingresa una opcion: ");

			switch(seleccion) {
			case 1:
				buscarClave();
				break;
			case 2:
				buscarValor();
				break;
			case 3:
				seleccion = -1;
				break;
			default:
				System.out.println("\nEscoge una opcion de la lista:");
				break;
			}
		}
	}

}
