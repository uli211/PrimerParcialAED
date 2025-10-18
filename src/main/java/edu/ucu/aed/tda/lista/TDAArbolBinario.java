//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

public interface TDAArbolBinario<T extends Comparable<T>> {
    /**
     * Busca un dato según el criterio de búsqueda
     */
    T buscar(Comparable<T> criterioBusqueda);

    /**
     * Elimina el o los nodos según el criterio de búsqueda
     */
    boolean eliminar(Comparable<T> criterioBusqueda);

    /**
     * Agrega un dato al árbol.
     * Si el dato existe, no se agrega.
     */
    boolean insertar(T dato);

    /**
     * Recorre el árbol en in-order
     * {@snippet :
     * // ejemplo de uso
     * elemento.inOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void inOrder(Consumer<T> consumidor);

    /**
     * Recorre el árbol en pre-order
     * {@snippet :
     * // ejemplo de uso
     * elemento.preOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void preOrder(Consumer<T> consumidor);

    /**
     * Recorre el árbol en post-order
     * {@snippet :
     * // ejemplo de uso
     * elemento.postOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    void postOrder(Consumer<T> consumidor);

    /**
     * Devuelve true si el árbol es vacío
     */
    boolean esVacio();

    /**
     * Devuelve la cantidad de nodos del árbol
     **/
    int cantidadNodos();

    /**
     * Devuelve la cantidad de nodos que son hojas
     */
    int cantidadHojas();

    /**
     * Devuelve la cantidad de nodos que NO son hojas
     */
    int cantidadNodosInternos();
}
