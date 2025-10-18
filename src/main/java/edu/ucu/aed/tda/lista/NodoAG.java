package edu.ucu.aed.tda.lista;

/**
 * Nodo simple para la lista enlazada usada en el Árbol Genérico.
 */
public class NodoAG<T> {

    private T dato;
    private NodoAG<T> siguiente;

    public NodoAG(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAG<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAG<T> siguiente) {
        this.siguiente = siguiente;
    }
}
