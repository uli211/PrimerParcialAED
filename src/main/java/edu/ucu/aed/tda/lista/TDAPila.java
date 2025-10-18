//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public interface TDAPila<T extends Comparable<T>> extends TDALista<T> {
    /**
     *
     * @return Retorna el último elemento agregado, sin removerlo.
     * Si la pila es vacía, retornar nulo
     */
    T tope();

    /**
     *
     * @return Retorna el último elemento agregado y lo remueve de la pila.
     * Si la pila es vacía, retornar nulo
     */
    T sacar();

}
