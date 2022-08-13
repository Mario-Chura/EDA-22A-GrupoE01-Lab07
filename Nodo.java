

public class Nodo<K, V> {
  //Atributos
  K key;
  V value;
  
  //Constructor
  public Nodo(K key, V value) {
      this.key = key;
      this.value = value;
  }
  
  //Setter y Getter
  public K getKey() {
      return key;
  }

  public void setKey(K key) {
      this.key = key;
  }  

}
