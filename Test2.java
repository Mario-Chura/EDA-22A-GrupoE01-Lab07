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
}
