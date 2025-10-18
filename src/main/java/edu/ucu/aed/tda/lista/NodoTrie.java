package edu.ucu.aed.tda.lista;

import java.util.function.Consumer;

/**
 * Nodo del Trie genérico implementado con arrays.
 * Cada nodo puede tener hasta 26 hijos (de 'a' a 'z').
 */
public class NodoTrie<T> implements TNodoTrie<T> {

    private static final int ALFABETO = 26;
    private NodoTrie<T>[] hijos;
    private boolean esFinPalabra;
    private T dato;

    @SuppressWarnings("unchecked")
    public NodoTrie() {
        this.hijos = new NodoTrie[ALFABETO];
        this.esFinPalabra = false;
        this.dato = null;
    }

    @Override
    public void recorrer(Consumer<String> consumer) {
        recorrer("", consumer);
    }

    private void recorrer(String prefijo, Consumer<String> consumer) {
        if (esFinPalabra) {
            consumer.accept(prefijo);
        }
        for (int i = 0; i < ALFABETO; i++) {
            if (hijos[i] != null) {
                char letra = (char) ('a' + i);
                hijos[i].recorrer(prefijo + letra, consumer);
            }
        }
    }

    @Override
    public Resultado<T> buscar(String palabra) {
        if (palabra.isEmpty()) {
            if (esFinPalabra) {
                return new Resultado<>(1, dato);
            } else {
                return new Resultado<>(0, null);
            }
        }

        char c = palabra.charAt(0);
        int indice = c - 'a';
        if (indice < 0 || indice >= ALFABETO || hijos[indice] == null) {
            return new Resultado<>(-1, null);
        }

        return hijos[indice].buscar(palabra.substring(1));
    }

    @Override
    public boolean insertar(String palabra, T dato) {
        if (palabra.isEmpty()) {
            if (esFinPalabra) {
                return false; // ya existía
            }
            esFinPalabra = true;
            this.dato = dato;
            return true;
        }

        char c = palabra.charAt(0);
        int indice = c - 'a';
        if (indice < 0 || indice >= ALFABETO) {
            return false; // carácter fuera del rango permitido
        }

        if (hijos[indice] == null) {
            hijos[indice] = new NodoTrie<>();
        }

        return hijos[indice].insertar(palabra.substring(1), dato);
    }

    @Override
    public TDALista<String> predecir(String prefijo) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();

        if (prefijo.isEmpty()) {
            // Agregar todas las palabras desde este nodo
            recorrer("", palabra -> lista.insertar(palabra));
            return lista;
        }

        char c = prefijo.charAt(0);
        int indice = c - 'a';

        if (indice < 0 || indice >= ALFABETO || hijos[indice] == null) {
            return lista; // vacío
        }

        TDALista<String> subLista = hijos[indice].predecir(prefijo.substring(1));
        TDANodo<String> nodoSub = ((ListaEnlazada<String>) subLista).encontrarNodoCabeza();

        while (nodoSub != null) {
            lista.insertar(prefijo.charAt(0) + nodoSub.getDato());
            nodoSub = nodoSub.getSiguiente();
        }

        return lista;
    }

    @Override
    public T getDato() {
        return esFinPalabra ? dato : null;
    }
}
