package edu.ucu.aed.tda.lista;

/**
 * Lista enlazada simple usada para representar los hijos
 * de cada nodo en un Árbol Genérico.
 * Nos libramos del Comparable que no es necesario y nos da problemas de tipos
 * 
 * No requiere que los elementos sean comparables.
 */
public class ListaEnlazadaAG<T> {

    private NodoAG<T> cabeza;
    private int tamanio;

    public ListaEnlazadaAG() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     */
    public void insertar(T dato) {
        NodoAG<T> nuevo = new NodoAG<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoAG<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }

        tamanio++;
    }

    /**
     * Devuelve el primer nodo de la lista.
     */
    public NodoAG<T> getCabeza() {
        return cabeza;
    }

    /**
     * Devuelve true si la lista no contiene elementos.
     */
    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Devuelve la cantidad de elementos en la lista.
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Imprime todos los elementos de la lista.
     */
    public void imprimir() {
        NodoAG<T> temp = cabeza;
        while (temp != null) {
            System.out.print(temp.getDato() + " ");
            temp = temp.getSiguiente();
        }
        System.out.println();
    }
}
