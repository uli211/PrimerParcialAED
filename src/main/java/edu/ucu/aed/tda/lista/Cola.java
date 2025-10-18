//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class Cola<T extends Comparable<T>> implements TDACola<T> {

    private ListaEnlazada<T> listaInterna; // Creamos la lista que en verdad es la Cola y luego seteamos las funciones con lo que corresponda respetando la firma de TDALista

    public Cola() {
        this.listaInterna = new ListaEnlazada<>();
    }

    @Override
    public T obtenerPorIndice(int indice){
        return listaInterna.obtenerPorIndice(indice);
    }

    @Override
    public boolean insertar(T data) {
        
        return listaInterna.insertar(data);
    }

    @Override
    public T buscar(Comparable<T> identificador) {
        return listaInterna.buscar(identificador);
    }

    @Override
    public T eliminar(Comparable<T> identificador) {
        return listaInterna.eliminar(identificador);
    }

    @Override
    public String imprimir() {
        return listaInterna.imprimir();
    }

    @Override
    public String imprimir(String delimitador) {
        return listaInterna.imprimir(delimitador);
    }

    @Override
    public int cantElementos() {
        return listaInterna.cantElementos();
    }

    @Override
    public boolean esVacia() {
        return listaInterna.esVacia();
    }

    // Ahora sí, métodos propios de la cola:

    @Override
    public T frente() {
        // el primer elemento de la lista
        System.out.println("Primer elemento de la cola: " + listaInterna.getCabeza()); 
        return listaInterna.getCabeza(); 
    }

    @Override
    public T quitarDeCola() {
        // eliminar el primer elemento
        //System.out.println("Elemento quitado de cola: " + listaInterna.getCabeza()); no necesario, insertar de lista ya lo hace
        return listaInterna.eliminar(listaInterna.getCabeza());
    }

    @Override
    public boolean ponerEnCola(T elemento) {

        //System.out.println("Elemento inesrtado en cola: " + elemento);
        return listaInterna.insertar(elemento);
    }
}

