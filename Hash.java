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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}