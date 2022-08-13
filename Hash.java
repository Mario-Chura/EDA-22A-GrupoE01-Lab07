import java.util.Arrays;
import java.util.LinkedList;

public class Hash <K extends String, V extends Integer> implements HashTable<K, V>{
    // Atributos 
    private final Object[] valores;
    private int size; 
    private final int lenght;

    //Constructores
    public Hash(){
        this(11);
    }

    public Hash(int lenght) {
        this.lenght = lenght;
        valores = new LinkedList[this.lenght];
    }

    // Retorna el index para el vector de valores HashAbierto  
    private int functionHash (int hashCode) {
        return (hashCode+1) % lenght;
    }

    //Retorna el numero de clave-valor registrado en la tabla hash.
    public int size() {
        return size;
    }

    //Retorna true si la tabla hash no contiene ningun registro
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Retorna true Si la tabla contiene una clave determinada.
    public boolean containsKey(K key) {
        if(key != null) {
            int index = functionHash(key.hashCode());
            LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];
            if(listInPosition == null) {
                return false;
            }else {
                return !listInPosition.isEmpty();
            }
        }else {
            throw new NullPointerException();
        }
    }

    
}