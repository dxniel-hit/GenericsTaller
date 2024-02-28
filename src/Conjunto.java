import java.util.*;

public class Conjunto<T> implements Iterable<T> {

    //Atributos de la clase Conjunto.
    private static final int CAPACIDAD_INICIAL = 10; // CAPACIDAD_INICIAL es el tamaño inicial del arreglo que almacena los elementos del conjunto.
    private int capacidad; // capacidad es el tamaño del arreglo que almacena los elementos del conjunto.
    private int longitud; // longitud es el número de elementos que tiene el conjunto.
    private int conteoModificaciones; // conteoModificaciones sirve para llevar un control de las modificaciones que se hagan en el conjunto. Esto ayuda a evitar que se hagan modificaciones concurrentes.
    private Object[] elementos; // elementos es el arreglo que almacena los elementos del conjunto.

    /**
     * Constructor que recibe la capacidad inicial del conjunto.
     *
     * @param capacidad
     */
    public Conjunto() {
        this(CAPACIDAD_INICIAL);
    }

    /**
     * Constructor que recibe la capacidad inicial del conjunto.
     *
     * @param capacidad
     */
    public Conjunto(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.longitud = 0;
        this.conteoModificaciones = 0;
    }

    /**
     * Método que agrega un elemento al conjunto.
     *
     * @param elemento
     */
    public void agregar(T elemento) {
        if (elemento == null) {
            throw new NullPointerException("El elemento no puede ser nulo.");
        }
        if (estaContenido(elemento)) {
            return;
        }
        if (longitud == capacidad) {
            capacidad *= 2;
            elementos = Arrays.copyOf(elementos, capacidad);
        }
        elementos[longitud] = elemento;
        longitud++;
        conteoModificaciones++;
    }

    /**
     * Método que verifica si un elemento está contenido en el conjunto.
     *
     * @param elemento
     */
    public boolean estaContenido(T element) {
        for (int i = 0; i < longitud; i++) {
            if (elementos[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que imprime todos los elementos del conjunto.
     *
     * @param elemento
     */
    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < longitud; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(elementos[i]);
        }
        System.out.println("]");
    }

    /**
     * Método que añade todos los elementos de una colección al conjunto.
     *
     * @return
     */
    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            agregar(element);
        }
    }

    /**
     * Método que verifica si el conjunto es un subconjunto de otro conjunto.
     *
     * @param elemento
     */
    public boolean esSubconjunto(Conjunto<T> subconjunto) {
        if (subconjunto.longitud > this.longitud) {
            return false;
        }
        for (T element : subconjunto) {
            if (!estaContenido(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que hace la union de dos conjuntos.
     *
     * @param elemento
     */
    public void union(Conjunto<T> otherSet) {
        for (T element : otherSet) {
            agregar(element);
        }
    }

    /**
     * Método que devuelve un iterador para recorrer el conjunto.
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indice;
            private final int modificacionesEsperadas = conteoModificaciones;

            @Override
            public boolean hasNext() {
                if (modificacionesEsperadas != conteoModificaciones) {
                    throw new ConcurrentModificationException();
                }
                return indice < longitud;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elementos[indice++];
            }
        };
    }

}


