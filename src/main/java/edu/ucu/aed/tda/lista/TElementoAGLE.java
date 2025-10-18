package edu.ucu.aed.tda.lista;

import java.util.function.Consumer;

/**
 * Modela un nodo del Árbol Genérico implementado
 * mediante Lista Enlazada de hijos (ListaEnlazadaAG).
 * 
 * @param <T> tipo de dato almacenado en cada nodo
 */
public interface TElementoAGLE<T extends Comparable<T>> {

    /**
     * Asigna el dato al nodo actual.
     */
    void setDato(T dato);

    /**
     * Devuelve el dato almacenado en este nodo.
     */
    T getDato();

    /**
     * Devuelve la lista enlazada de hijos del nodo actual.
     */
    ListaEnlazadaAG<TElementoAGLE<T>> getHijos();

    /**
     * Inserta un nuevo nodo con dato "nuevoDato" como hijo del nodo
     * que contiene el dato "datoPadre". Si el padre no existe, no hace nada.
     */
    void insertar(T datoPadre, T nuevoDato);

    /**
     * Busca un nodo dentro del árbol (subárbol) que contenga
     * el dato indicado por "criterioBusqueda".
     * 
     * @param criterioBusqueda dato buscado
     * @return el nodo encontrado o null si no existe
     */
    TElementoAGLE<T> buscar(Comparable<T> criterioBusqueda);

    /**
     * Devuelve la cantidad total de nodos en este subárbol.
     */
    int cantidadNodos();

    /**
     * Devuelve la cantidad total de hojas en este subárbol.
     */
    int cantidadHojas();

    /**
     * Devuelve la altura del subárbol cuya raíz es este nodo.
     */
    int altura();

    /**
     * Recorre el subárbol en preorden.
     */
    void preOrder(Consumer<TElementoAGLE<T>> consumidor);

    /**
     * Recorre el subárbol en postorden.
     */
    void postOrder(Consumer<TElementoAGLE<T>> consumidor);

    /**
     * Retorna true si el nodo actual no tiene hijos.
     */
    boolean esHoja();
}
