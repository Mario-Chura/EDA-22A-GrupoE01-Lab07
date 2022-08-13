

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
  public V getValue() {
      return value;
  }

  public void setValue(V value) {
      this.value = value;
  }
  public boolean equals(Nodo<K, V> obj) {
      return false;
  }

  @Override
  public String toString() {
      return "<" + "key=" + key +", value=" + value + '>';
  }

}
