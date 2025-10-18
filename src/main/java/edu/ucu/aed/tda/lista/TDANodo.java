//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
/**
 * Representa el nodo utilizado para implementar listas enlazadas
 */
public interface TDANodo<T extends Comparable<T>> {
    TDANodo<T> getSiguiente();

    void setSiguiente(TDANodo<T> siguiente);

    T getDato();

    TDANodo<T> getAnterior(); //Pensada para implementar LinkedList

    void setAnterior(TDANodo<T> anterior); //Pensada para implementar LinkedList
}
