<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Guía de Práctica de Laboratorio / Talleres / Centros de Simulación</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLE-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Hashing</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>07</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA DE PRESENTACIÓN:</td><td>14/08/2022</td><td>HORA DE PRESENTACIÓN: 11:55 pm</td><td colspan="3"></td>
</tr>
<tr><td colspan="3">INTEGRANTE(s):
<ul>
      			<li><a href="https://github.com/fernandocoylaA">Fernando Jesús Coyla Alvarez</a></li>
			<li><a href="https://github.com/Icielo23">Valery Cielo Iquise Mamani</a></li>
			<li><a href="https://github.com/Mario-Chura">Mario Franco Chura Puma</a></li>
</ul>
</td>
<td>NOTA:</td><td colspan="2"></td>
</<tr>
<tr><td colspan="6">DOCENTE(s):
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tbody>
</table>
</div>
  

  
<div align="center"><h2> SOLUCIÓN Y RESULTADOS </h2></div>

### I.	SOLUCIÓN DE EJERCICIOS/PROBLEMAS
#
La estrutura del presente laboratorio es la siguiente:

   

   ```sh

	    ├── EDA-22A-GrupoE01-Lab07
	        ├── Ejercicio_1
	        ├── HashTable.java
	        ├── Nodo.java
	        ├── Hash.java
	        ├── Test1.java
	        ├── Test2.java
	        └── Readme.md

   ```
   
   - En los archivos Test1 y Test2 se estará probando el código implementado.
   
1.  Implementar una tabla hash en base a los métodos definidos en la interfaz del archivo HashTable.java
	- Deben contemplar como mínimo el desarrollo de todos los métodos en su clase
	- Deben manejar las colisiones por Encadenamiento (Lista enlazada) y Sondeo Lineal.
	- Es posible agregar otros métodos que les ayuden a su resolución.
	- Crear un archivo de test donde incluyen casos de prueba.

- Primero se creo la clase 'Node.java' la cual guardara una clave y un valor; ademas se agregaron los metodos setter y getters 

```py
			public class Nodo<K, V> {
			    K key;
			    V value;

			    public Nodo(K key, V value) {
			        this.key = key;
			        this.value = value;
			    }
			}
			
   ```	
- Implementacion de la clase **Hash**

	- Su creacion consiste en **Clave/Valor** e implementa la clase *HashTable*
		```py
		public class Hash <K extends String, V extends Integer> implements HashTable<K, V>{
		 ...
		}
		```
	- Como atributos, cuenta con un arreglo de Objetos, un entero **size** para contabilizar los registros en la *tabla Hash*, y un entero final *length* para el tamaño de la *tablaHash*
		```py
		// Atributos 
    	private final Object[] valores;
    	private int size; 
    	private final int lenght;
		```
	- En el constructor recibe como parametro, el tamaño de *TablaHash*, se asigna el valor al atributo *lenght* y se inicializa el arreglo *valores* con el valor de *lenght*	
		```py
		public Hash(int lenght) {
            this.lenght = lenght;
            valores = new LinkedList[this.lenght];
    	}
		```
	- Asimismo se implemento un constructor de referencia *this()*
	
	- La operacion *hash* usada para retornar el valor index usada en el metodo **functionHash** es la siguiente
		```py
		(hashCode+1) % lenght;
		```
	- En el metodo **size** se retorna el valor del atributo *size* y en el metodo **isEmpty** retorna *true* si *size* tiene un valor igual a *cero*
	- En el metodo **containsKey**, retorna un booleno true si la tabla contiene una clave determinada.
	- Si la *key* ingresada es distinta de null, se asigna el *index* haciendo uso de *functionHash* y se crea una *lista enlazada*, la cual si es nula retornara *false* en caso contrario retornara el valor boleano de **!listInPosition.isEmpty()**
		```py
		int index = functionHash(key.hashCode()); //index de la key ingresada
        LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valores[index];
            	if(listInPosition == null) {
                    return false; //retorna false si la tabla no contiene la clave determinada
            	}else {
                    return !listInPosition.isEmpty();
               }
		```
	- Si la *key* ingresada es null, se mostrara la debida Excepcion 
	- El metodo **containsValue**, se encarga de retornar true. Si la tabla contiene uno o mas registros asociados a cierto valor especificado.
	- En un *forEach* recorriendo el arreglo *valores*. Si se cumple que los objetos son distintos a *null*, se le asigna el valor a *listInPosition*, para despues realizar un *forEach* que compara valor ingresado y los valores de *listInPosition* retornando *True* si son iguales. En otro caso retornara *False*
		```py
		 LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
         for (Nodo<K, V> aux : listInPosition) {                   
             if(value.equals(aux.getValue())){
                return true;
              }
         }
		```
	- El metodo **get**, se encarga de retornar el valor el cual corresponde a la clave o null si la tabla no contiene el registro para la clave.
	- Se realiza lo mismo que en anteriores metodos, obteniendo el index con *functionHash* y asignando en *listInPosition*
	- Si *listInPosition* es distinto a null se realiza un bucle *for* donde se retorna el valor *value* de la posicion correspondiente, si se cumple que la *key* ingresada es igual al valor *value* de *listInPosition*.En otro caso se retorna *null*
		```py
		for (Nodo<K, V> aux : listInPosition) {                    
             if (key.equals(aux.getKey())) {
                return aux.getValue();
             } else {
                return null;
             }
        }
		```
	- El metodo **put**,  se encarga de asociar el valor especificado con la clave especificada a la tabla hash, si la tabla contiene un registro previo para la clave, el valor existente es reemplazado por el nuevo valor ingresado. 
		```py
		if (listInPosition != null) {    //Para verificar que la posicion este inicializada
                listInPosition.push(new Nodo<>(key, value));
        } else { //De otro modo, se inicializa la posicion
              LinkedList<Nodo<K, V>> addListInPosition = new LinkedList<Nodo<K, V>>();
              addListInPosition.push(new Nodo<>(key, value));
              valores[index] = addListInPosition;
        }
         size++;
		```
	- El metodo **remove** se encarga de eliminar el registro de una clave, si la clave existe de otro modo null si no existe un registro para la clave.
	- Se sigue los mismos pasos que en los metodos anteriores, para despues dentro de un *forEach* realizar un condicional con la *key* ingresada y la *key* de la lista. Si se cumple su igualdad se realiza la operacion **remove**, se disminuye en uno el valor de *size* y se retorna el valor *Value* removido
		```py
		for (Nodo<K, V> aux : listInPosition) {
           if (key.equals(aux.getKey())) {
               listInPosition.remove(aux);
               size--;
               return aux.getValue();
           }
        }
		```
	- El metodo **clear** simplemente se encarga de eliminar todos los registros de la tabla hash
haciendo uso de un *forEach* donde se convierte a *null* los valores del arreglo y se cambio el valor de *size* a *cero*
	- El metodo **hashCode** retorna el codigo hash para toda la tabla hash.
	- Se crea una variable de tipo entero *result*, incializandola con valor igual a *uno*. Luego si la tabla no se encuentra vacia, se realiza un *forEach* con el arreglo *valores*, dentro de este si se cumple que los valores del arreglo son distintos a *null* se asignan a  la lista *listInPosition*, para luego realizar otra condicion que se valida con el contenido de *listInPosition* aumentando el valor de *result* con el *hashCode* de *listInPosition*, retornando *result*.
		```py
		for (Object valor : valores) {
           if(valor != null) {
              LinkedList<Nodo<K, V>> listInPosition = (LinkedList<Nodo<K, V>>) valor;
              if(! listInPosition.isEmpty()) {
                 result = result + listInPosition.getFirst().getKey().hashCode();
              }
           }
        }
		```
	- Si la tabla se encuentra vacia, se realizan debidas operaciones almacenando los valores en *result*, inclusive realizando una operacion si se cumple que el arreglo *valores* es igual a null. Retornando finalmente el valor de *result*
		```py
		result = result * 17 + lenght;
        result = result * 31 + size;
        result = result * (((valores == null))? 0 : Arrays.hashCode(valores));
        return result;
		```
	- Finalmente el metodo **toString**, implementado para que nos permita retornar todos los elementos de la tabla hash. Haciendo uso de la clase **StringBuilder** de Java que nos permite almacenar cadenas de caracteres de la tabla Hash y poder mostrarlo en consola.
	
	- __Ejecuciones__
		- Test 1:
	- En esta primera prueba se introdujo los valores directo en el código usando los métodos descritos anteriormente para ello tenemos como entrada lo siguiente:
	
		```py
			System.out.println("¿Cuantos elementos tiene nuestra tabla hash? ==> "+hash.size());
        		System.out.println("¿Se encuntra vacia la tabla hash? ==> " +  hash.isEmpty());
        		hash.put("eda", 15);
        		System.out.println("Ingresamos (eda,15)");
        		System.out.println("¿Cuantos elementos tiene nuestra tabla hash? ==> "+hash.size());
        		System.out.println("\n=====Recuperando clave 'eda'========> " + hash.get("eda"));
        		System.out.println("¿Se encuntra vacia la tabla hash? ==> " +  hash.isEmpty());
        		System.out.println("¿Se encuentra la clave='eda'? ======> " + hash.containsKey("eda"));
        		System.out.println("¿Se encuentra el valor='15'? =======> " + hash.containsKey("eda"));
        		System.out.println("¿Se encuentra el valor='25'? =======> " + hash.containsValue(25));
        		hash.put("edo", 25);
        		hash.put("pweba", 29);
        		hash.put("pdweb", 23);
        		hash.put("pwrb", 55);
        		hash.put("pwb", 65);
        		hash.put("pwed", 55);
        		hash.put("pwc", 65);
        		hash.put("pewb", 55);
        		hash.put("pwba", 65);
		```
		
	- Como resultado en consola tenemos lo siguiente:
	
		```py
			¿Cuantos elementos tiene nuestra tabla hash? ==> 0
			¿Se encuntra vacia la tabla hash? ==> true
			Ingresamos (eda,15)
			¿Cuantos elementos tiene nuestra tabla hash? ==> 1

			=====Recuperando clave 'eda'========> 15
			¿Se encuntra vacia la tabla hash? ==> false
			¿Se encuentra la clave='eda'? ======> true
			¿Se encuentra el valor='15'? =======> true
			¿Se encuentra el valor='25'? =======> false
			Hash = {
			Tamaño=10
			Longitud=11
			CodigoHash=7314896
			Elementos= {
				[<key=pwb, value=65>, <key=pwrb, value=55>, <key=pdweb, value=23>]
				[<key=pwc, value=65>, <key=pweba, value=29>]
				[<key=eda, value=15>]
				[<key=pewb, value=55>, <key=pwed, value=55>]
				[<key=edo, value=25>]
				[<key=pwba, value=65>]
				}
			}

			Tamaño de la tabla hash =======> 10

			¿Remueve el clave='pdweb'? =======> 23
			Hash = {
				Tamaño=9
				Longitud=11
				CodigoHash=7314896
				Elementos= {
					[<key=pwb, value=65>, <key=pwrb, value=55>]
					[<key=pwc, value=65>, <key=pweba, value=29>]
					[<key=eda, value=15>]
					[<key=pewb, value=55>, <key=pwed, value=55>]
					[<key=edo, value=25>]
					[<key=pwba, value=65>]
				}
			}

			Tamaño de la tabla hash =======> 9

			=====Recuperando clave 'pwba'========> 65
			Tamaño de la tabla hash =======> 9
		```
		- Test 2:
	- En la segunda prueba los valores se introducen por consola, para ello se hiso un menú en el cual se selecciona la operación que deseamos realizar:
	
		```py
			=====> MENU PRINCIPAL <=====

			1. Agregar entrada a la tabla
			2. Borrar entrada de la tabla
			3. Mostrar informacion de la tabla
			4. Contiene clave/valor
			5. Salir
			Escoge una opcion: 
		```
	- Se agregaron las siguientes claves y valores con la opción 1:
	
		```py
			<edo, 25> Si fue agregado
			<pfeba, 36> Si fue agregado
			<pdweb, 153> Si fue agregado
			<pwrb, 55> Si fue agregado
			<peb, 75> Si fue agregado
			<pfc, 15> Si fue agregado
			<pfc, 15> Si fue agregado
			<pwba, 56> Si fue agregado
			<eda, 25> Si fue agregado
		```
	- La opción 3 nos muestra la tabla hash:
	
		```py

			Hash = {
				Tamaño=9
				Longitud=11
				CodigoHash=117401206
				Elementos= {
					[<key=pwrb, value=55>, <key=pdweb, value=153>]
					[<key=rewb, value=55>]
				[<key=pfc, value=15>]
				[<key=peb, value=75>]
				[<key=eda, value=25>]
				[<key=pfeba, value=36>]
				[<key=edo, value=25>]
				[<key=pwba, value=56>]
				}
			}
		```
	- La opción 2 nos permite borrar:
	
		```py

			1. Agregar entrada a la tabla
			2. Borrar entrada de la tabla
			3. Mostrar informacion de la tabla
			4. Contiene clave/valor
			5. Salir
			Escoge una opcion: 2

			Ingresa la clave: pdweb
			La entrada <pdweb, 153> se borro de la tabla
			
			Resultado:
			
			Hash = {
				Tamaño=8
				Longitud=11
				CodigoHash=117401206
				Elementos= {
					[<key=pwrb, value=55>]
					[<key=rewb, value=55>]
					[<key=pfc, value=15>]
					[<key=peb, value=75>]
					[<key=eda, value=25>]
					[<key=pfeba, value=36>]
					[<key=edo, value=25>]
					[<key=pwba, value=56>]
				}
			}
		```
	- La opción 4 nos permite ver si tenemos la clave:
		```py

			1. Agregar entrada a la tabla
			2. Borrar entrada de la tabla
			3. Mostrar informacion de la tabla
			4. Contiene clave/valor
			5. Salir
			Escoge una opcion: 4

			Escoge una opcion
				1. ¿Contiene la clave?
				2. ¿Contiene el valor?
				3. Atras
			Ingresa una opcion: : 1

			Ingresa la clave: pwrb
			La tabla SI contiene la clave: pwrb
			1. ¿Contiene la clave?
			2. ¿Contiene el valor?
			3. Atras
			Ingresa una opcion: : 2
			Ingresa el valor a buscar (entero): : 156
			La tabla NO contiene el valor: 156
		```
#

### II.	SOLUCIÓN DEL CUESTIONARIO


#

### III.	CONCLUSIONES
# 
- El uso de la estructura Hash, nos permite resolver problemas con estructuras de simbolos porque permite la insecion y operaciones de Busqueda. Asimismo otro aplicacion de hash muy usada es en los videojuegos donde se requiere de un registro de las posiciones del jugador, usando esta estructura se logra guardar la posicion y mediante una funcion Hash almacenar su movimiento en una posicion, evitando problemas de que se repita una posicion ya ocupada. Es por estas y otras aplicaciones que es importante el estudio y practica de la Estructura Hash<br>  
- Una tabla hash tiene como principal ventaja que el acceso a los datos suele ser muy rápido si su razón de ocupación no es muy elevada porque si la ocupación es elevada se producen varias colisiones y la tabla se vuelve muy ineficiente, es por ello que debemos implementar una función que distribuya uniformemente las claves.  <br>
-  Las tablas hashing constituyen un TAD especialmente indicado para la manipulación y almacenamiento de la información en memoria secundaria. <br>
- La idea básica de las tablas hash consiste en transformar las claves en direcciones de memoria mediante una función de transformación. <br>

#
<div align="center"><h2>  RETROALIMENTACIÓN GENERAL </h2></div> <br>

<div align="center"><h2> REFERENCIAS Y BIBLIOGRAFÍA </h2></div> <br>

-   https://sites.google.com/a/espe.edu.ec/programacion-ii/home/tablas-hash
-   https://www.geeksforgeeks.org/hashtable-in-java/
-   Weiss, M.A.(1998). Data structures and problem solving using Java. Obtenido de https://drive.google.com/file/d/1qHBLI76NkcFd_zOmN_8wUY09mH48wqcU/view
-   http://bitybyte.github.io/Hashtables/
