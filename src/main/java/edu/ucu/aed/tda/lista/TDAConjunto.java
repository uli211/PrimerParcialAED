//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
/**
 * Representa un conjunto con sus operaciones vinculadas
 */
public interface TDAConjunto<T extends Comparable<T>> extends TDALista<T> {
    /**
     * Realiza la unión del conjunto actual con "otroConjunto".
     * Se retorna un nuevo conjunto donde los elementos no están duplicados.
     */
    TDAConjunto<T> union(TDAConjunto<T> otroConjunto);

    /**
     * Realiza la intersección del conjunto actual con "otroConjunto".
     * Se retorna un nuevo conjunto donde los elementos no están duplicados.
     */
    TDAConjunto<T> interseccion(TDAConjunto<T> otroConjunto);

    /**
     * Realiza la diferencia del conjunto actual con "otroConjunto".
     * Se retorna un nuevo conjunto donde los elementos no están duplicados.
     */
    TDAConjunto<T> diferencia(TDAConjunto<T> otroConjunto);

    TDANodo<T> encontrarNodoCabeza(); //Nadie vio nada.... 


}
