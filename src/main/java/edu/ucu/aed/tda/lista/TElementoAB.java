//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Modela un nodo del árbol binario.
 * La implementación de esta estructura debe ser recursiva.
 */
public interface TElementoAB<T extends Comparable<T>> {

    /**
     * Asigna el nodo izquierdo del nodo actual. Puede ser nulo.
     */
    void setHijoIzquierdo(TElementoAB<T> hijoIzquierdo);

    /**
     * Asigna el nodo derecho del nodo actual. Puede ser nulo.
     */
    void setHijoDerecho(TElementoAB<T> hijoDerecho);

    /**
     * Devuelve el hijo derecho del nodo actual. El valor es nulo si no tiene hijo derecho.
     */
    TElementoAB<T> getHijoIzquierdo();

    /**
     * Devuelve el hijo izquierdo del nodo actual. El valor es nulo si no tiene hijo izquierdo.
     */
    TElementoAB<T> getHijoDerecho();

    /**
     * Actualiza el dato del nodo actual.
     */
    void setDato(T dato);

    /**
     * devuelve el dato del nodo actual.
     */
    T getDato();

    /**
     * Busca un nodo por un criterio de búsqueda.
     * Si no se encuentra, retorna nulo.
     */
    TElementoAB<T> buscar(Comparable<T> criterioBusqueda);

    /**
     * Elimina un nodo del árbol según el criterio de búsqueda.
     * Si se encuentra, se retorna el nodo borrado. En otro caso retornar null.
     */
    TElementoAB<T> eliminar(Comparable<T> criterioBusqueda);

    /**
     * Agrega un nuevo elemento al árbol
     * Si el nuevoDato existe, no se agrega
     */
    void insertar(T nuevoDato);

    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.inOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void inOrder(Consumer<TElementoAB<T>> consumidor);

    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.preOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void preOrder(Consumer<TElementoAB<T>> consumidor);

    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.postOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void postOrder(Consumer<TElementoAB<T>> consumidor);

    /**
     * retornar true si el nodo es hoja
     */
    boolean esHoja();

    /**
     * retorna la cantidad de nodos que son hijas
     */
    int cantidadHojas();

    /**
     * retorna la cantidad de nodos que no son hojas
     */
    int cantidadNodosInternos();

    /**
     * retorna la cantidad de nodos que los compone
     */
    int cantidadNodos();

    /**
     * retorna la altura de este nodo
     */
    int altura();

    /**
     * retornar el nivel relativo del nodo que coincide con el criterio de búsqueda
     * si no se encuentra, retorna -1
     */
    int obtenerNivel(Comparable<T> criterioBusqueda);

    //Funciones para AB
    void insertarSinOrden(T nuevoDato);
    TElementoAB<T> buscarSinOrden(Comparable<T> criterioBusqueda);
    TElementoAB<T> eliminarSinOrden(Comparable<T> criterioBusqueda);

    //Funciones para AVL
    int getAltura(); 

    void setAltura(int altura);

    void actualizarAltura(); //Actualiza la altura del nodo en base a sus hijos.

    int getBalance(); //Retorna el factor de balance del nodo: altura(izq) - altura(der).

    TElementoAB<T> rotacionDerecha(); //Rotación simple a la derecha.

    TElementoAB<T> rotacionIzquierda(); //Rotación simple a la izquierda.

    TElementoAB<T> rotacionIzquierdaDerecha(); //Rotación doble: izquierda-derecha.

    TElementoAB<T> rotacionDerechaIzquierda(); // Rotación doble: derecha-izquierda.

}
