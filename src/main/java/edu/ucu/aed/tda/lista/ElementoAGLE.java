package edu.ucu.aed.tda.lista;

import java.util.function.Consumer;

/**
 * Nodo de un Árbol Genérico implementado mediante
 * Lista Enlazada de hijos (ListaEnlazadaAG).
 */
public class ElementoAGLE<T extends Comparable<T>> implements TElementoAGLE<T> {

    private T dato;
    private ListaEnlazadaAG<TElementoAGLE<T>> hijos;

    public ElementoAGLE(T dato) {
        this.dato = dato;
        this.hijos = new ListaEnlazadaAG<>();
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public ListaEnlazadaAG<TElementoAGLE<T>> getHijos() {
        return this.hijos;
    }

    @Override
    public boolean esHoja() {
        return hijos.esVacia();
    }

    @Override
    public void insertar(T datoPadre, T nuevoDato) {
        if (this.dato.compareTo(datoPadre) == 0) {
            hijos.insertar(new ElementoAGLE<>(nuevoDato));
            return;
        }

        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            nodoActual.getDato().insertar(datoPadre, nuevoDato);
            nodoActual = nodoActual.getSiguiente();
        }
    }

    @Override
    public TElementoAGLE<T> buscar(Comparable<T> criterioBusqueda) {
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            return this;
        }

        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            TElementoAGLE<T> encontrado = nodoActual.getDato().buscar(criterioBusqueda);
            if (encontrado != null) {
                return encontrado;
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return null;
    }

    @Override
    public int cantidadNodos() {
        int total = 1; // contamos este nodo
        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            total += nodoActual.getDato().cantidadNodos();
            nodoActual = nodoActual.getSiguiente();
        }
        return total;
    }

    @Override
    public int cantidadHojas() {
        if (esHoja()) {
            return 1;
        }

        int total = 0;
        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            total += nodoActual.getDato().cantidadHojas();
            nodoActual = nodoActual.getSiguiente();
        }
        return total;
    }

    @Override
    public int altura() {
        if (esHoja()) {
            return 0;
        }

        int alturaMax = 0;
        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            int altHijo = nodoActual.getDato().altura();
            if (altHijo > alturaMax) {
                alturaMax = altHijo;
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return 1 + alturaMax;
    }

    @Override
    public void preOrder(Consumer<TElementoAGLE<T>> consumidor) {
        consumidor.accept(this);
        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            nodoActual.getDato().preOrder(consumidor);
            nodoActual = nodoActual.getSiguiente();
        }
    }

    @Override
    public void postOrder(Consumer<TElementoAGLE<T>> consumidor) {
        NodoAG<TElementoAGLE<T>> nodoActual = hijos.getCabeza();
        while (nodoActual != null) {
            nodoActual.getDato().postOrder(consumidor);
            nodoActual = nodoActual.getSiguiente();
        }
        consumidor.accept(this);
    }
}
