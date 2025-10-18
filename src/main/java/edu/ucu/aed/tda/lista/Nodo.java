//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class Nodo<T extends Comparable<T>> implements TDANodo<T> {
    T dato;
    TDANodo<T> siguiente = null;
    TDANodo<T> anterior = null; // <-- FALTABA

    public Nodo(T val){
        this.dato = val;
    }

    @Override
    public TDANodo<T> getSiguiente(){
        return this.siguiente;
    }

    @Override
    public void setSiguiente(TDANodo<T> siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public TDANodo<T> getAnterior(){
        return this.anterior;
    }

    @Override
    public void setAnterior(TDANodo<T> anterior){
        this.anterior = anterior;
    }

    @Override
    public T getDato(){
        return this.dato;
    }
}
