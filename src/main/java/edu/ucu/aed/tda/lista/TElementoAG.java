//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Modela un nodo del árbol genérico (n hijos).
 * Representación utilizada: Primer Hijo / Siguiente Hermano.
 */
public interface TElementoAG<T extends Comparable<T>> {

    /**
     * Asigna el primer hijo del nodo actual.
     */
    void setPrimerHijo(TElementoAG<T> primerHijo);

    /**
     * Asigna el siguiente hermano del nodo actual.
     */
    void setHermanoDerecho(TElementoAG<T> hermanoDerecho);

    /**
     * Devuelve el primer hijo del nodo actual (puede ser null).
     */
    TElementoAG<T> getPrimerHijo();

    /**
     * Devuelve el siguiente hermano del nodo actual (puede ser null).
     */
    TElementoAG<T> getHermanoDerecho();

    /**
     * Actualiza el dato del nodo actual.
     */
    void setDato(T dato);

    /**
     * Devuelve el dato almacenado en el nodo.
     */
    T getDato();

    /**
     * Busca recursivamente un nodo cuyo dato coincida con el criterio de búsqueda.
     * Si no se encuentra, retorna null.
     */
    TElementoAG<T> buscar(Comparable<T> criterioBusqueda);

    /**
     * Inserta un nuevo dato bajo el nodo cuyo dato coincide con datoPadre.
     * Si el padre no existe, no inserta nada.
     */
    void insertar(T datoPadre, T nuevoDato);

    /**
     * Devuelve true si el nodo es hoja (sin hijos).
     */
    boolean esHoja();

    /**
     * Devuelve la cantidad total de nodos en el subárbol.
     */
    int cantidadNodos();

    /**
     * Devuelve la cantidad de hojas en el subárbol.
     */
    int cantidadHojas();

    /**
     * Devuelve la altura del subárbol cuya raíz es este nodo.
     */
    int altura();

    /**
     * Recorre el subárbol en preorden aplicando la acción recibida.
     */
    void preOrder(Consumer<TElementoAG<T>> consumidor);

    /**
     * Recorre el subárbol en postorden aplicando la acción recibida.
     */
    void postOrder(Consumer<TElementoAG<T>> consumidor);
}
