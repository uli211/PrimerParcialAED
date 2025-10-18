package edu.ucu.aed.tda.lista;

//import edu.ucu.aed.tda.lista.TDALista;

import java.util.function.Consumer;

public interface TNodoTrie<T> {
    void recorrer(Consumer<String> consumer);

    /**
     * Retorna
     * -1 si no se encuentra "palabra" en el trie
     * 1 si existe y es una palabra completa
     * 0 si existe y NO es una palabra completa
     */
    Resultado<T> buscar(String palabra);

    /**
     * retorna true si se agregó la palabra
     */
    boolean insertar(String palabra, T dato);

    /**
     * retorna todas las palabras en el trie que comienzan con prefijo
     */
    TDALista<String> predecir(String prefijo);

    /**
     * retorna un dato cuando el nodo es palabra, nulo en otro caso
     */
    T getDato();
}
