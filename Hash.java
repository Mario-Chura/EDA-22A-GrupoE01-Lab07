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

    //Retorna true. Si la tabla contiene uno o mas registros asociados a cierto valor especificado.
    public boolean containsValue(V value) {
        for (Object valor : valores) {
            if (valor != null) {
                LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
                for (Nodo<K, V> aux : listInPosition) {
                    //System.out.println(aux.getValue());
                    if(value.equals(aux.getValue())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Retorna el valor el cual corresponde a la clave o null si la tabla no contiene el registro para la clave.
    public V get(K key) {
        if(key != null){
            int index = functionHash(key.hashCode());            
            LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];

            if(listInPosition != null) {               
                for (Nodo<K, V> aux : listInPosition) {                    
                    if (key.equals(aux.getKey())) {
                        return aux.getValue();
                    } else {
                        return null;
                    }
                }
            }else {
                return null;
            }

        }else {
            throw new NullPointerException();
        }
        return null;
    }

    /*
     * Asocia el valor especificado con la clave especificada a la tabla hash
     * Si la tabla tiene un registro previo para la clave,
     * el valor viejo es reemplazado por el nuevo valor ingresado. 
    */
    public void put(K key, V value) {
        if(key != null) {
            int index = functionHash(Math.abs(key.hashCode()));         
            LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];
            if (listInPosition != null) { //Para verificar que la posicion este inicializada
                listInPosition.push(new Nodo<>(key, value));
            } else { //De otro modo, se inicializa la posicion
                LinkedList<Nodo<K, V>> addListInPosition = new LinkedList<Nodo<K, V>>();
                addListInPosition.push(new Nodo<>(key, value));
                valores[index] = addListInPosition;
            }
            size++;

        }else {
            throw new NullPointerException();
        }
    }
    
}