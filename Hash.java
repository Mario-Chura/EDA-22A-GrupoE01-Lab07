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
    public boolean containsKey(K key) { //recibe la key, para validar su existencia
        if(key != null) {
            int index = functionHash(key.hashCode()); //index de la key ingresada
            LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];
            if(listInPosition == null) {
                return false; //retorna false si la tabla no contiene la clave determinada
            }else {
                return !listInPosition.isEmpty();
            }
        }else {
            throw new NullPointerException(); //es null, si no existe
        }
    }

    //Retorna true. Si la tabla contiene uno o mas registros asociados a cierto valor especificado.
    public boolean containsValue(V value) {
        for (Object valor : valores) {
            if (valor != null) {
                LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
                for (Nodo<K, V> aux : listInPosition) {                    
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

    //Elimina el registro de una clave, si la clave existe o null si no existe un registro para la clave.
    public V remove(Object key) {
        if(key != null){
            int index = functionHash(key.hashCode());
        
            LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];

            if(listInPosition != null) {
                
                for (Nodo<K, V> aux : listInPosition) {
                    if (key.equals(aux.getKey())) {
                        listInPosition.remove(aux);
                        size--;
                        return aux.getValue();
                    }
                }
                return null;
            }else {
                return null;
            }

        }else {
            throw new NullPointerException();
        }
    }

    //Elimina todos los registros de la tabla hash
    public void clear() {
        for (Object valor : valores) {
            valor = null;
            this.size = 0;
        }
    }

    //Retorna el codigo hash para TODA la tabla hash. 
    public int hashCode() {
        int result = 1;
        if( !this.isEmpty() ) {
            for (Object valor : valores) {
                if(valor != null) {
                    LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
                    if(! listInPosition.isEmpty()) {
                        result = result + listInPosition.getFirst().getKey().hashCode();
                    }
                }
            }
            return result;
        }else {
            result = result * 17 + lenght;
            result = result * 31 + size;
            result = result * (((valores == null))? 0 : Arrays.hashCode(valores));
            return result;
        }
    }

    //Retorna todos los elementos de la tabla hash.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashAbierto = {\n");
        sb.append("\tsize=").append(size).append("\n");
        sb.append("\tlenght=").append(lenght).append("\n");;
        sb.append("\thashCode=").append(this.hashCode()).append("\n");
        sb.append("\telements = {").append("\n");
        for(Object valor : this.valores){
            if(valor != null) {
                LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
                if (!listInPosition.isEmpty()) {
                    sb.append("\t\t").append(valor.toString()).append("\n");
                }
            }
        }
        sb.append("\t}").append("\n");
        sb.append("}").append("\n");

        return sb.toString();
    }
    
}