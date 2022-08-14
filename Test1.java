import java.util.Scanner;

public class Test1 {
    private static final int size = 11;
    static Hash<String, Integer> hash = new Hash<>(size); //Definimos el tamaño de nuestra tabla hash
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("¿Cuantos elementos tiene nuestra tabla hash? ==> "+hash.size());
        System.out.println("¿Se encuntra vacia la tabla hash? ==> " +  hash.isEmpty());
        // Ingresamos datos
        hash.put("eda", 15);
        System.out.println("Ingresamos (eda,15)");
        System.out.println("¿Cuantos elementos tiene nuestra tabla hash? ==> "+hash.size());
        System.out.println("\n=====Recuperando clave 'eda'========> " + hash.get("eda"));
        System.out.println("¿Se encuntra vacia la tabla hash? ==> " +  hash.isEmpty());
        System.out.println("¿Se encuentra la clave='eda'? ======> " + hash.containsKey("eda"));
        System.out.println("¿Se encuentra el valor='15'? =======> " + hash.containsKey("eda"));
        System.out.println("¿Se encuentra el valor='25'? =======> " + hash.containsValue(25));


    }
}
