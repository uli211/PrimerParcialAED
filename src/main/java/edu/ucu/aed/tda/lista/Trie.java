package edu.ucu.aed.tda.lista;

import java.util.function.Consumer;

/**
 * Implementación de un Trie (árbol de prefijos) usando arrays de hijos.
 */
public class Trie<T> implements TTrie<T> {

    private NodoTrie<T> raiz;

    public Trie() {
        this.raiz = new NodoTrie<>();
    }

    @Override
    public void recorrer(Consumer<String> consumer) {
        raiz.recorrer(consumer);
    }

    @Override
    public Resultado<T> buscar(String palabra) {
        return raiz.buscar(palabra.toLowerCase());
    }

    @Override
    public boolean insertar(String palabra, T dato) {
        return raiz.insertar(palabra.toLowerCase(), dato);
    }

    @Override
    public TDALista<String> predecir(String prefijo) {
        return raiz.predecir(prefijo.toLowerCase());
    }
}
